# Examen 7 - Strings

## Anotaciones de la entrega

En el examen había una errata: *Colega,* **colegita,** *colegón...*. El programa se ha creado sin el fallo.

---

## Documentación

### ¿Qué vamos a hacer?

Comprobar si un mensaje se ha dicho por un ciudadano masculino, femenino o extranjero de un pueblo ficticio.

### ¿Con qué lo vamos a hacer?

Utilizando `String`s básicos de Java.

### ¿Cómo se ha hecho?

Se ha utilizado principalmente el método `String.substr` para obtener, comparar y recortar las cadenas de caracteres, separando la comprobación de hombre y de mujer en dos métodos distintos. Todos los casos se encuentran en bucle infinito (`while (true)`) que se rompe al introducir la cadena correcta, y continúa si una de las comprobaciones se da por válida, impidiendo el último caso, que el hablante sea extranjero.

### ¿Dónde se ha hecho?

Completamente en clase (examen).

### ¿Quién lo ha hecho?

Daniel Píriz Cacho.

### ¿Cuándo se ha hecho?

12/01/2023.

---

## Enunciado

En mi pueblo son un poco raros y todos los hombres comienzan las frases con un deje un poco particular "Colega, coleguita, colegón" y las mujeres las acaban con el típico ", bueno pero ésto que quede entre nosotros.".

Como podréis imaginar, hablar con ellos es un poco pesado por lo que se os pide que realicéis un traductor de forma que nos elimine las coletillas, pero nos informe si nos está hablando un hombre, una mujer o un *extranjero*.

El programa finalizará al recibir el código "fin de la conversación".

### Entrada
```
Colega, coleguita, colegón estaba el otro día tomando unas cañas...
Y así fue como sucedió todo, bueno pero ésto que quede entre nosotros.
Mira el coche que se ha comprado mi vecino.
fin de la conversación
```

### Salida
```
[HOMBRE] Estaba el otro día tomando unas cañas...
[MUJER] Y así fue como sucedió todo.
[EXTRANJERO] Mira el coche que se ha comprado mi vecino
```
