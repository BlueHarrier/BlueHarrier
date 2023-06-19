<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Consultas</title>
    <style>
        thead {
            text-align: center;
            font-weight: bold;
        }
    </style>
    <?php require_once("../lib/sql_connect.php"); ?>
</head>

<body>
    <table border>
        <thead>
            <tr>
                <td>Platos</td>
                <td>Precio</td>
                <td>Picante</td>
            </tr>
        </thead>
        <tbody>
            <?php
            $conn = database_connect("restaurante");
            
            function create_dish($name, $price, $hot){
                echo "<tr>";
                echo "<td>".$name."</td>";
                $price /= 100;
                echo "<td>".$price."€</td>";
                if ($hot){
                    echo "<td>Sí</td>";
                }
                else{
                    echo "<td>No</td>";
                }
                echo "</tr>";
            }

            $query = "SELECT nombre, precio, picante FROM platos;";
            $result = mysqli_query($conn, $query);
            $count = mysqli_num_rows($result);
            
            for ($i = 0; $i < $count; $i++){
                $attributes = mysqli_fetch_assoc($result);
                create_dish($attributes["nombre"], $attributes["precio"], $attributes["picante"]);
            }
            ?>
        </tbody>
    </table>
</body>

</html>