USE 23_db_Daniel_nominas;

#-- Genera la nómina de un trabajador concreto
DROP PROCEDURE IF EXISTS generar_nomina;

DELIMITER &&
CREATE PROCEDURE generar_nomina(IN mes INT, IN anho INT, IN id INT)
	BEGIN
		DECLARE t_id, e_id INT;

		SELECT trabajador_id, empresa_id INTO t_id, e_id FROM contratos WHERE contrato_id = id;

		SELECT id AS 'Contrato nº';

		SELECT 'Datos del trabajador' AS '-----------------------------------------------------------';
		CALL datos_del_trabajador(t_id);

		SELECT 'Datos de la empresa' AS '-----------------------------------------------------------';
		CALL datos_de_la_empresa(e_id);

		SELECT 'Periodo de liquidación' AS '-----------------------------------------------------------';
		CALL periodo_de_liquidacion(mes, anho, id);

		SELECT 'Devengos' AS '-----------------------------------------------------------';
		CALL devengos(mes, anho, id);

		SELECT 'Deducciones' AS '-----------------------------------------------------------';
		CALL deducciones(mes, anho, id);

		SELECT 'Liquidez' AS '-----------------------------------------------------------';
		CALL liquidez(mes, anho, id);

		SELECT 'Base de cotización' AS '-----------------------------------------------------------';
		CALL base_de_cotizacion(mes, anho, id);

		SELECT '===========================================================' AS '';

	END&&
DELIMITER ;