USE 23_db_Daniel_nominas;

#--Función de total de devengos
DROP FUNCTION IF EXISTS total_devengo;

DELIMITER &&
CREATE FUNCTION total_devengo(mes INT, anho INT, id INT)
    RETURNS INT
    BEGIN
        DECLARE conceptos, dias INT;

        SELECT SUM(c.cantidad) INTO conceptos
            FROM contratos AS con
            INNER JOIN conceptos_de_salario AS c
            ON c.contrato_id = con.contrato_id
            WHERE con.contrato_id = id;
        
        SET dias := dias_trabajados(mes, anho, id);

        RETURN (conceptos / 30) * dias;
    END&&
DELIMITER ;