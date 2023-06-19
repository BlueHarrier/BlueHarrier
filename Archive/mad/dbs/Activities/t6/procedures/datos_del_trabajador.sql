USE 23_db_Daniel_nominas;

#-- Solicitar datos de trabajador
DROP PROCEDURE IF EXISTS datos_del_trabajador;

DELIMITER &&
CREATE PROCEDURE datos_del_trabajador(IN id INT)
    BEGIN
        SELECT CONCAT(nombre, " ", ape1, " ", ape2) AS 'Trabajador', nif AS 'NIF', nss AS 'Número S.S.'
            FROM trabajadores
            WHERE trabajador_id = id;
    END&&
DELIMITER ;