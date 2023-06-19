#-- Examen 2ª Evaluación
USE 23_db_apartamentos;

#-- Ejercicio 1
SELECT 'Introducir registro de trabajo' AS 'Ej. 1';
SELECT '' AS '';

SELECT DEPARTMENT_ID INTO @id_departamento FROM departments WHERE DEPARTMENT_NAME LIKE "Sales";
SELECT JOB_ID INTO @id_trabajo FROM jobs WHERE JOB_TITLE LIKE "Sales Representative";
SELECT EMPLOYEE_ID INTO @id_empleado FROM employees WHERE EMPLOYEE_ID = 176;

IF @id_departamento IS NOT NULL AND @id_trabajo IS NOT NULL AND @id_empleado IS NOT NULL
THEN
    INSERT INTO job_history (EMPLOYEE_ID, START_DATE, END_DATE, JOB_ID, DEPARTMENT_ID)
        VALUES(@id_empleado, '1997-03-24', '1997-12-31', @id_trabajo, @id_departamento);
END IF;

#-- Ejercicion 2
SELECT 'Top 3 empleados con más renovaciones' AS 'Ej. 2';
SELECT '' AS '';

WITH employeeHistory AS (
   SELECT EMPLOYEE_ID, COUNT(EMPLOYEE_ID) AS 'NUMBER_OF_JOBS'
    FROM job_history
    GROUP BY EMPLOYEE_ID
)
SELECT e.EMPLOYEE_ID AS 'id', e.FIRST_NAME AS 'nombre', e.LAST_NAME AS 'apellido'
    FROM employees AS e
    INNER JOIN employeeHistory AS eh
    ON e.EMPLOYEE_ID = eh.EMPLOYEE_ID
    ORDER BY eh.NUMBER_OF_JOBS
    LIMIT 3;

#-- Ejercicio 3
SELECT 'Datos relacionados de empleados de Canadá' AS 'Ej. 3';
SELECT '' AS '';

SELECT e.FIRST_NAME, e.LAST_NAME, e.EMAIL, e.PHONE_NUMBER, e.HIRE_DATE,
    j.JOB_TITLE, e.SALARY, CONCAT(mng.FIRST_NAME, " ", mng.LAST_NAME) AS "MANAGER",
    mng.LAST_NAME, d.DEPARTMENT_NAME
    FROM employees AS e
    INNER JOIN employees AS mng
    ON e.MANAGER_ID = mng.EMPLOYEE_ID
    INNER JOIN jobs AS j
    ON e.JOB_ID = j.JOB_ID
    INNER JOIN departments AS d
    ON e.DEPARTMENT_ID = d.DEPARTMENT_ID
    INNER JOIN locations AS l
    ON d.LOCATION_ID = l.LOCATION_ID
    INNER JOIN countries AS c
    ON l.COUNTRY_ID = c.COUNTRY_ID
    WHERE c.COUNTRY_NAME LIKE "Canada";

#-- Ejercicio 4
SELECT 'Rutina que muestre los datos de un empleado dado su ID' AS 'Ej. 4';
SELECT '' AS '';

#-- Rutina creada en "./ej4.sql"
CALL showEmployee(106);

#-- Ejercicion 5
SELECT 'Procedimientos de despido' AS 'Ej. 5';
SELECT '' AS '';

#-- Parte 1 "./ej5.1"
CALL archiveEmployee(205);

#-- Parte 2 "./ej5.2"
CALL autopromoteDepartment(205);

#-- Parte 3 "./ej5.3"
CALL fireEmployee(205);