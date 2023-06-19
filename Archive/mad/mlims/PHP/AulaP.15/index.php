<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Introducir plato</title>
    <?php require_once("../lib/sql_connect.php"); ?>
</head>

<body>
    <form method="post">
        <fieldset>
            <legend>Insertar nuevo plato</legend>
            <label for="name">Nombre: </label><input type="text" name="name" size="20" maxlength="20" require/><br/>
            <label for="price">Precio: </label><input type="number" name="price" size="5" maxlength="5" require/><br/>
            <label for="hot">Picante: </label><input type="checkbox" name="hot"/><br/>
            <input type="submit" value="Enviar"/>
        </fieldset>
    </form>
    <?php
    $name = $_REQUEST["name"];
    $price = $_REQUEST["price"];
    $hot = $_REQUEST["hot"];
    
    if (is_null($name) || is_null($price) || is_null($hot)) exit;

    $conn = database_connect("restaurante");
    $query = "INSERT INTO platos(nombre, precio, picante)";
    $query.= "VALUES ('".$name."', '".$price."', '".$hot."');";

    if (mysqli_query($conn, $query)){
        echo "Consulta realizada con éxito";
    }
    else{
        echo "Error al realizar consulta";
    }
    ?>
</body>

</html>