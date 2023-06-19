# Examen 2ª evaluación

### Anotaciones de la entrega

1. Invertir la operación requeriría que la función devuelva un `char[][]`. Bastaría con comprobar si el `int` parseado a mano NO cumple con la condición original, tal que así:
```
for (int i = 0; i < inputArray.length; i ++){
    ...
    for (int j = 0; j < inputArray[i].length; j++){
        ...
        if (parsedChar >= 0 && parsedChar <= 9) charOnlyArray[i][j] = inputArray[i][j];
    }
}
```

> Se ha actualizado el nombre de la variable `intOnlyArray` para que encaje con el nuevo planteamiento.

4. Una interfaz en Java solo puede ser implementada de manera no estática, por tanto, la clase debe ser instanciada, rompiendo con la nota de la parte superior del examen.

---

## Documentación

### ¿Qué vamos a hacer?

Una serie de métodos estáticos para probar nuestro conocimiento de arrays, strings, colecciones, archivos y herencia.

### ¿Con qué lo vamos a hacer?

1. Arrays de primitivos.
2. String y StringBuilder.
3. HashMap y HashSet.
4. File, Files y ArrayList.

> Obligatoriamente se ha utilizado IntelliJ.

### ¿Cómo se ha hecho?

1. Para pasar las longitudes de la array de forma dinámica hay que declarar una array de `int[][]` cuya longitud en su primera dimensión es igual a la misma en la entrada. En cada pasada del bucle, se creará cada `int[]` para hacer las filas. En cuanto a los valores char a int, comprobando manualmente (cast explícito) si el valor real del char está en el rango de los caracteres numéricos (48 - 57). Para ello basta con restar 48 al resultado del cast y comprobar si el número resultante está entre 0 y 9 para añadirlo a la array. Si no se añade, el valor es por defecto (0).
2. Por cada caracter, convierte a valor int, resta 65 ó 97 dependiendo de si está en mayúsculas o no, añade 13, hace un ciclo usando el resto (`%`), suma la cifra antes restada, castea a char de nuevo y lo une al final de un StringBuilder, que se devuelve en String al terminar.
> Se ha utilizado StringBuilder porque realizar tantas uniones de caracteres puede resultar pesado para el ordenador.
3. Para almacenar la información, se utiliza la variable estática `studentsSkips`, que es un `HashMap<String, HashSet<String>>`, el cual tiene una clave String que será el nombre del alumno y otra HashSet<String>, que contiene la lista de faltas. Se asume que, dado que solo se pueden almacenar fechas y no horas, solo puede haber una falta por día, y por ende, el HashSet es oportuno.
4. Se han creado la interfaz `ArchivoDao` y la clase `ArchivoDaoImp`, la cual contiene dos métodos que utilizan `Files` y `ArrayList` para trabajar sobre archivos de texto, leyendo y escribiendo.

### ¿Dónde se ha hecho?

Elaborado en clase.

### ¿Quién lo ha hecho?

Daniel Píriz Cacho.

### ¿Cuándo se ha hecho?

El día 9 de marzo de 2023.