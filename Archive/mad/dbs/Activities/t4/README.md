# Práctica 4.1 - Consultas a una base de datos

## Archivos incluidos

+ **run.sql**: realiza todas las consultas en orden de enunciado.

---

## Documentación

### ¿Qué vamos a hacer?

Realizar una serie de consultas en la base de datos 00_db_tiendaBicis.

### ¿Con qué lo vamos a hacer?

Utilizando un editor de texto con capacidad de enviar consultas a servidor MySQL, en este caso, Visual Studio Code.

### ¿Cómo se ha hecho?

Apartado por apartado:
1. Devuelve el nombre completo del cliente tras comprobar la presencia de su ID en una subconsulta que busca todos los clientes con más de un pedido.
2. Devuelve el nombre de todos los productos que no se hayan encontrado en una subconsulta que lo busca en cada tienda o que no aparece listado en el stock.
3. Utiliza una subconsulta de muestra para ordenar los datos correctamente, *display*, para más adelante. Insertamos tanto los productos y el stock con menos de 3 existencias en las tiendas como los productos no listados en ninguna tienda con stock 0 en una tabla temporal. Seguidamente, devuelve la tabla temporal con los productos ordenados de menor a mayor stock. La tabla temporal es eliminada al terminar su utilización.
4. Consta de los siguientes subapartados:
	1. Dentro de subconsulta de *display*. Cuenta el total de cada producto haciendo el sumatorio de stock por tienda, agrupándolo por ID de producto, ordenado de mayor a menor existencias y escogiendo solo los 4 más abundantes. Devuelve el nombre del producto y el stock que tiene.
	2. Se ha generado una tabla temporal que contiene las IDs de las tiendas, las IDs de los productos, la cantidad y un identificador adicional particionado por tienda, que contiene el orden descendente de los productos por stock en cada una. Se utiliza esta tabla para obtener empleando este identificador los 4 primeros productos con más stock de cada tienda. La existencia de la tabla temporal se conserva para los siguientes apartados.
	3. Empleando la tabla temporal (o la tabla de stock, pues contiene la misma información empleada en este caso) se devuelve el sumatorio de la cantidad de cada producto multiplicada por su valor listado (tabla de productos). Seguidamente, se realiza el mismo procedimiento junto al nombre de la tienda, agrupándolas por identificador, mostrando así cuánto dinero hay bloqueado en cada tienda. En ambos casos se comprueba que el producto esté entre los 4 más vendidos de cada tienda (utilizando el identificador adicional mencionado en el apartado 4.3).
	4. Realiza lo mismo que el subapartado anterior, pero no hay limitaciones, es decir, lo realiza por cada artículo.
5. Dentro de subconsulta de *display*. Genera una subconsulta que contiene las IDs de clientes con los sumatorios del gasto total que han tenido en las tiendas, es decir, el sumatorio de la cantidad de producto por el precio del producto menos sí mismo por el descuento recibido. Seguidamente, se devuelven los diez primeros nombres completo de cliente y sus gastos totales, ordenados de mayor a menor.
6. Dentro de subconsulta de *display*. Similar al anterior, pero se utilza la cantidad de unidades compradas de todos los productos en lugar del precio (más sencillo).
7. Dentro de subconsulta de *display*. Ejecuta una subconsulta con las IDs de las tiendas y los sumatorios de productos vendidos y sus respectivas cantidades. Seguidamente, se muestra nombre de las tiendas, y los resultados de las operaciones anteriores por cantidad descendente e ingresos descendentes (dado que no se especifica en el enunciado, he elegido el orden que me ha parecido más adecuado).

**NOTA**: Del apartado 3 en adelante no se han tenido en cuenta los productos catalogados fuera de circulación dentro del stock.

### ¿Para qué se ha hecho?

Para entrenar la realización de consultas avanzadas.

### ¿Dónde se ha hecho?

Completamente en mi ordenador personal.

### ¿Quién lo ha hecho?

Daniel Píriz Cacho.

### ¿Cuándo se ha hecho?

Completado el 4 de enero de 2023.

---

## Enunciado
+ De la bbdd 00_db_tiendaBicis:
  + Muestra todos los compradores que tengan más de una compra.
  + Lista aquellos productos sin stock.
  + Lista aquellos productos con un stock menor de 3 unidades en orden ascendente.
  + Lista los 4 productos con más stock:
	+ En la empresa.
	+ Por cada tienda.
	+ Determina el dinero bloqueado en ese stock por empresa y en cada tienda.
	+ Y en todo el stock de la empresa por empresa y en cada tienda.
  + Ordena los compradores del más gastoso al menos.
	+ Lista sólo los 10 más gastosos.
  + Ordena los compradores del que más productos ha comprado al que menos.
	+ Lista sólo los 5 que más productos han comprado.
  + Ordena las tiendas por productos vendidos y por cantidad facturada.

Todos los listados deben tener sentido para un humano... esto es, `customer_id` no es un nombre válido para conocer los compradores, mejor por su nombre y apellido.
Evidentemente, eso es válido para los stocks de bicis y nombres de tiendas.

Recuerda: para listar la salida queda más bonita numerando los registros:

	mysql
	SET @i:=0;
	SELECT (@i:=@i+1 ) as 'n', ... FROM ... ;