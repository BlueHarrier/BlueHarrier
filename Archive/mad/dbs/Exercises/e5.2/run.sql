#-- Base de datos y desactivar autocommit
USE 23_db_Daniel;
SET autocommit = OFF;

#-- Limpiar actividad
DELETE FROM P1_Personas
    WHERE Nombre LIKE "Barry" AND Apellido LIKE "Allen";

#-- Apartado 1
START TRANSACTION;

SELECT *
    FROM P1_Contratos
    WHERE ID = 2;

DELETE FROM P1_Contratos
    WHERE ID = 2;

SELECT *
    FROM P1_Contratos
    WHERE ID = 2;

ROLLBACK;

SELECT *
    FROM P1_Contratos
    WHERE ID = 2;

#-- Apartado 2
START TRANSACTION;

SELECT *
    FROM P1_Personas;

INSERT INTO P1_Personas (Nombre, Apellido)
    VALUES ("Barry", "Allen");

SELECT *
    FROM P1_Personas;

COMMIT;

SELECT *
    FROM P1_Personas;

#-- Apartado 3
START TRANSACTION;

SELECT *
    FROM P1_Personas
    WHERE Apellido LIKE "Allen";

UPDATE P1_Personas
    SET Nombre = "Flash"
    WHERE 
        Nombre = "Barry" AND
        Apellido = "Allen";

SELECT *
    FROM P1_Personas
    WHERE Apellido LIKE "Allen";

ROLLBACK;

SELECT *
    FROM P1_Personas
    WHERE Apellido LIKE "Allen";