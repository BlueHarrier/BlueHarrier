<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MONEY SERVICE - CONTACTO</title>
    <style>
        h1{
            text-align: center;
        }
    </style>
    <?php
    require_once("../lib/sql_connect.php");
    $con = database_connect("money_service");

    $name = $_REQUEST["name"];
    $phone = $_REQUEST["phone"];
    $mail = $_REQUEST["mail"];
    $message = $_REQUEST["message"];

    $query = "INSERT INTO mensajes (nombre, telefono, correo, mensaje) VALUES (";
    $query.= "'$name', $phone, '$mail', '$message');";

    mysqli_query($con, $query);
    ?>
</head>
<body>
    <h1>MONEY SERVICE Asesoría y gestión de productos financieros</h1>
    <p>
        Se ha procesado su solicitud.
    </p>
</body>
</html>