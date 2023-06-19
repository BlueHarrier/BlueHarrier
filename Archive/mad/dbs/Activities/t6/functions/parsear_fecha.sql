USE 23_db_Daniel_nominas;

#-- Función de corrección de fecha
DROP FUNCTION IF EXISTS parsear_fecha;

DELIMITER &&
CREATE FUNCTION parsear_fecha(mes INT, anho INT)
    RETURNS DATE DETERMINISTIC
    BEGIN
        #-- Declarar mes real y año real
        DECLARE mes_final, anho_final INT;

        #-- Si se ha introducido un mes con una cifra, se añade un cero al inicio
        IF (LENGTH(mes) = 1) THEN
            SET mes_final := CONCAT("0", mes);
        #-- Si se pasa de 12, se baja a 12
        ELSEIF (mes > 12) THEN
            SET mes_final := 12;
        #-- Si no llega a 1, se aumenta a 1
        ELSEIF (mes < 1) THEN
            SET mes_final := 1;
        #-- Si nada de lo anterior ocurre, se toma el mes
        ELSE
            SET mes_final := mes;
        END IF;

        #-- Si se ha introducido un año con una o dos cifras, se considera que es el 2000 y se añaden los números correspondientes
        IF (LENGTH(anho) = 1) THEN
            SET anho_final := CONCAT("200", anho);
        ELSEIF (LENGTH(anho) = 2) THEN
            SET anho_final := CONCAT("20", anho);
        #-- Si no, se toma el año especificado completamente
        ELSE
            SET anho_final := anho;
        END IF;

        #-- Generar y devolver el día 1: YYYY-MM-01
        RETURN CONCAT(anho_final, "-", mes_final, "-01");
    END&&
DELIMITER ;