# Práctica 5.1 - Altura de un árbol general

## Observaciones

+ Pese a que funciona, no respeta las normas de la clase donde se indica que no utilizaremos NUNCA 2 clases en un mismo archivo.
+ Corregido.

---

## Documentación

### ¿Qué vamos a hacer?

Crear una clase Arbol ("Tree") a la cual introduciremos el número de casos de prueba seguido de un expresado de forma lineal, a los cuales devolverá su altura.

### ¿Con qué lo vamos a hacer?

Utilizando un editor de texto, en este caso, Notepad++.

### ¿Cómo se ha hecho?

1. Se ha creado la clase estática "Branch" ("Rama"), cuyos objetos solo contienen la variable de la altura de la rama.
2. Se ha creado el constructor de dicha clase, que utiliza el Scanner de entrada para conseguir el número de ramas que debe generar y pasárselo a cada una de ellas, añadiendo además un punto a la altura total del árbol.
3. Cada nueva rama es descartada después, pues solamente nos interesa la altura del árbol.*
4. Se ha creado el getter para obtener la altura de una rama.
5. El método main crea el escáner de entrada, recoge el número de casos y crea los árboles a medida que se van introduciendo por consola.

> *He tenido que crear dos versiones del programa, pues la primera dio un error de memoria (excedía el límite de 4 MB). La versión 1.0.0 conservaba todas las ramas creadas en arrays dentro de sí mismas, pero dada la naturaleza del enunciado, esto no era necesario.

### ¿Dónde se ha hecho?

Realizado completamente en mi PC.

### ¿Quién lo ha hecho?

Daniel Píriz Cacho.

### ¿Cuándo se ha hecho?

Completado el 05/11/2022.

### Veredicto de ¡Acepta el Reto!

![Captura de la página donde se muestra el resultado aceptado](./img/captura.png)

---

## Enunciado

+ [Altura de un árbol general](https://www.aceptaelreto.com/problem/statement.php?id=310&cat=10)

Deberéis implementarlo mediante objetos, bucles y condicionales... vamos, lo que hemos visto en clase y sólo eso.