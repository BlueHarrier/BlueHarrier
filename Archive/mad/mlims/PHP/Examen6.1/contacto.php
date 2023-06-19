<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
    <title>CENTRO EDUCATIVO</title>
    <?php
    $form_visible = "box";
    $error_visible = "none";
    $success_visible = "none";
    require_once("../lib/sql_connect.php");
    if(!empty($_REQUEST)){
        $form_visible = "none";
        try{
            $conn = database_connect("dbalumnos");
            $name = $_REQUEST["nombre"];
            $surname = $_REQUEST["apellido"];
            $id = $_REQUEST["dni"];

            mysqli_query($conn, "INSERT INTO alumno (nombre, apellido, dni) VALUES ('$name', '$surname', '$id');");
            $success_visible = "box";
        }
        catch(Exception $e){
            $error_visible = "box";
        }
    }
    ?>

    <style>
        form{
            display: <?php echo $form_visible;?>;
        }

        #error{
            display: <?php echo $error_visible;?>;
        }

        #success{
            display: <?php echo $success_visible;?>;
        }
    </style>
</head>

<body>
    <header style="height:100px">
        <h1><a href="./index.html">CENTRO EDUCATIVO</a></h1>
    </header>
    <section>
        <div id="error">Se ha producido un error: <?php echo $e;?></div>
        <div id="success">La solicitud se ha procesado correctamente</div>
        <form action="contacto.php" method="post">
            <label for="nombre">Nombre: </label><input name="nombre" type="text" maxlength="20"  required/><br/>
            <label for="apellido">Apellido: </label><input name="apellido" type="text" maxlength="20"  required/><br/>
            <label for="dni">DNI: </label><input name="dni" type="text" maxlength="9" required/><br/>
            <input type="submit" value="Enviar"/>
        </form>
    </section>
</body>

</html>