USE 23_db_Daniel_nominas;

#-- Muestra la liquidez de un contrato en un mes concreto
DROP PROCEDURE IF EXISTS liquidez;

DELIMITER &&
CREATE PROCEDURE liquidez(IN mes INT, IN anho INT, IN id INT)
    BEGIN
        DECLARE devengos, deducciones INT;
        
        SET devengos := total_devengo(mes, anho, id);
        SET deducciones := total_deduccion(mes, anho, id);
        
        SELECT CONCAT('Total a percibir ', (devengos - deducciones), '€') AS '';
    END&&
DELIMITER ;