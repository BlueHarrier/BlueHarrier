USE 23_db_Daniel_nominas;

#--Función de días trabajados
DROP FUNCTION IF EXISTS dias_trabajados;

DELIMITER &&
CREATE FUNCTION dias_trabajados(mes INT, anho INT, id INT)
    RETURNS INT
    BEGIN
        #-- Declarar fechas de solicitud y fechas del contrato, declarar días de inicio y fin
        DECLARE fecha_soli_ini, fecha_soli_fin, fecha_ini, fecha_fin DATE;
        DECLARE dia_ini, dia_fin INT;

        #-- Establecer fechas de solicitud y tomar fechas de contrato
        SET fecha_soli_ini := parsear_fecha(mes, anho);
        SET fecha_soli_fin := LAST_DAY(fecha_soli_ini);
        SELECT fecha_alta, fecha_baja INTO fecha_ini, fecha_fin FROM contratos WHERE contrato_id = id;
        SET fecha_fin := IFNULL(fecha_fin, "2099-12-31");

        #-- Si la fecha se sale del rango, devuelve 0 (días trabajados)
        IF fecha_fin < fecha_soli_ini OR fecha_ini > fecha_soli_fin THEN
            RETURN 0;
        END IF;

        #-- Si la fecha de inicio es anterior a la fecha de inicio solicitada, se considera el primer día
        IF fecha_ini < fecha_soli_ini THEN
            SET dia_ini := 1;
        #-- Si no, es el día de inicio del contrato
        ELSE
            SET dia_ini := DAY(fecha_ini);
        END IF;

        #-- Si la fecha de fin es posterior a la fecha de fin solicitada, se considera el último día del mes
        IF fecha_fin > fecha_soli_fin THEN
            SET dia_fin := DAY(fecha_soli_fin);
        #-- Si no, es el día de fin del contrato
        ELSE
            SET dia_fin := DAY(fecha_fin);
        END IF;

        #-- Si el día de inicio es el primero y el de fin el último, se devuelven 30 días trabajados
        IF dia_ini = 1 AND dia_fin = DAY(fecha_soli_fin) THEN
            RETURN 30;
        END IF;

        #-- Se calcula y devuelve el número de días trabajados
        RETURN (dia_fin - dia_ini + 1);
    END&&
DELIMITER ;