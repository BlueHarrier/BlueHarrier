# Práctica 4.1 - Programación Orientada a Objetos

## Observaciones

+ No respetas los interfaces. Debes crear 2 clases independientes, libro y controlador.
+ Corregido.

---

## Documentación

### ¿Qué vamos a hacer?

Crear una clase "Libro" que guarda el título y autor de un libro, además de la cantidad de copias y préstamos que tiene en una biblioteca.

### ¿Con qué lo vamos a hacer?

Utilizando un editor de texto, en este caso, Notepad++.

### ¿Cómo se ha hecho?

1. Se han creado los constructores.
2. Se han creado getters y setters, teniendo en cuenta que las copias prestadas y copias totales tienen limitaciones.
3. Se han creado los métodos de alquilar y devolver copia.
4. Se ha sobreescrito el método toString.
5. Se ha creado un método main con un test completo de los métodos de la clase.

### ¿Dónde se ha hecho?

Realizado completamente en el portátil de clase.

### ¿Quién lo ha hecho?

Daniel Píriz Cacho.

### ¿Cuándo se ha hecho?

Completado el 03/11/2022.

---

## Enunciado

Basándonos en el ejercicio 3 donde nos pedían realizar una clase Libro para gestionar una biblioteca:
+ Añade un constructor que reciba el título y los ejemplares totales disponibles en la biblioteca.
+ Realiza una clase para probar todos los métodos desarrollados.

>3. Crea una clase llamada `Libro` que guarde la información de cada uno de los libros de una biblioteca. La clase debe guardar el título del libro, autor, número de ejemplares del libro y número de ejemplares prestados. La clase contendrá los siguientes métodos:
>- Constructor por defecto.
>- Constructor con parámetros.
>- Métodos `setters` y `getters`
>- Método `prestamo` que incremente el atributo correspondiente cada vez que se realice un préstamo del libro. No se podrán prestar libros de los que no queden ejemplares disponibles para prestar. Devuelve true si se ha podido realizar la operación y false en caso contrario.
>- Método `devolucion` que decremente el atributo correspondiente cuando se produzca la devolución de un libro. No se podrán devolver libros que no se hayan prestado. Devuelve true si se ha podido realizar la operación y false en caso contrario.
>- Método `toString` para mostrar los datos de los libros. Este método se heredada de Object y lo debemos modificar (override) para adaptarlo a la clase Libro. \
>Escribe un programa para probar el funcionamiento de la clase Libro. \
>*Nota: uso de `@Override`. Devuelve una representación textual del objeto.*
>```
>...
>@Override
>public String toString() {
>    return "El texto que queramos " + atr_objeto ;
>}
>```
>