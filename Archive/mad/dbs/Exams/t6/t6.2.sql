USE 23_db_Daniel;

#-- Actividad 1
DROP PROCEDURE IF EXISTS verContrato;

DELIMITER &&
CREATE PROCEDURE verContrato (IN numContrato INT(10))
    BEGIN
        SELECT
            trab.NIF AS NIF, trab.nombre AS nombre1, trab.ape1 AS ape1,
            empr.CIF AS CIF, empr.nombre AS nombre2, empr.prov AS prov,
            cont.fAlta AS fAlta, cont.fBaja AS fBaja, cont.codContrato AS codContrato,
            tipo.nombre AS nombre3
            FROM P3_CONTRATO AS cont
            INNER JOIN P3_TRABAJADOR AS trab
            ON cont.NIF = trab.NIF
            INNER JOIN P3_EMPRESA AS empr
            ON cont.CIF = empr.CIF
            INNER JOIN P3_TCONTRATO AS tipo
            ON cont.codContrato = tipo.codContrato
            WHERE cont.numContrato = numContrato;
    END&&
DELIMITER ;

#-- Actividad 2
USE 23_db_tiendaBicis;

DROP PROCEDURE IF EXISTS ventasTienda;

DELIMITER &&
CREATE PROCEDURE ventasTienda(IN fechaIni VARCHAR(20), IN fechaFin VARCHAR(20))
    BEGIN
    DECLARE realDateStart, realDateEnd DATE;
    SET realDateStart := STR_TO_DATE(fechaIni, '%Y-%m-%d');
    SET realDateEnd := STR_TO_DATE(fechaFin, '%Y-%m-%d');
    SELECT
        ord.order_id AS id,
        cust.first_name AS nombre, cust.last_name AS apellido,
        DATE_FORMAT(ord.order_date, '%e-%c-%y'),
        stor.store_name AS tienda, staf.first_name AS staff
        FROM orders AS ord
        INNER JOIN customers AS cust
        ON ord.customer_id = cust.customer_id
        INNER JOIN stores AS stor
        ON ord.store_id = stor.store_id
        INNER JOIN staffs AS staf
        ON ord.staff_id = staf.staff_id
        WHERE ord.order_date BETWEEN realDateStart AND realDateEnd;
    
    SELECT
        COUNT(ord.order_id) AS n
        FROM orders AS ord
        INNER JOIN customers AS cust
        ON ord.customer_id = cust.customer_id
        INNER JOIN stores AS stor
        ON ord.store_id = stor.store_id
        INNER JOIN staff AS staf
        ON ord.staff_id = staf.staff_id
        WHERE ord.order_date BETWEEN realDateStart AND realDateEnd;
    END
DELIMITER ;