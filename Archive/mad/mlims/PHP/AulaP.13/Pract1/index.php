<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <form action="./result.php" method="post">
        <?php
        const PACKAGE_NUMBER = 5;
        echo "<input type=\"number\" value=\"".PACKAGE_NUMBER."\" name=\"packages\" style=\"display:none;\"/>";

        function create_package($id){
            echo "<label for=\"pack{$id}\">Paquete ".($id + 1).":</label>";
            echo "&nbsp<input type=\"radio\" name=\"pack{$id}\" value=5 required>5Kg</input>";
            echo "&nbsp<input type=\"radio\" name=\"pack{$id}\" value=10 required>10Kg</input>";
            echo "&nbsp<input type=\"radio\" name=\"pack{$id}\" value=15 required>15Kg</input>";
            echo "&nbsp<input type=\"radio\" name=\"pack{$id}\" value=20 required>20Kg</input>";
            echo "<br/>";
        }

        for ($i = 0; $i < PACKAGE_NUMBER; $i++){
            create_package($i);
        }
        ?>
        <input type="submit" value="Enviar"/>
    </form>
</body>

</html>