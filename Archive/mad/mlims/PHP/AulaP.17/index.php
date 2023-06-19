<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar tabla</title>
    <?php
    require_once("../lib/sql_connect.php");

    $conn = database_connect("quiz");
    $query = "UPDATE preguntas SET pregunta = '¿Quién vive en la piña debajo del mar?' WHERE id = 3;";
    mysqli_query($conn, $query);
    $query = "UPDATE preguntas SET op1 = 'Bob Dylan' WHERE id = 3;";
    mysqli_query($conn, $query);
    $query = "UPDATE preguntas SET op2 = 'Tú' WHERE id = 3;";
    mysqli_query($conn, $query);
    $query = "UPDATE preguntas SET op3 = 'Yo' WHERE id = 3;";
    mysqli_query($conn, $query);
    $query = "UPDATE preguntas SET op4 = 'Bob Esponja' WHERE id = 3;";
    mysqli_query($conn, $query);
    $query = "UPDATE preguntas SET buena = 4 WHERE id = 3;";
    mysqli_query($conn, $query);
    ?>
</head>

<body>
    
</body>

</html>