USE 23_db_Daniel_nominas;

#-- Calcula los deducciones del trabajador en un mes concreto
DROP PROCEDURE IF EXISTS deducciones;

DELIMITER &&
CREATE PROCEDURE deducciones(IN mes INT, IN anho INT, IN id INT)
    BEGIN
        SELECT td.nombre AS 'Tipo de deducción', CONCAT(d.cantidad, '€') AS 'Cantidad'
            FROM deducciones AS d
            INNER JOIN tipos_de_deducciones AS td
            ON d.tipo_deduccion_id = td.tipo_deduccion_id
            WHERE d.contrato_id = id AND d.mes = mes AND d.anho = anho;
        
        SELECT CONCAT('Total deducciones ', total_deduccion(mes, anho, id), '€') AS '';
    END&&
DELIMITER ;