#-- USE 23_db_Whatever;

DROP PROCEDURE IF EXISTS despedir_trabajador;

DELIMITER &&
CREATE PROCEDURE despedir_trabajador(id_despedido INT)
    BEGIN
        DECLARE id_jefe, id_candidato INT;
        
        SELECT boss_id INTO id_jefe FROM employees WHERE id = id_despedido;
        SELECT id INTO id_candidato FROM employees WHERE boss_id = id_despedido ORDER BY sign_date ASC LIMIT 1;
        
        UPDATE employees SET boss_id = id_jefe WHERE id = id_candidato;
        UPDATE employees SET boss_id = id_candidato WHERE id = id_despedido;

        DELETE FROM employees WHERE id = id_despedido;
    END &&
DELIMITER ;
