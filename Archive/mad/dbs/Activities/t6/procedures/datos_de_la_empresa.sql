USE 23_db_Daniel_nominas;

#-- Solicitar datos de la empresa
DROP PROCEDURE IF EXISTS datos_de_la_empresa;

DELIMITER &&
CREATE PROCEDURE datos_de_la_empresa(IN id INT)
    BEGIN
        SELECT nombre AS 'Empresa', dir AS 'Domicilio', cif AS 'CIF', ccc AS 'CCC'
            FROM empresas
            WHERE empresa_id = id;
    END&&
DELIMITER ;