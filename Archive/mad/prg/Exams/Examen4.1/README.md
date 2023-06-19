# Examen 4.1 - Programación Orientada a Objetos, ripoff de Netflix

## Observaciones

+ [1/1p] Crear un constructor de Serie con TODOS los atributos (el por defecto no).
+ [2/2p] Crear la Clase Posicion con su constructor por defecto y con TODOS los atributos.
+ [1/1p] Crear los getters y setters de la Clase Posicion.
+ [1,5/1,5p] Sobreescribe el método toString de la Clase Serie, asegurándote que llama al toString de la clase Posicion.
+ Crea una clase para probar tus clases Serie y Posicion:
	+ [0,5/0,5p] Invoca al constructor de Posicion con los valores de ir visionando por la temporada 3, capítulo 2, minuto 15.
	+ [0,5/0,5p] Invoca al constructor de Serie pasándole los datos 'The Wire', 5 temporadas, 10 capítulos y el objeto posición del punto 1.
	+ [1/1p] Invoca al constructor por defecto de Posicion y luego utilizar los setters para actualizar a temporada 4, capítulo 6, minuto 27.
	+ [0,5/0,5p] Invoca al constructor de Serie pasándole los datos 'IT Crew', 4 temporadas, 6 capítulos y la posición del punto 3.
	+ [1/1p] Imprime por pantalla los datos de las 2 series (invocanto a los toString sobreescritos).
+ [1/1p] Documentación del proyecto (en las Clases)

---

## Documentación

### ¿Qué vamos a hacer?

Vamos a crear un ripoff de Netflix que permita crear series y guardar la posición de un usuario en dichas series.

### ¿Con qué lo vamos a hacer?

Utilizaremos Java en un editor de texto plano y código, en este caso, Notepad++.

### ¿Cómo se ha hecho?

1. Constructor completo de Serie:
	- String nombre
	- String temporadas
	- int capítulos
	- Posicion posicion
2. Constructores por defecto y completo de Posicion:
	- int temporada (1)
	- int capitulo (1)
	- int posicion (0)
3. Getters y setters de Posicion:
	- setTemporada(int temp), getTemporada()
	- setCapitulo(int cap), getCapitulo()
	- setPosicion(int pos), getPosicion()
4. Sobreescribir toString():
	- Posicion: "temporada <t>, capítulo <c>, actualmente en el minuto <p>"
	- Serie: "'<n>' tiene <t> temporadas, con <c> capítulos cada una"
5. Ext4:
	- pos1(3, 2, 15)
	- serie1("The Wire", 5, 10, pos1)
	- pos2() -> 4, 6, y 27 usando setters
	- serie2("IT Crew", 4, 6, pos2)
	- Llamar a `serie1.toString()` y `serie2.toString()`.
6. Documentar código.

> Copiado directamente de la versión en papel

### ¿Dónde se ha hecho?

Completamente en clase (examen).

### ¿Quién lo ha hecho?

Daniel Píriz Cacho.

### ¿Cuándo se ha hecho?

7/11/2022.

---

## Enunciado

Queremos crear un clon personal de `Netflix`. Para ello deberemos crear la Clase `Serie` que nos gestione las series con los atributos:
+ String nombre.
+ int temporadas, capítulos.
+ Posicion: objeto con los atributos int temporada, int capitulo e int posicion (en minutos).

Para ello deberemos:
1. [1p] Crear un constructor de `Serie` con TODOS los atributos (el por defecto no).
2. [2p] Crear la Clase `Posicion` con su constructor por defecto y con TODOS los atributos.
3. [1p] Crear los getters y setters de la Clase `Posicion`.
4. [1,5p] Sobreescribe el método `toString` de la Clase `Serie`, asegurándote que llama al `toString` de la clase `Posicion`.
5. Crea una clase para probar tus clases `Serie` y `Posicion`:
	1. [0,5p] Invoca al constructor de `Posicion` con los valores de ir visionando por la temporada 3, capítulo 2, minuto 15.
    2. [0,5p] Invoca al constructor de `Serie`pasándole los datos 'The Wire', 5 temporadas, 10 capítulos y el objeto posición del punto 1.
	3. [1p] Invoca al constructor por defecto de `Posicion` y luego utilizar los `setters` para actualizar a temporada 4, capítulo 6, minuto 27.
	4. [0,5p] Invoca al constructor de `Serie` pasándole los datos 'IT Crew', 4 temporadas, 6 capítulos y la posición del punto 3.
	5. [1p] Imprime por pantalla los datos de las 2 series (invocanto a los `toString` sobreescritos).
6. [1p] Documentación del proyecto (en las Clases).

---
Tiempo: **130 minutos** => *Hora máxima del commit 17:10 CEST del 7 de noviembre de 2022*

**Instrucciones**:
+ Debes crear y subir tu exámen a tu repositorio con un `README.md` con tu nombre y apellidos y la estructura de archivos utilizada.
+ Debes adjuntar 3 archivos fuente: `ExT4.java`, `Serie.java` y `Posicion.java`. *la corrección será automática por lo que si no se llaman EXACTAMENTE así no funcionará*.
+ Sólo puedes utilizar el CLI y el bloc de notas o notepad++. Está expresamente prohivido el uso de cualquier otra herramienta o software más allá del CLI, git y el bloc de notas.