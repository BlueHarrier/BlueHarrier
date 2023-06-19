<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bases de datos</title>
    <?php require_once("../lib/sql_connect.php"); ?>
</head>

<body>
    <?php
    $conn = database_connect("quiz");

    $question = "'¿Quién formuló el principio dualidad onda corpúsculo?'";
    $op1 = "'Plank'";
    $op2 = "'Dirac'";
    $op3 = "'De Broglie'";
    $op4 = "'Einstein'";
    $ans = "3";

    $query = "INSERT INTO preguntas(pregunta, op1, op2, op3, op4, buena)";
    $query.= "VALUES ($question, $op1, $op2, $op3, $op4, $ans);";

    $result = mysqli_query($conn, $query);

    if ($result){
        echo "Consulta realizada correctamente";
    }
    else{
        echo "Error al realizar la consulta";
    }
    ?>
</body>

</html>