# Práctica 1 - Registro de compra-venta, introducción a las bases de datos

## Anotación de la entrega

El enunciado especifica que la tarea se entregue en un archivo llamado *T1-PracticaSistemasAlmacenamiento.md*. No obstante, dada la estructura de mi repositorio, he realizado la documentación en este mismo *README.md*.

---

## Documentación

### ¿Qué vamos a hacer?

Crear una base de datos que almacene informaciónsobre la compra-venta de vehículos entre individuos.

### ¿Con qué lo vamos a hacer?

Vamos a utilizar un servidor web en PHP.

### ¿Cómo se ha hecho?

Creando tres tablas:
* Coches: que contiene una matrícula, que además es su clave primaria.
* Personas: que tienen una ID automática, un nombre y un apellido compuesto.
* Contratos: que poseen una ID automática y tres claves foráneas, que son la matrícula del coche y las IDs del vendedor y el comprador.

### ¿Para qué se ha hecho?

Se podría utilizar en una plataforma de compra-venta de vehículos de segunda mano.

### ¿Dónde se ha hecho?

Se ha llevado acabo en la plataforma online antes mencionada.

### ¿Quién lo ha hecho?

Daniel Píriz Cacho.

### ¿Cuándo se ha hecho?

Se completó el día 23 de septiembre.

---

## Enunciado

Se desea informatizar el registro de compra-venta de una cencesionario. Para ello deberemos realizar una base de datos donde almacenar personas (id y nombre), vehículos (id y matrícula) y contrato de compra-venta (id, vendedor, comprador y vehículo).

1. Crear las tablas personas y vehículos.
2. Crear la tabla compra-venta, relacionándola con las anteriores.
5. Guardar el *sqlite* para subir a Github cuando conozcamos la herramienta.

Subir a Github *cuando se conozca*:
1. Crear directorio NOMBRE-MÓDULO
2. Crear en él un README.md con listado de tareas y su estado (método Kanban).
3. Crear un archivo *md* con nombre T1-PracticaSistemasAlmacenamiento.md
4. Invítame (@luiscastelar) a colaborar.
5. Marca la práctica 1 como "en espera".
