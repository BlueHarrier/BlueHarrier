USE 23_db_Daniel_nominas;

#-- Calcula la base de cotización en porcentaje (decimal)
DROP FUNCTION IF EXISTS tomar_base_de_cotizacion;

DELIMITER &&
CREATE FUNCTION tomar_base_de_cotizacion(mes INT, anho INT, id INT)
    RETURNS INT
    BEGIN
        RETURN total_deducciones(mes, anho, id);
    END&&
DELIMITER ;