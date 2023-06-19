USE 23_db_Daniel_nominas;

#-- Destruir todas las tablas en orden de dependencia inversa
DROP TABLE IF EXISTS deducciones;
DROP TABLE IF EXISTS tipos_de_deducciones;
DROP TABLE IF EXISTS bases_de_cotizacion;
DROP TABLE IF EXISTS conceptos_de_salario;
DROP TABLE IF EXISTS tipos_de_conceptos;
DROP TABLE IF EXISTS contratos;
DROP TABLE IF EXISTS tipos_de_contrato;
DROP TABLE IF EXISTS cotizaciones;
DROP TABLE IF EXISTS categorias;
DROP TABLE IF EXISTS empresas;
DROP TABLE IF EXISTS trabajadores;
DROP TABLE IF EXISTS tipos_aplicables;