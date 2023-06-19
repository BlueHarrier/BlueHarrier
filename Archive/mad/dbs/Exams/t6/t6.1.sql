#-- Examen 6.1 - Funciones
USE 23_db_apartamentos;

#-- Ejercicio 1
DROP FUNCTION IF EXISTS fecha;

#-- El delimitador '$$' daba error, así que utilizo '&&'
DELIMITER &&

CREATE FUNCTION fecha(inputDate DATE)
    RETURNS VARCHAR(25) DETERMINISTIC
    BEGIN
        RETURN DATE_FORMAT(inputDate, '%d-%M-%Y');
    END &&

DELIMITER ;

#-- Ejercicio 2
DROP TABLE IF EXISTS ejercicio2;

CREATE TABLE ejercicio2 AS (
    SELECT EMPLOYEE_ID, fecha(START_DATE), fecha(END_DATE), JOB_ID, DEPARTMENT_ID
        FROM job_history
        LIMIT 3
);

SELECT *
    FROM ejercicio2;

#-- Ejercicio 3
DROP FUNCTION IF EXISTS tlf;

DELIMITER &&

CREATE FUNCTION tlf(phoneNumber VARCHAR(20))
    RETURNS VARCHAR(12) DETERMINISTIC
    BEGIN
        DECLARE visibleNumber VARCHAR(6);
        SET visibleNumber := SUBSTRING(phoneNumber, 4, 6);
        RETURN CONCAT('***', visibleNumber, '***');
    END &&

DELIMITER ;

#-- Ejercicio 4
DROP TABLE IF EXISTS ejercicio4;

CREATE TABLE ejercicio4 AS (
    SELECT EMPLOYEE_ID, FIRST_NAME, tlf(PHONE_NUMBER)
        FROM employees
        LIMIT 3
);

SELECT *
    FROM ejercicio4;