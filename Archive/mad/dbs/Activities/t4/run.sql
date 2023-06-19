-- Seleccionar base de datos
USE 00_db_tiendaBicis;

-- Apartado 1
SELECT "Clientes con más de una compra" AS "Apartado 1";

SET @i := 0;
SELECT (@i := @i + 1) AS 'n', CONCAT(first_name, ' ', last_name) AS "Cliente"
        FROM customers
        WHERE customer_id IN (
        SELECT customer_id
            FROM orders
            GROUP BY customer_id
            HAVING COUNT(order_id) > 1
        );

-- Apartado 2
SELECT "Productos fuera de stock" AS "Apartado 2";

SET @i := 0;
SELECT (@i := @i + 1) AS 'n', product_name AS "Productos"
    FROM products
    WHERE product_id IN (
    SELECT product_id
        FROM stocks
        GROUP BY product_id
        HAVING SUM(quantity) = 0
    )
    OR product_id NOT IN (
    SELECT product_id
        FROM stocks
    );

-- Apartado 3
SELECT "Productos con menos de 3 existencias" AS "Apartado 3";

CREATE TEMPORARY TABLE temp (product_id INT(11), quantity INT(11));

INSERT INTO temp (
    SELECT products.product_id, SUM(stocks.quantity) AS quantity
        FROM products
        INNER JOIN stocks
        ON stocks.product_id = products.product_id
        HAVING SUM(stocks.quantity) < 3
);

INSERT INTO temp (
   SELECT products.product_id, 0 AS quantity
        FROM products
        WHERE product_id NOT IN(
            SELECT product_id 
                FROM stocks
        )
);

SET @i := 0;
WITH product_quantity AS (
    SELECT products.product_name, temp.quantity
        FROM products
        INNER JOIN temp
        ON temp.product_id = products.product_id
        ORDER BY temp.quantity ASC
)
SELECT (@i := @i + 1) AS 'n', product_name AS "Productos escasos", quantity AS "Stock"
    FROM product_quantity;

DROP TABLE IF EXISTS temp;

-- Apartado 4
SELECT "Productos y stock" AS "Apartado 4";

-- 4.1
SELECT "En la empresa" AS "Con más stock";

SET @i := 0;
WITH display AS(
    SELECT products.product_name, SUM(stocks.quantity) AS quantity
        FROM products
        INNER JOIN stocks
        ON products.product_id = stocks.product_id
        GROUP BY stocks.product_id
        ORDER BY SUM(stocks.quantity) DESC
        LIMIT 4
)
SELECT (@i := @i + 1) AS 'n', product_name AS "Producto", quantity AS "Stock"
    FROM display;

-- 4.2
SELECT "En cada tienda" AS "Con más stock";

CREATE TEMPORARY TABLE temp (store_id INT(11), product_id INT(11), quantity INT(11), row_num INT(11));
INSERT INTO temp (
    SELECT *, row_number() OVER (
        PARTITION BY store_id
        ORDER BY quantity DESC
    ) AS row_num
    FROM stocks
);

SET @i := 0;
SELECT (@i := @i + 1) AS 'n', stores.store_name AS "Tienda", products.product_name AS "Producto", temp.quantity AS "Stock"
        FROM temp
        INNER JOIN stores
        ON temp.store_id = stores.store_id
        INNER JOIN products
        ON temp.product_id = products.product_id
        WHERE temp.row_num <= 4;

-- 4.3
SELECT "En Productos con más stock" AS "Dinero bloqueado";

SET @i := 0;
SELECT (@i := @i + 1) AS 'n', stores.store_name AS "Tienda", SUM(temp.quantity * products.list_price) AS "Cantidad ($)"
    FROM temp
    INNER JOIN stores
    ON stores.store_id = temp.store_id
    INNER JOIN products
    ON products.product_id = temp.product_id
    WHERE temp.row_num <= 4
    GROUP BY temp.store_id;

SELECT SUM(temp.quantity * products.list_price) AS "Total ($)"
    FROM temp
    INNER JOIN products
    ON products.product_id = temp.product_id
    WHERE temp.row_num <= 4;

-- 4.4
SELECT "En todo el stock" AS "Dinero bloqueado";

SET @i := 0;
SELECT (@i := @i + 1) AS 'n', stores.store_name AS "Tienda", SUM(temp.quantity * products.list_price) AS "Cantidad ($)"
    FROM temp
    INNER JOIN stores
    ON stores.store_id = temp.store_id
    INNER JOIN products
    ON products.product_id = temp.product_id
    GROUP BY temp.store_id;

SELECT SUM(temp.quantity * products.list_price) AS "Total ($)"
    FROM temp
    INNER JOIN products
    ON products.product_id = temp.product_id;

DROP TABLE temp;

-- Apartado 5
SELECT "Top 10 compradores con más gastos" AS "Apartado 5";

SET @i := 0;
WITH display AS(
    WITH customer_expense AS(
        SELECT orders.customer_id, SUM(oi.quantity * (oi.list_price - oi.list_price * oi.discount)) AS expense
            FROM orders
            INNER JOIN order_items AS oi
            ON oi.order_id = orders.order_id
            GROUP BY orders.customer_id
    )
    SELECT CONCAT(customers.first_name, ' ', customers.last_name) AS full_name, customer_expense.expense
        FROM customers
        INNER JOIN customer_expense
        ON customer_expense.customer_id = customers.customer_id
        ORDER BY customer_expense.expense DESC
        LIMIT 10
)
SELECT (@i := @i + 1) AS 'n', full_name AS "Cliente", expense AS "Gasto ($)"
    FROM display;

-- Apartado 6
SELECT "Top 5 compradores con más productos comprados" AS "Apartado 6";

SET @i := 0;
WITH display AS(
    WITH customer_product AS(
        SELECT orders.customer_id, SUM(oi.quantity) AS quantity
            FROM orders
            INNER JOIN order_items AS oi
            ON oi.order_id = orders.order_id
            GROUP BY orders.customer_id
    )
    SELECT CONCAT(customers.first_name, ' ', customers.last_name) AS full_name, customer_product.quantity
        FROM customers
        INNER JOIN customer_product
        ON customer_product.customer_id = customers.customer_id
        ORDER BY customer_product.quantity DESC
        LIMIT 5
)
SELECT (@i := @i + 1) AS 'n', full_name AS "Cliente", quantity AS "Nº de unidades"
    FROM display;

-- Apartado 7
SELECT "Tiendas por unidad vendida e ingreso" AS "Apartado 7";

SET @i := 0;
WITH display AS(
    WITH store_orders AS(
        SELECT orders.store_id, SUM(oi.quantity) AS quantity, SUM(oi.quantity * (oi.list_price - oi.list_price * oi.discount)) AS income
            FROM orders
            INNER JOIN order_items AS oi
            ON oi.order_id = orders.order_id
            GROUP BY orders.store_id
    )
    SELECT stores.store_name, store_orders.quantity, store_orders.income
        FROM stores
        INNER JOIN store_orders
        ON store_orders.store_id = stores.store_id
        ORDER BY store_orders.quantity DESC, store_orders.income DESC
)
SELECT (@i := @i + 1) AS 'n', store_name AS "Tienda", quantity AS "Unidades vendidas", income AS "Ingresos ($)"
    FROM display;
