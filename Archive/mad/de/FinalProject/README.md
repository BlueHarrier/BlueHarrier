# TparkDB

Se trata de una plataforma que contendrá y mostrará información relativa a parques temáticos y sus atracciones, incluyendo la historia, descripción, fecha de servicio e incidencias.

[Definición del proyecto](./docs/Definicion%20de%20proyecto.pdf).

## Anotaciones de la entrega

La definición de nuestro proyecto se anticipaba a la imposibilidad de llevar a cabo la segunda parte. Por ello, solo se ha desarrollado el buscador y visualizador de parques y atracciones, pero no el registro de usuarios ni el inicio de sesión. Dichos elementos están, sin embargo, diseñados, así que los formularios de placeholder dispuestos en la página web.

## Despliegue

1. Inicializar el contenedor con `docker compose up -d` (Windows) o `sudo docker compose up -d` (Linux).
2. A través de [PHPMyAdmin](http://localhost:8085/), ejecutar el [archivo de despliegue](./sql/despliegue/db.sql).
	* Usuario: root
	* Contraseña: root
3. En el mismo sitio, cargar el [archivo de datos de prueba](./sql/test/Test.sql) (solo testeo).

## Quehaceres

### Fase 1: Diseño

- [x] [Documento de especificaciones](./docs/Documento%20de%20especificacion.pdf)
- [x] [Documento de diseño](./docs/Documento%20de%20diseno%20de%20software-1.pdf)
	- [ ] Diagrama de interacción*
	- [ ] Diagrama de estados*

> \* No se han visto aún, se implementarán en caso de que se vean.

### Fase 2: Prototipo 1

- [x] Despliegue de base de datos (archivo)
- [x] Plantillas HTML
- [x] Librería de apoyo de PHP

### Fase 3: Prototipo 2

- [x] Formularios funcionales
- [x] Backend de búsqueda y muestra de información
- [x] [Documentación de librerías](./docs/Librerias/index.md)
- [x] Datos de prueba (por lo menos 20 atracciones y 4 parques)

### Fase 4 (fuera de plazo): Producción

- [ ] Inicio de sesión
- [ ] Interfaz del editor
- [ ] Adición, edición y eliminación de datos
- [ ] Favoritos
