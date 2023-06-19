# Examen 4 - Consultas

## Documentación

### ¿Qué vamos a hacer?

Realizar una serie de consultas en la base de datos 00_db_tiendaBicis.

### ¿Con qué lo vamos a hacer?

Utilizando un editor de texto con capacidad de enviar consultas a servidor MySQL, en este caso, Visual Studio Code.

### ¿Cómo se ha hecho?

1. Seleccionando los clientes cuyo sumatorio de compras sea superior a 1.
2. Realizando dos subconsultas para filtrar el stock en tiendas de cada producto, seguidamente, comprobando que este sea 0 o bien no esté listado.
3. Se utiliza una tabla temporal para el ejercicio 4. La tabla filtra la categoría con mayor sumatorio de ID de productos coincidentes.
4. Realiza el cálculo de stock junto al precio listado por cada producto de la categoría anterior.
5. Se ha realizado:
    1. Una tabla temporal realiza el cálculo de precio de cada producto y lo ordena por pedido.
    2. Otra realiza el sumatorio de los productos por orden de pedido.
    3. La siguiente vuelve a sumar el total de los pedidos, pero esta vez por cliente.
    4. Coteja las IDs de cliente de la tabla anterior, les da nombre y apellido y escoge los 10 primeros.

### ¿Para qué se ha hecho?

Para probar nuestras habilidades consultando bases de datos.

### ¿Dónde se ha hecho?

Completado en clase (examen).

### ¿Quién lo ha hecho?

Daniel Píriz Cacho.

### ¿Cuándo se ha hecho?

13/01/2023.

