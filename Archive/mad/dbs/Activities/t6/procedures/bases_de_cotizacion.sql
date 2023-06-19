USE 23_db_Daniel_nominas;

#-- Calcula y muestra la base de cotización de un trabajador
DROP PROCEDURE IF EXISTS base_de_cotizacion;

DELIMITER &&
CREATE PROCEDURE base_de_cotizacion(IN mes INT, IN anho INT, IN id INT)
    BEGIN
        DECLARE base_cot, devengo INT;
        
        SET devengo := total_devengo(mes, anho, id);
        SET base_cot := tomar_base_de_cotizacion(mes, anho, id);
        
        SELECT CONCAT(base_cot, '€') AS '', CONCAT('(', (devengo / base_cot) * 100, '%)') AS '';
    END&&
DELIMITER ;