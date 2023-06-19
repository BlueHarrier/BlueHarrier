USE 23_db_Daniel_nominas;

#-- Genera y muestrar todas las nóminas de los trabajadores con un contrato en vigor
DROP PROCEDURE IF EXISTS generar_nominas;

DELIMITER &&
CREATE PROCEDURE generar_nominas(IN mes INT, IN anho INT)
    BEGIN
        DECLARE id_max INT;

        SELECT contrato_id INTO id_max
            FROM contratos
            ORDER BY contrato_id
            DESC LIMIT 1;
        
        FOR id IN 1 .. id_max DO
            IF dias_trabajados(mes, anho, id) > 0 THEN
                CALL generar_nomina(mes, anho, id);
            END IF;
        END FOR;
    END&&
DELIMITER ;