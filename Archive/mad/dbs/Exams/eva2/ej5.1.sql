USE 23_db_apartamentos;

DROP PROCEDURE IF EXISTS archiveEmployee;

DELIMITER &&
CREATE PROCEDURE archiveEmployee(id INT)
    BEGIN
        DECLARE sta_date, end_date DATE;
        DECLARE j_id VARCHAR(10);
        DECLARE d_id DECIMAL;

        SELECT HIRE_DATE, JOB_ID, DEPARTMENT_ID INTO sta_date, j_id, d_id FROM employees WHERE EMPLOYEE_ID = id;
        SET end_date := CURRENT_DATE();
        INSERT INTO job_history(EMPLOYEE_ID, START_DATE, END_DATE, JOB_ID, DEPARTMENT_ID)
           VALUES (id, sta_date, end_date, j_id, d_id);
    END&&
DELIMITER ;