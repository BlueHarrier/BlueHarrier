<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Borrar entrada</title>
    <?php
    require_once("../lib/sql_connect.php");

    $conn = database_connect("quiz");
    $query = "DELETE FROM preguntas WHERE id = 5;";
    mysqli_query($conn, $query);
    ?>
</head>

<body>

</body>

</html>