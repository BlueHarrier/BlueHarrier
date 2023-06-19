<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Días de la semana</title>
</head>

<body>
    <?php
    $dia = rand(0, 6);
    switch ($dia){
        case 0:
            echo "Lunes";
            break;

        case 1:
            echo "Martes";
            break;
        
        case 2:
            echo "Miércoles";
            break;

        case 3:
            echo "Jueves";
            break;

        case 4:
            echo "Viernes";
            break;

        case 5:
            echo "Sábado";
            break;

        case 6:
            echo "Domingo";
            break;
    }
    ?>
</body>

</html>