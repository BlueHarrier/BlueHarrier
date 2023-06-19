USE 23_db_apartamentos;

DROP PROCEDURE IF EXISTS autopromoteDepartment;

DELIMITER &&
CREATE PROCEDURE autopromoteDepartment(id INT)
    BEGIN
        DECLARE id_jefe, id_candidato INT;
        
        SELECT MANAGER_ID INTO id_jefe FROM employees WHERE EMPLOYEE_ID = id;
        SELECT EMPLOYEE_ID INTO id_candidato FROM employees WHERE MANAGER_ID = id ORDER BY HIRE_DATE ASC LIMIT 1;
        
        UPDATE employees SET MANAGER_ID = id_jefe WHERE EMPLOYEE_ID = id_candidato;
        UPDATE employees SET MANAGER_ID = id_candidato WHERE MANAGER_ID = id;
    END&&
DELIMITER ;