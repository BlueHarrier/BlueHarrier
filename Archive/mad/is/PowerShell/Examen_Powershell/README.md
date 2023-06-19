# Examen tema 3 - Powershell

## Enunciado

1. Script en Powershell que saque por pantalla cuál es el archivo más antiguo de cada directorio, su ruta, la fecha de creació y su tamaño en MB, que cuelgue de C:\users.
2. Script en Powershell que añada al programador de tareas del equipo la tarea programada "recuerda_aniversario". Esta tarea tiene que recordarme, (ejecutar recordatorio), cada 15 minutos durante todo el día anterior a la fecha del aniversario, que será preguntada antes de crear la tarea.
3. Script en Powershell que elimine los usuarios que hace más de un año que no acceden a su carpeta de usuario y ésta ocupa más de 5GB. El script también eliminará la carpeta de usuario.
4. Script de Powershell que cree un servicio que se ejecute al cargar en Windows y que nos avise, (puede utilizar código del ejercicio 2), cuando quede menos de 1GB de espacio libre en la unidad C:, que el ordenador se va a apagar en 1 minuto. Pasado ese tiempo, el ordenador se apagará mediante el cmdlet correspondiente.
5. Script en Powershell que lea el archivo de texto C:\USERS\Baneados.txt. En dicho archivo hay un nombre de usuario por linea. Cada usuario que aparezca, será deshabilitado del sistema, si ya estaba deshabilitado será eliminado, si ya estaba eliminado se borrará su carpeta de usuario, y si ésta ya ha sido borrada, se mostrará un mensaje diciendo: "Este usuario ha sido totalbaneado de este PC". Para cada acció (deshabilitar, eliminar y borrar) se mostrará un mensaje con la acción realizada.