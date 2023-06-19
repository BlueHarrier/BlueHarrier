USE 23_db_Daniel_nominas;

#-- Calcula los devengos del trabajador en un mes concreto
DROP PROCEDURE IF EXISTS devengos;

DELIMITER &&
CREATE PROCEDURE devengos(IN mes INT, IN anho INT, IN contrato_id INT)
    BEGIN
        SELECT 'Características del contrato' AS '';

        SELECT cot.grupo_de_cotizacion AS 'Grupo de cotización',
            cat.nombre_categoria AS 'Categoría', tipo.nombre AS 'Tipo de contato'
            FROM contratos AS con
            INNER JOIN cotizaciones AS cot
            ON cot.cotizacion_id = con.cot_id
            INNER JOIN categorias AS cat
            ON cat.categoria_id = con.cat_id
            INNER JOIN tipos_de_contrato AS tipo
            ON tipo.tipo_de_contrato_id = con.tipo_de_contrato_id
            WHERE con.contrato_id = contrato_id;

        SELECT 'Conceptos' AS '';

        SELECT tc.nombre AS 'Tipo de concepto', CONCAT(c.cantidad, '€') AS 'Cantidad'
            FROM contratos AS con
            INNER JOIN conceptos_de_salario AS c
            ON c.contrato_id = con.contrato_id
            INNER JOIN tipos_de_conceptos AS tc
            ON tc.tipo_de_concepto_id = c.tipo_de_concepto_id
            WHERE con.contrato_id = contrato_id;

        SELECT 'Total devengado' AS '',
                CONCAT(total_devengo(mes, anho, contrato_id), '€') AS '';
    END&&
DELIMITER ;