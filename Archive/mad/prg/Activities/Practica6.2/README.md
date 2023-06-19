# Práctica 6.2 - Brazo robot

## Anotaciones de la entrega

La clase de testeo de la entrega original es `Test`.

---

## Documentación

### ¿Qué vamos a hacer?

Crear una clase MatricesDeTransformacion que pueda calcular la cinemática inversa de un robot de dos ejes de libertad.

### ¿Con qué lo vamos a hacer?

Utilizando un editor de texto, en este caso, Notepad++.

### ¿Cómo se ha hecho?

1. Se han estudiado a fondo las fórmulas de cinemática inversa en 2D.
2. Se ha creado la clase `MatricesDeTransformacion` con una array de Strings en dos dimensiones con las coordenadas posibles.
3. Se ha creado la clase `Test` para probar la clase anterior libremente.

### ¿Dónde se ha hecho?

Realizado completamente en mi PC.

### ¿Quién lo ha hecho?

Daniel Píriz Cacho.

### ¿Cuándo se ha hecho?

Completado el 20/1/2023.

---

## Enunciado

Dado [cinemática de robot (2D)](https://youtu.be/9zSRNXRuX0g), se pide generar una matriz de transformación precalculada de forma que podamos  solicitarle a la apliación la ubicación de la punta en unas coordenadas cartesianas (x e y) y nos devuelva los ángulos de posicionamiento de los brazos robóticos.

Se solicita que nos facilitéis la respuesta de ángulos para todos los valores enteros de un cubo de dimensiones 1x1, teniendo en cuenta que el origen de coordenadas está en un vértice y la longitud de los brazos son de 10 ambos.

Restricciones: implementar el método `float[] cinematicaInversa2D(int x, int y)` de la clase `MatricesDeTransformacion` que podamos utilizar sin instanciar objetos, donde `float[]` será un vector con los valores de los 2 ángulos.

---

# Práctica 6.2 - TESTS

## Anotaciones de la entrega

Aunque el test ha fallado, la fórmula de la cinemática directa se ha probado por separado y funciona correctamente, por tanto, es el ejercicio el que está mal, no el test.

---

## Documentación

### ¿Qué vamos a hacer?

Crear un test unitario para probar el método `cinematicaInversa2D` de la clase `MatricesDeTransformacion`.

### ¿Con qué lo vamos a hacer?

Utilizando la librería JUnit.

### ¿Cómo se ha hecho?

Comparando los resultados obtenidos tras la ejecución de la función con los mismos precalculados con un margen de +-0.1º.

### ¿Dónde se ha hecho?

Completamente en mi ordenador personal.

### ¿Quién lo ha hecho?

Daniel Píriz Cacho.

### ¿Cuándo se ha hecho?

Corregida el 23/1/2023.

---

## Enunciado

Modificaremos la clase anterior para poder pasar test unitarios. Para ello deberemos asegurarnos que:
1. La clase se denomina `MatricesDeTransformacion`.
2. Implementaremos una batería de test unitarios para el método `cinematicaInversa2D(int x, int y): float[]` (testear 0,0; 0,10; 10,0; 10,10; 5,7;).
