USE 23_db_Daniel_nominas;

#-- Calcula los periodos de liquidación y el número de días trabajados de un trabajador
DROP PROCEDURE IF EXISTS periodo_de_liquidacion;

DELIMITER &&
CREATE PROCEDURE periodo_de_liquidacion(IN mes INT, IN anho INT, IN contrato_id INT)
    BEGIN
        #-- Declarar fechas de inicio y fin
        DECLARE fecha_ini, fecha_fin DATE;

        #-- Tomar fechas de inicio y fin basadas en el mes y el año
        SET fecha_ini := parsear_fecha(mes, anho);
        SET fecha_fin := LAST_DAY(fecha_ini);

        #-- Buscar la tabla con los datos especificados
        SELECT 
            DATE_FORMAT(fecha_ini, "%d/%m/%Y") AS 'Del día',
            DATE_FORMAT(fecha_fin, "%d/%m/%Y") AS 'Al día',
            dias_trabajados(mes, anho, contrato_id) AS 'Nº de días';
    END&&
DELIMITER ;