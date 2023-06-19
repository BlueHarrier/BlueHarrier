USE 23_db_tiendaBicis;

DROP PROCEDURE IF EXISTS takeOrderBetween;

DELIMITER &&
CREATE PROCEDURE takeOrderBetween (IN firstDate DATE, IN secondDate DATE)
    BEGIN
		SELECT l.store_id, CONCAT(r2.first_name, ' ', r2.last_name), SUM(r1.quantity * r1.list_price * (r1.discount))
			FROM orders AS l
			INNER JOIN order_items AS r1
			ON r1.order_id = l.order_id
			INNER JOIN staffs AS r2
			ON r2.staff_id = l.staff_id
			WHERE l.order_date
			BETWEEN firstDate AND secondDate
			GROUP BY l.staff_id
			ORDER BY l.staff_id;
    END &&
DELIMITER ;

DROP PROCEDURE IF EXISTS takeThirtyDaysOrders;

DELIMITER &&
CREATE PROCEDURE takeThirtyDaysOrders (IN secondDate DATE)
    BEGIN
		DECLARE firstDate DATE;

		SET firstDate := DATE_SUB(secondDate, INTERVAL 30 DAY);

		SELECT l.store_id, CONCAT(r2.first_name, ' ', r2.last_name), SUM(r1.quantity * r1.list_price * (r1.discount))
			FROM orders AS l
			INNER JOIN order_items AS r1
			ON r1.order_id = l.order_id
			INNER JOIN staffs AS r2
			ON r2.staff_id = l.staff_id
			WHERE l.order_date
			BETWEEN firstDate AND secondDate
			GROUP BY l.staff_id
			ORDER BY l.staff_id;
    END &&
DELIMITER ;