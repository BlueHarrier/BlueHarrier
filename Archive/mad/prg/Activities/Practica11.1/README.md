# Práctica 11.1 - Bases de Datos

## Documentación

### ¿Qué vamos a hacer?

Implementar una interfaz DAO dos veces: para archivos CSV y para MySQL / MariaDB, y otra más para las credenciales de conexión. Por otro lado, un controlador que permita cargar un archivo de CSV a la base de datos, solicitando una serie de cambios en el proceso.

### ¿Con qué lo vamos a hacer?

Utilizando Java, un servidor MariaDB y el driver de MySQL.

### ¿Cómo se ha hecho?

1. El objeto de Alumno consta de los atributos correspondientes del CSV más el adicional `id`, que equivale al mismo en la base de datos.
2. Se han tomado las dos interfaces que se adjuntaban.
3. La implementación `DaoImpCSV` utiliza la clase `Files` para leer todas las líneas, y `StringTokenizer` para tomar cada valor por separado. Todas las demás funciones están también implementadas, aunque no se han utilizado en la actividad.
4. La colección va incluida en la interfaz DAO.
5. Se ha implementado `DaoImpMariaDB` con todos los métodos, que permite leer, añadir, eliminar y alterar valores de la base de datos.
6. Se ha implementado `Controlador`, la clase principal, que ejecuta paso a paso las especificaciones solicitadas (menos la segunda, que ha sido marcada como innecesaria). Se ha creado una interfaz de usuario elaborada.
7. El programa pregunta al final si se desea salir.

### ¿Dónde se ha hecho?

Completamente en clase.

### ¿Quién lo ha hecho?

Daniel Píriz Cacho.

### ¿Cuándo se ha hecho?

Completado el 11 de mayo de 2023.

---

## Enunciado

1. Crear objeto que mapee dicho archivo.
2. ~~Crea una interfaz DAO~~ Tomar la interfaz que se adjunta.
3. Implementa la interfaz DAO que permita leer el archivo de texto CSV.
4. Crear una colección que almacene los datos del archivo.
5. Implementa el modelo mediante la implementación de la interfaz DAO:
    * DaoImpCSV -> permite trabajar con CSV o archivo con Lista de Alumnos serializado.
    * DaoImpMySQL o DaoImpMariaDB -> permita trabajar con una base de datos local o remota (los datos de conexión deben encontrarse protegidos a través de la implementación de la interfaz Conexión (adjunta).
6. El controlador deberá:
    * Solicitar archivo del que leer y leer todos los elementos de archivo.
    * ~~Solicitar que elementos se desean modificar~~.
    * Solicitar que elementos copiar a la bbdd y copiarlos usando el método addList(`List<T> list`).
    * Mostrar SOLO el nombre y email de todos los elementos, solicitar cuales borrar y borrarlos.
7. Preguntar si se desea salir o cargar otro archivo de disco.