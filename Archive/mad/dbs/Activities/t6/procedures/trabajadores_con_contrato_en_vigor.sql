USE 23_db_Daniel_nominas;

#-- Solicitar trabajadores con contrato en vigor en fecha especificada
DROP PROCEDURE IF EXISTS trabajadores_con_contrato_en_vigor;

DELIMITER &&
CREATE PROCEDURE trabajadores_con_contrato_en_vigor(IN mes INT, IN anho INT)
    BEGIN
        SELECT t.trabajador_id AS "ID", t.nombre AS "Nombre", CONCAT(t.ape1, " ", t.ape2) AS "Apellidos"
            FROM trabajadores AS t
            INNER JOIN contratos AS c
            ON c.trabajador_id = t.trabajador_id
            WHERE dias_trabajados(mes, anho, c.contrato_id) > 0;
    END&&
DELIMITER ;