# Práctica 8.1 - Collections: Evaluación de Resultados

## Anotaciones de la entrega

Los nombres de las clases han sido renombrados por problemas de compatibilidad con proyectos de Java (están en el mismo repositorio). Soy plenamente consciente de que lo ideal es que se llamen de la misma forma y puedan ser sustituidos entre sí sin problemas.

---

## Documentación

### ¿Qué vamos a hacer?

Un sistema para gestionar la evaluación de ciclos formativos que pueda calcular la media de cada alumo y de cada módulo. Esta era originalmente la práctica 6.1, que ha sido actualizada para funcionar con HashMaps.

### ¿Con qué lo vamos a hacer?

Un IDE compatile con Java, en este caso con VSCode.

### ¿Cómo se ha hecho?

Se ha reutilizado y adaptado el código original, cambiando el sistema de notas de la clase `AlumnoCustom` para utilizar HashMaps con los nombres de los módulos para guardar sus notas. También se ha actualizado la clase `Evaluacion` para pasar los nombres de los módulos al alumno en lugar de sus identificadores como se hacía antes.

### ¿Dónde se ha hecho?

Completamente en clase.

### ¿Quién lo ha hecho?

Daniel Píriz Cacho.

### ¿Cuándo se ha hecho?

Completado el 23/1/2023.

---

## Enunciado

Repite la práctica de evaluación de resultados de los alumnos en los módulos con un mapa donde los índices serán el nombre de los módulos.

Para ello el programa nos solicitará al comienzo los módulos, para posteriormente solicitarnos uno a uno las notas de cada uno (nos debe indicar cuál nos está solicitando).

En esta ocasión, si recibe un "-1" NO debe almacenar nada ahorrando espacio y tiempo.

Asegúrate de que utilizas los nombre adecuados de forma que tu nueva implementación debe pasar los test de tu implementación anterior (práctica 6).