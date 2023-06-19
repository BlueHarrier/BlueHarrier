<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formación para todos</title>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
    <?php
    require_once("../lib/sql_connect.php");

    $form_visible = true;
    $correct_visible = false;
    $error_visible = false;

    if (!empty($_REQUEST)){
        try{
            $conn = database_connect("formacion_para_todos");
            
            $name = $_REQUEST["name"];
            $surname = $_REQUEST["surname"];
            $title = $_REQUEST["title"];
            $st_start = $_REQUEST["st_start"];
            $st_end = $_REQUEST["st_end"];
            $email = $_REQUEST["email"];

            mysqli_query($conn, "
                INSERT INTO usuarios (nombre, apellidos, titulo, fecha_ini, fecha_fin, email)
                    VALUES ('$name', '$surname', '$title', '$st_start', '$st_end', '$email');
            ");

            $form_visible = false;
            $correct_visible = true;
        }
        catch(Exception $e){
            $form_visible = false;
            $error_visible = true;
        }
    }
    ?>
    <style>
        section{
            margin-bottom:30px;
            display: <?php echo ($form_visible ? "block" : "none");?>;
        }
        #correct{
            display: <?php echo ($correct_visible ? "block" : "none");?>;
        }
        #error{
            display: <?php echo ($error_visible ? "block" : "none");?>;
        }
        #data{
            float:left;
            width:20%;
        }
        #values{
            float:left;
            width:80%
        }
        #conditions{
            float:none;
            width:100%;
            text-align: center;
        }
        label{
            font-weight: lighter;
        }
    </style>
</head>

<body>
    <h1>Bienvenido al sitio de inscripción "Formación para Todos"</h1>
    <section>
        Rellene todos los campos del formulario y<br/>
        haga click en el botón "Enviar" para validar su inscripción.
        <form method="post" action="./form.php">
            <div id="data">
                <label for="name">Nombre:</label><br/>
                <label for="surname">Apellido:</label><br/>
                <label for="title">Título de la formacion:</label><br/>
                <label for="st_start">Inicio de la formación:</label><br/>
                <label for="st_end">Fin de la formación:</label><br/>
                <label for="email">Dirección de correo:</label>
            </div>
            <div id="values">
                <input name="name" type="text" maxlength="20" size="40" required/><br/>
                <input name="surname" type="text" maxlength="40" size="40" required/><br/>
                <input name="title" type="text" maxlength="40" size="40" required/><br/>
                <input name="st_start" type="date" size="40" required/><br/>
                <input name="st_end" type="date" size="40" required/><br/>
                <input name="email" type="text" maxlength="40" size="40" required/>
            </div>
            <div id="conditions">
                <input name="conditions" type="checkbox" required/>
                <label for="conditions">Acepto las condiciones, accesibles desde <a href="#">este enlace</a>.</label><br/>
                <input type="submit" value="Enviar"/>
            </div>
        </form>
    </section>
    <div id="correct">
        La consulta se ha procesado correctamente.
    </div>
    <div id="error">
        Se ha producido un error: <?php echo $e; ?>
    </div>
</body>

</html>