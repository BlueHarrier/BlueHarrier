# Clases

**Dependencias:** [Estructuras](./structures.md), [Bases de datos](./databases.md)

## Parque

Recoge y almacena los datos procedentes de un parque de atracciones.

**Constructor:** `Parque(int id)`

**Atributos**
* `bool exists` - Indica si el objeto se ha creado correctamente o ha fallado.
* `string nombre` - Nombre del parque.
* `string ubicacion` - Ubicación del parque.
* `Date fecha_apertura` - Fecha de apertura del parque.
* `Date fecha_cierre` ó `null` - Fecha de cierre del parque o null.
* `string descripcion` - Nombre del archivo de descripción del parque sin extensión.
* `int foto` - ID de la foto del parque.
* `array atracciones` - Lista con los nombres e IDs de las atracciones del parque en el presente.
	* int id

**Funciones**
* `void generar_pagina()` - Genera la estructura de la página del parque.

## Atraccion

Recoge y almacena los datos procedentes de una atracción.

**Constructor:** `Atraccion(int id)`

**Atributos**
* `bool exists` - Indica si el objeto se ha creado correctamente o ha fallado.
* `string nombre` - Nombre de la atracción.
* `string fabricante` - Nombre del fabricante de la atracción.
* `int intensidad` - Intensidad del 1 al 10 de la atracción.
* `int valoracion` - Valoración general de la atracción del 1 al 5.
* `string descripcion` - Nombre del archivo de descripción de la atracción sin extensión.
* `int foto` - ID de la foto de la atracción.
* `array servicios` - Lista con los nombres, IDs y fechas de apertura y cierre de la atracción.
	* array n
		* int id
		* string nombre
		* Date apertura
		* Date cierre*

> \* Este atributo puede estar o no.

**Funciones**
* `void generar_pagina()` - Genera la estructura de la página de la atracción.