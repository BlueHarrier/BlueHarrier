# Examen completo
USE 00_db_tiendaBicis;

# Apartado 1: clientes con más de una compra
SELECT "Clientes con más de una compra" AS "Apartado 1";

SELECT CONCAT(customers.first_name, ' ', customers.last_name) AS 'Cliente', COUNT(orders.order_id) AS "Compras"
    FROM customers
    INNER JOIN orders
    ON orders.customer_id = customers.customer_id
    GROUP BY orders.customer_id
    HAVING COUNT(orders.order_id) > 1;

# Apartado 2: prodctos sin stock utiliando LEFT JOIN
SELECT "Productos sin stock" AS "Apartado 2";

WITH no_stock_products AS (
    WITH total_stock AS (
        SELECT product_id, SUM(quantity) AS quantity
            FROM stocks
            GROUP BY product_id
    )
    SELECT products.product_id
        FROM products
        LEFT JOIN total_stock
        ON total_stock.product_id = products.product_id
        WHERE total_stock.quantity = 0
        OR ISNULL(total_stock.product_id)
)
SELECT products.product_name AS "Producto"
    FROM products
    INNER JOIN no_stock_products
    ON no_stock_products.product_id = products.product_id;

# Apartado 3: categoría con más productos
SELECT "Categoría con más productos" AS "Apartado 3";

CREATE TEMPORARY TABLE temp (category_id INT(11));

INSERT INTO temp(
    SELECT category_id
        FROM products
        GROUP BY category_id
        ORDER BY COUNT(product_id) DESC
        LIMIT 1
);

SELECT categories.category_name AS "Categoría", COUNT(products.product_id) AS "Número de productos"
    FROM products
    INNER JOIN categories
    ON categories.category_id = products.category_id
    INNER JOIN temp
    ON categories.category_id = temp.category_id;

# Apartado 4: dinero invertido en la categoría con más productos
SELECT "Dinero invertido en la categoría con más productos" AS "Apartado 4";

SELECT SUM(stocks.quantity * products.list_price) AS "Dinero ($)"
    FROM products
    INNER JOIN stocks
    ON stocks.product_id = products.product_id
    INNER JOIN temp
    ON products.category_id = temp.category_id;

DROP TABLE IF EXISTS temp;

# Apartado 5: top 10 compradores que más dinero han gastado
SELECT "Top 10 compradores que más dinero han gastado" AS "Apartado 5";

SELECT "Obtener el coste de los pedidos por artículos" AS "Paso 1";

CREATE TEMPORARY TABLE item_order_total (order_id INT, product_id INT, total DECIMAL(10, 2));

INSERT INTO item_order_total (
    SELECT order_id, product_id, (list_price - list_price * discount) * quantity
        FROM order_items
        ORDER BY order_id
);

SELECT order_id AS "ID del pedido", product_id AS "ID del producto", total "Precio total ($)"
    FROM item_order_total;

SELECT "Obtener el coste total de cada pedido" AS "Paso 2";

CREATE TEMPORARY TABLE order_total (order_id INT, total DECIMAL(10, 2));

INSERT INTO order_total (
    SELECT order_id, SUM(total)
        FROM item_order_total
        GROUP BY order_id
);

DROP TABLE IF EXISTS item_order_total;

SELECT order_id AS "ID del pedido", total AS "Precio total ($)"
    FROM order_total;

SELECT "Obtener el coste total por cada cliente" AS "Paso 3";

CREATE TEMPORARY TABLE customer_total (customer_id INT, total DECIMAL(10, 2));

INSERT INTO customer_total (
    SELECT orders.customer_id, SUM(order_total.total) AS total
        FROM orders
        INNER JOIN order_total
        ON order_total.order_id = orders.order_id
        GROUP BY orders.customer_id
);

DROP TABLE IF EXISTS order_total;

SELECT customer_id AS "ID del cliente", total AS "Gasto ($)"
    FROM customer_total;

SELECT "Cruzar resultados con clientes" AS "Paso 4";

SELECT CONCAT(customers.first_name, ' ', customers.last_name) AS 'Cliente', customer_total.total AS "Gasto ($)"
    FROM customers
    INNER JOIN customer_total
    ON customer_total.customer_id = customers.customer_id
    ORDER BY customer_total.total DESC
    LIMIT 10;

DROP TABLE IF EXISTS customer_total;
