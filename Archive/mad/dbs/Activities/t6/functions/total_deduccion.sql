USE 23_db_Daniel_nominas;

#-- Devuelve la suma de las deducciones aplicables
DROP FUNCTION IF EXISTS total_deduccion;

DELIMITER &&
CREATE FUNCTION total_deduccion(mes INT, anho INT, id INT)
    RETURNS int(11)
    BEGIN
        DECLARE deduccion_total, base_cot INT;

        SET base_cot := tomar_base_de_cotizacion(mes, anho, id);

        SELECT cantidad INTO deduccion_total
            FROM deducciones
            WHERE contrato_id = id AND deducciones.mes = mes AND deducciones.anho = anho;

        IF deduccion_total IS NULL THEN
            RETURN 0;
        END IF;
        
        RETURN (deduccion_total / 100) * base_cot;
    END&&
DELIMITER ;