USE 23_db_apartamentos;

DROP PROCEDURE IF EXISTS fireEmployee;

DELIMITER &&
CREATE PROCEDURE fireEmployee(id INT)
    BEGIN
        DELETE FROM employees WHERE EMPLOYEE_ID = id;
    END&&
DELIMITER ;