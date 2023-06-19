# Práctica 7.1 - Strings

## Documentación

### ¿Qué vamos a hacer?

Un programa que genera una serie de cartas personalizadas dadas una plantilla y un archivo CSV con los datos de cada persona.

### ¿Con qué lo vamos a hacer?

Utilizando un editor de código, en este caso VSCode.

### ¿Cómo se ha hecho?

1. Documentarse sobre la interfaz de las clases especificadas (`Parametros` y `TrabajarArchivos`).
2. Programar los algoritmos de reemplazo necesarios en el método `Main` de la clase `Main`.
3. Utilizar las clases dadas con `Main`.

### ¿Dónde se ha hecho?

Realizado completamente en clase.

### ¿Quién lo ha hecho?

Daniel Píriz Cacho.

### ¿Cuándo se ha hecho?

Completado el 12/12/2022.

---

## Enunciado

Realiza un programa que dados los archivos `carta.txt` y `destinatarios.csv` implemente el controlador Main que:

> 0 - Declaración de variables
> 
> 1 - Cargamos el archivo CSV y lo parseamos dentro de una instancia de la clase Parametros
> 
> 2 - Cargamos la carta a memoria
> 
> 3 - Cargamos los datos CSV
> 
> 4 - Cargamos los datos a parsear según usuario
> 
> 5 - Ahora realizamos las sustituciones
> 
> 6 - Escribimos las cartas y mostramos el resultado

Para la implementación disponemos de la clase `TrabajarArchivo` cuya `interface` podéis verla en `Github` y la implementación de la clase `Parametros`, también en `Github`.

Tienes disponible en `Github` la interfaz de `TrabajarArchivo`, la implementación de `Parametro`, la carta y el archivo CSV con los datos a procesar.

> Nota: el carácter `$` se debe sustituir por su varlor literal `\u0024` y debe ir escapado `\\`.