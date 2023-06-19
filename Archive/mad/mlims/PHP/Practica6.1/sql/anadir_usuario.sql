USE money_service;

DROP PROCEDURE IF EXISTS anadir_usuario;

DELIMITER &&
CREATE PROCEDURE anadir_usuario(IN nif VARCHAR(9), IN nombre VARCHAR(60), IN nacimiento DATE, IN cap_inicial INT, IN cap_anual INT, IN interes INT, IN cap_final INT)
    BEGIN
        DECLARE usuario VARCHAR(9);

        SELECT u.nif INTO usuario FROM usuarios AS u WHERE u.nif = nif;

        IF usuario IS NULL THEN
            INSERT INTO usuarios (nif, nombre, nacimiento, cap_inicial, cap_anual, interes, cap_final) VALUES
            (nif, nombre, nacimiento, cap_inicial, cap_anual, interes, cap_final);
        ELSE
            UPDATE usuarios SET 
                cap_inicial = cap_inicial,
                cap_anual = cap_anual,
                interes = interes,
                cap_final = cap_final
            WHERE nif = nif;
        END IF;
    END&&
DELIMITER ;