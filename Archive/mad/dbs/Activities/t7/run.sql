-- Ejercicio 1: crear la base de datos

CREATE DATABASE "23_db_Daniel";

/*
 * A PARTIR DE ESTE PUNTO, LAS CONSULTAS DEBEN REALIZARSE SOBRE 23_db_Daniel
 *
 * > PostgreSQL no permite la utilización del comando USE en SQl, cada conexión se realiza sobre una base de datos concreta.
 * > https://stackoverflow.com/questions/10335561/use-database-name-command-in-postgresql
*/

-- Ejercicio 2: crear usuario, esquemas y permisos

CREATE SCHEMA "datos_de_personas";
DROP SCHEMA public;

CREATE ROLE "PersonalDelCentro";
GRANT ALL PRIVILEGES ON SCHEMA "datos_de_personas" TO "PersonalDelCentro";
REVOKE ALL PRIVILEGES ON ALL TABLES IN SCHEMA "information_schema" FROM "PersonalDelCentro";
REVOKE ALL PRIVILEGES ON ALL TABLES IN SCHEMA "pg_catalog" FROM "PersonalDelCentro";
REVOKE ALL PRIVILEGES ON ALL TABLES IN SCHEMA "pg_toast" FROM "PersonalDelCentro";
CREATE ROLE "Profe1" PASSWORD '1234' LOGIN IN ROLE "PersonalDelCentro";

CREATE ROLE "Mantenimiento";
GRANT ALL PRIVILEGES ON SCHEMA "datos_de_personas" TO "Mantenimiento";
GRANT ALL PRIVILEGES ON SCHEMA "information_schema" TO "Mantenimiento";
GRANT ALL PRIVILEGES ON SCHEMA "pg_catalog" TO "Mantenimiento";
GRANT ALL PRIVILEGES ON SCHEMA "pg_toast" TO "Mantenimiento";
CREATE USER "Daniel23" PASSWORD '13062000' IN ROLE "Mantenimiento";

/*
* Utilizando root o "Daniel23" en "23_db_Daniel", con el esquema "datos_de_personas", es posible añadir y modificar tablas,
* pero, por seguridad, no leerlas ni modificar ningún valor introducido. Por otro lado, "Profe1" no podrá alterar la
* estructura del esquema, pero si insertar datos dentro de cada tabla.
*/

-- Ejercicio 3: implementación de parte de la práctica 2.1

CREATE TABLE "Persona"(
	"DNI"		VARCHAR(9)		NOT NULL,
	"Nombre"	VARCHAR(20)		NOT NULL,
	"Apellido"	VARCHAR(40)		NOT NULL,
	"Direccion"	TEXT			NOT NULL,
	"eMail"		TEXT			NOT NULL,
	"Telefono"	INT				NOT NULL,
	PRIMARY KEY ("DNI")
);

CREATE TABLE "Alumno"(
	"Tutor1"		VARCHAR(9)		NOT NULL,
	"Tutor2"		VARCHAR(9)		NULL,
	CONSTRAINT "fk_Tutor1" FOREIGN KEY ("Tutor1") REFERENCES "Persona" ("DNI"),
	CONSTRAINT "fk_Tutor2" FOREIGN KEY ("Tutor2") REFERENCES "Persona" ("DNI")
) INHERITS ("Persona");

CREATE TABLE "Profesor"(
	"NSS"			VARCHAR(9)	UNIQUE	NOT NULL,
	"Antiguedad"	INT					NOT NULL
) INHERITS ("Persona");

-- Ejercicio 4: crear un tipo dirección e implementarlo

CREATE TYPE "DIRECCION" AS(
	"tipo"		VARCHAR(20),
	"nombre"	TEXT,
	"numero"	INT,
	"piso"		INT,
	"letra"		VARCHAR(4),
	"cp"		INT,
	"localidad"	TEXT,
	"provincia"	TEXT
);

ALTER TABLE "Persona"
	ALTER COLUMN "Direccion" TYPE "DIRECCION" USING ("Direccion"::"DIRECCION");

-- Ejercicio 5: añadir 2 personas, 2 alumnos y 2 profesores

INSERT INTO "Persona" VALUES
	('12345678a', 'Sarah', 'Connor', ('Calle', 'Mérida', 2, 4, 'C', 06007, 'Badajoz', 'Badajoz'), 'sconnor@mymail.com', 123456789),
	('87654321a', 'Kyle', 'Reese', ('Calle', 'Mérida', 2, 4, 'C', 06007, 'Badajoz', 'Badajoz'), 'kyler@myothermail.com', 123456789);

INSERT INTO "Alumno" VALUES
	('65432187a', 'John', 'Connor', ('Calle', 'Mérida', 2, 4, 'C', 06007, 'Badajoz', 'Badajoz'), 'terminatorkiller99@mynewmail.com', 123456789, '12345678a', NULL),
	('32165487a', 'Arnold', 'Reese', ('Calle', 'Mérida', 2, 4, 'C', 06007, 'Badajoz', 'Badajoz'), 'theterminator@robotmail.com', 123456789, '87654321a', '12345678a');

INSERT INTO "Profesor" VALUES
	('87321654a', 'Gordon', 'Freeman', ('Calle', 'Castillo de Villagarcía de las Torres', 19, NULL, NULL, '06006', 'Badajoz', 'Badajoz'), 'gordonf@followthefreeman.com', 987654321, '12345678z', 20),
	('21354678a', 'Alyx', 'Vance', ('Avenida', 'Sinforiano Madroñero', 12, 7, 'Der', 06011, 'Badajoz', 'Badajoz'), 'alyxv@followthefreeman.com', 654987321, '87654321z', 5);
