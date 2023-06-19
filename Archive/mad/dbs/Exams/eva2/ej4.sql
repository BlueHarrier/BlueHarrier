USE 23_db_apartamentos;

DROP PROCEDURE IF EXISTS showEmployee;

DELIMITER &&
CREATE PROCEDURE showEmployee(id INT)
    BEGIN
        SELECT e.FIRST_NAME, e.LAST_NAME, e.EMAIL, e.PHONE_NUMBER, e.HIRE_DATE,
            j.JOB_TITLE, e.SALARY,
            CONCAT(mng.FIRST_NAME, " ", mng.LAST_NAME) AS "MANAGER", d.DEPARTMENT_NAME
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
            WHERE e.EMPLOYEE_ID = id;
    END &&
DELIMITER ;