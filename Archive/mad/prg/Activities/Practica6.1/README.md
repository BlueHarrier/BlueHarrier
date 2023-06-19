# Práctica 6.1 - Cálculo de nota de evaluación

## Anotaciones de la entrega

Para no confundirla con el apartado de tests, la actividad original es testeada con la clase `Evaluacion`.

---

## Documentación

### ¿Qué vamos a hacer?

Crear un sistema de evaluación que compruebe las notas de los alumnos en distintos módulos cada uno y las muestre individualmente por pantalla junto a las medias por ciclo y media global, utilizando además colores.

### ¿Con qué lo vamos a hacer?

Utilizando un editor de texto, en este caso, Notepad++ y Visual Studio Code, y las herramientas de Java.

### ¿Cómo se ha hecho?

1. Implementar la clase Modulo, que contiene los atributos asociados a este.
2. Implementar la clase Alumno, que tiene una array de notas y una array relacional de IDs de cada módulo al cual se ha presentado.
3. Implementar una clase evaluacion que ejecutará la pruebra de funcionalidad con datos "hardcodeados".
4. Implementar métodos de apoyo a la construcción de la tabla de notas.
5. Implementar la clase reutilizable AnsiBuilder, que contiene valores ansi de los colores para terminal.

### ¿Dónde se ha hecho?

Realizado parcialmente en clase y mayoritariamente en casa.

### ¿Quién lo ha hecho?

Daniel Píriz Cacho.

### ¿Cuándo se ha hecho?

Completado el 05/12/2022.

---

## Enunciado

** Evaluación de resultados. **
Crear una aplicación que nos evalue los resultados obtenidos en la primera evaluación, esto es, deberéis crear una aplicación que recoga:
1. Un número indeterminado de alumnos (filas)
2. Cada alumno tendrá un número indeterminado de módulos (no todos los alumnos tienen los mismos módulos) (columnas)
3. Determinar la media de las notas del alumno (filas)
4. Determinar la media de las notas de cada módulo (columnas)
5. Determinar la media global (filas y columnas)

Restricciones: debe mostrar la tabla completa con los nombres de las materias, de los alumnos y resaltar las medias en colores. Los datos de entrada estarán `harcodeados`.

---

# Práctica 6.1 - TESTS

## Documentación

### ¿Qué vamos a hacer?

Adaptar la práctica para funcionar con tests unitarios.

### ¿Con qué lo vamos a hacer?

Con Junit.

### ¿Cómo se ha hecho?

Refactorizando la práctica original debido a un conflicto con la clase `Alumno`, implementando los métodos requeridos y ejectuando un test para cada uno. Además, se ha creado la clase `TrabajarArchivo` para poder utilizar la interfaz solicitada con el proyecto.

### ¿Dónde se ha hecho?

Mayoritariamente en mi ordenador personal y parcialmente en clase.

### ¿Quién lo ha hecho?

Daniel Píriz Cacho.

### ¿Cuándo se ha hecho?

1 de marzo de 2023.

---

## Enunciado

Modificaremos la clase anterior para poder pasar test unitarios. Para ello deberemos asegurarnos que:
1. La clase se denomina `evaluacionResultados`.
2. Creamos los métodos:
   - `listarNotaAlumno(String alumno): float []` -> devuelve las notas del alumno con 2 decimales.
   - `listarNotasModulos(String modulo): float []` -> devuelve la nota del modulo con 2 decimales.
   - `mediaAlumno(String alumno): float` -> devuelve la media del alumno con 2 decimales.
   - `mediaModulo(String modulo): float` -> devuelve la media del módulo con 2 decimales.
3. La clase carga los datos de un archivo CSV donde la primera fila serán los nombre de los módulos y la primera columna el nombre de los alumnos.
4. Crearemos los test unitarios que nos permitan verificar los métodos anteriores.