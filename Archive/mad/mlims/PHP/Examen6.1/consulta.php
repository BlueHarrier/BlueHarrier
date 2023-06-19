<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
    <title>CENTRO EDUCATIVO</title>
    <?php
    $result_visible = "none";
    $error_visible = "none";
    $no_result_visible ="none";
    require_once("../lib/sql_connect.php");
    if(!empty($_REQUEST)){
        try{
            $conn = database_connect("dbalumnos");
            $id = $_REQUEST["dni"];

            function add_student($i, $student){
                $table_id = $student["id"];
                $name = $student["nombre"];
                $surname = $student["apellido"];
                $id = $student["dni"];
                if ($i % 2 == 0) echo "<tr class=\"alumno_par\">";
                else echo "<tr class=\"alumno_impar\">";
                echo "
                    <td>$table_id</td>
                    <td>$name</td>
                    <td>$surname</td>
                    <td>$id</td>
                </tr>
                ";
            }

            $result = mysqli_query($conn, "SELECT * FROM alumno WHERE dni LIKE '$id';");
            $count = mysqli_num_rows($result);

            if ($count > 0) $result_visible = "box";
            else $no_result_visible = "box";
        }
        catch(Exception $e){
            $error_visible = "box";
        }
    }
    ?>

    <style>
        #result{
            display: <?php echo $result_visible;?>;
        }

        #error{
            display: <?php echo $error_visible;?>;
        }

        #no-result{
            display: <?php echo $no_result_visible;?>;
        }
    </style>
</head>

<body>
    <header style="height:100px">
        <h1><a href="./index.html">CENTRO EDUCATIVO</a></h1>
    </header>
    <section>
        <form action="consulta.php" method="post">
            <label for="dni">DNI: </label><input name="dni" type="text" maxlength="9" required/><br/>
            <input type="submit" value="Buscar"/>
        </form>
        <div id="error">Se ha producido un error: <?php echo $e;?></div>
        <div id="result">
            <table border>
                <thead>
                    <tr>
                        <td>Nº de solicitud</td>
                        <td>Nombre</td>
                        <td>Apellido</td>
                        <td>DNI</td>
                    </tr>
                </thead>
                <tbody>
                    <?php
                    if ($count > 0){
                        for ($i = 0; $i < $count; $i++){
                            $student = mysqli_fetch_assoc($result);
                            add_student($i, $student);
                        }
                    }
                    ?>
                </tbody>
            </table>
        </div>
    </section>
</body>

</html>