/* INFORMACIÓN ADICIONAL EN 6.1.md */
USE 23_db_Daniel;

#-- Apartado 1 - Actualizar tabla y generar sistemas de actualización
CREATE TABLE CuentasDobles (
    doble_id        INT     UNSIGNED    AUTO_INCREMENT,
    cliente_id      INT     UNSIGNED,
    cuenta_id       INT     UNSIGNED,
    ahorro_id       INT     UNSIGNED,
    PRIMARY KEY (doble_id)
);

ALTER TABLE CuentasDobles
    ADD CONSTRAINT fk_cliente_id
        FOREIGN KEY (cliente_id) REFERENCES Clientes (cliente_id);

ALTER TABLE CuentasDobles
    ADD CONSTRAINT fk_cuenta_id
        FOREIGN KEY (cuenta_id) REFERENCES CuentasCorrientes (cuenta_id);

ALTER TABLE CuentasDobles
    ADD CONSTRAINT fk_ahorro_id
        FOREIGN KEY (ahorro_id) REFERENCES CuentasAhorros (ahorro_id);

ALTER TABLE CuentasCorrientes
    DROP KEY fk_cliente_id;

DROP PROCEDURE IF EXISTS transferir_cuenta_doble;
DELIMITER &&
CREATE PROCEDURE transferir_cuenta_doble (IN dbl_id INT)
    BEGIN
        DECLARE corriente, ahorro, cnt_id, hrr_id, diferencia INT;

        DECLARE EXIT HANDLER FOR 1217
        BEGIN
            ROLLBACK;
            SELECT 'Se ha producido un error inesperado, cancelando operación' AS 'ERROR';
        END;

        SELECT cuenta_id, ahorro_id INTO cnt_id, hrr_id FROM CuentasDobles WHERE doble_id = dbl_id;
        SELECT saldo INTO corriente FROM CuentasCorrientes WHERE cuenta_id = cnt_id;

        SET diferencia := corriente - 1000;

        IF diferencia > 0 THEN
            UPDATE CuentasCorrientes SET saldo = 1000 WHERE cuenta_id = cnt_id;
            SELECT saldo INTO ahorro FROM CuentasAhorros WHERE ahorro_id = hrr_id;
            UPDATE CuentasAhorros SET saldo = diferencia + ahorro WHERE ahorro_id = hrr_id;
        END IF;
    END&&
DELIMITER ;

DROP EVENT IF EXISTS event_actualizar_cuentas_dobles;
DELIMITER &&
CREATE EVENT event_actualizar_cuentas_dobles
    ON SCHEDULE EVERY 1 MONTH
    DO
    BEGIN
        DECLARE max_cuenta INT;

        SELECT doble_id INTO max_cuenta FROM CuentasDobles ORDER BY doble_id DESC LIMIT 1;

        FOR id IN 1 .. max_cuenta DO
            IF id IS NOT NULL THEN
                CALL event_actualizar_cuentas_dobles(id);
            END IF;
        END FOR;
    END&&
DELIMITER ;

#-- Apartado 3
DROP TRIGGER IF EXISTS control_de_descubierto;
DELIMITER &&
CREATE TRIGGER control_de_descubierto
    BEFORE UPDATE ON CuentasCorrientes
    FOR EACH ROW
    BEGIN
        DECLARE hrr_id, ahorro, diferencia INT;
        DECLARE inter REAL;
        
        IF NEW.saldo < 0
        THEN
            SELECT ahorro_id, saldo, interes INTO hrr_id, ahorro, inter FROM CuentasAhorros NATURAL JOIN CuentasDobles WHERE cuenta_id = NEW.cuenta_id LIMIT 1;
            SET diferencia := ahorro + NEW.saldo;
            SET diferencia := diferencia - diferencia * inter;
            IF diferencia > 0 THEN
                SET NEW.saldo := 0;
                UPDATE CuentasAhorros SET saldo = diferencia WHERE ahorro_id = hrr_id;
            ELSE
                SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Cuenta al descubierto';
            END IF;
        END IF;
    END&&
DELIMITER ;
