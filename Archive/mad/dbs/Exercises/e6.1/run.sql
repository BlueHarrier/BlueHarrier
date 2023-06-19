#-- Usar bbdd

USE 23_db_Daniel;

#-- Apartado 1
DROP FUNCTION IF EXISTS holaMundo;

DELIMITER &&
CREATE FUNCTION holaMundo()
    RETURNS VARCHAR(10)
    BEGIN
        RETURN "Hola mundo";
    END &&

DELIMITER ;

#-- Apartado 2
DROP FUNCTION IF EXISTS sumar;

DELIMITER &&
CREATE FUNCTION sumar(numero1 INT, numero2 INT)
    RETURNS INT DETERMINISTIC
    BEGIN
        DECLARE resultado INT;
        SET resultado := numero1 + numero2;
        RETURN resultado;
    END &&

DELIMITER ;

#-- Apartado 3
DROP FUNCTION IF EXISTS timestampToHuman;

DELIMITER &&
CREATE FUNCTION timestampToHuman(timeSt BIGINT)
    RETURNS VARCHAR(24) DETERMINISTIC
    BEGIN
        DECLARE dateTf DATE;
        SET dateTf := FROM_UNIXTIME(timeSt);
        RETURN CONCAT(DAY(dateTf), " de ", MONTHNAME(dateTf), " de ", YEAR(dateTf));
    END &&

DELIMITER ;

#-- Apartado 4
DROP FUNCTION IF EXISTS MariaDBToTimestamp;

DELIMITER &&
CREATE FUNCTION MariaDBToTimestamp(dateTf DATE)
    RETURNS BIGINT DETERMINISTIC
    BEGIN
        RETURN UNIX_TIMESTAMP(dateTf);
    END &&

DELIMITER ;

#-- Apartado 5
DROP FUNCTION IF EXISTS timestampToMariaDB;

DELIMITER &&
CREATE FUNCTION timestampToMariaDB(timeSt BIGINT)
    RETURNS DATE DETERMINISTIC
    BEGIN
        RETURN FROM_UNIXTIME(timeSt);
    END &&

DELIMITER ;

#-- Apartado 6
DROP FUNCTION IF EXISTS humanToTimestamp;

DELIMITER &&
CREATE FUNCTION humanToTimestamp(inputDate VARCHAR(25))
    RETURNS BIGINT DETERMINISTIC
    BEGIN
        RETURN UNIX_TIMESTAMP(STR_TO_DATE(inputDate, '%d de %M de %Y'));
    END &&

DELIMITER ;

#-- Apartado 7
DROP FUNCTION IF EXISTS humanToMariaDB;

DELIMITER &&
CREATE FUNCTION humanToMariaDB(inputDate VARCHAR(25))
    RETURNS DATE DETERMINISTIC
    BEGIN
        RETURN STR_TO_DATE(inputDate, '%d de %M de %Y');
    END &&

DELIMITER ;

#-- Apartado 8
DROP FUNCTION IF EXISTS hideId;

DELIMITER &&
CREATE FUNCTION hideId(id VARCHAR(9))
    RETURNS VARCHAR(9) DETERMINISTIC
    BEGIN
        RETURN CONCAT("***", SUBSTRING(id, 4, 4), "**");
    END &&

DELIMITER ;