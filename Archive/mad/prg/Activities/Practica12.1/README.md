# Práctca 12.1 - Jakarta

## Anotaciones de la entrega

Para la parte de JSP se ha utilizado uno de los [ejercicios](./tomcat/Ejercicios/formularios.jsp).

---

## Documentación

### ¿Qué vamos a hacer?

Desplegar un servidor Tomcat on JakartaEE, utilizando la tecnología JSP y servlet.

### ¿Con qué lo vamos a hacer?

Aunque en clase se ha utilizado IntelliJ, esta práctica se ha realizado con Docker. Basta con realizar `docker compose up` para descargar e iniciar Tomcat, con todas las configuraciones preparadas.

### ¿Cómo se ha hecho?

1. Se ha creado un [docker compose](./docker-compose.yaml) para montar el servidor Tomcat.
2. En la carpeta [Ejercicios](./tomcat/Ejercicios/) se encuentran los distintos ejercicios de JSP planteados en clase.
3. En la carpeta [ROOT](./tomcat/ROOT/) se ha añadido un pequeño índice con la parte principal de la práctica.
4. En la carpeta [ajax](./tomcat/ajax/) se encuentra el index.html que contiene la pequeña aplicación en JS de AJAX, y [WEB-INF](./tomcat/ajax/WEB-INF/) están las clases con su código fuente y el archivo de configuración de la página web para conectar los servlets correctamente.

### ¿Dónde se ha hecho?

Completamente en clase.

### ¿Quién lo ha hecho?

Daniel Píriz Cacho.

### ¿Cuándo se ha hecho?

Completado el 29 de mayo de 2023.

---

## Ejercicios

[Página de ejercicios](https://tc.luiscastelar.duckdns.org/jsp/tuto-0.jsp).

---

## Enunciado

Deberás crear una interfaz de usuario con las tecnologías Ajax (jQuery) y Servlet que realicen la siguiente conexión:

1. La página (JSP o HTML5) dispondrá de la tecnología asíncrona AJAX que nos facilita la librería jQuery de forma que los distintos procesos se lancen cuando el usuario decida.
2. Si se pulsa el botón "Borrar" se eliminará el resultado (asíncrono, pero sin conexión con servidor)
3. Si se pulsa "Calcular" deberás capturar el texto introducido en el input y comunicarlo via AJAX con el Servlet.
4. El Servlet recibirá los datos y realizará una llamada a la calculadora de pila implementada en el tema 6.
5. El Servlet devolverá el resultado vía html/plano o json (opcional).
6. AJAX capturará la respuesta y actualizará el contenido del campo RESULTADO.

Nota: si detectas que tu calculadora no acepta decimales o números de más de un dígito, no es necesario modificar la calculadora. Sólo necesitamos que aprendas el uso de librerías propias o de terceros (y a leer).

Si lo realizas mediante html deberás además añadir un JSP que contenga:

* Al menos un tag de directiva
* Al menos un tag de comentario
* Al menos un tag de declaración de variable y otro del método:
```
String sumaMultiple (int a, int b, int c) {
    return String.valueOf( a + b + c);
}
```
* Al menos un tag de expresión donde usemos alguna de las declaraciones anteriores.
* Al menos un tag scriptlet que imprima un "hola mundo".