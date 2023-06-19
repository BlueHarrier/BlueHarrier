# Examen 6 - Arrays

## Documentación

### ¿Qué vamos a hacer?

Un juego que genere un candado de combinación que el usuario deberá averiguar.

### ¿Con qué lo vamos a hacer?

Con dos clases, la que contiene el código secreto y el sistema de juego.

### ¿Cómo se ha hecho?

Creando la clase `CodigoSecreto`, que contiene la interfaz para generar un número secreto de n dígitos, parsear otros números y comprobar si el número es correcto y cómo de correcto es. Por otro lado, la clase `Juego` recibe el número de dígitos, crea el objeto de `CodigoSecreto` y gestiona las entradas del programa.

### ¿Dónde se ha hecho?

Completamente en clase (examen).

### ¿Quién lo ha hecho?

Daniel Píriz Cacho.

### ¿Cuándo se ha hecho?

12/01/2023.

---

## Enunciado

Vamos a desarrollar un juego que consiste en generar un número aleatorio y que le pidamos al usuario que lo adivine.
1. El ejercicio comenzará solicitándonos la dificultad (número de dígitos del número) con el que generaremos el objeto de la clase `CodigoSecreto`, donde su constructor se encargará de generarnos un número aleatorio con los dígitos solicitados `int[]`.
2. Después solicitará al jugador un número para probar. Para ello la clase `CodigoSecreto` nos facilita el método `public int[] convierteCodigo(String s)`.
3. Con el número convertido a un array podemos llamar al método `public boolean pruebaCodigo(int[] c)` que nos indicará dígito a dígito si son iguales (=) o si el dígito buscado es mayor (M) o menor (m) así como el número de aciertos.

### Entrada
```
4
5555
2822
1711
1602
```

### Salida
```
mMmm0
mmm=1
=mmM1
====4
```
