<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Notas</title>
</head>

<body>
    <?php
    $nota = rand(0, 10);
    if ($nota >= 9 && $nota <= 10){
        echo "Sobresaliente";
    }
    elseif ($nota >= 7){
        echo "Notable";
    }
    elseif ($nota >= 6){
        echo "Bien";
    }
    elseif ($nota >= 5){
        echo "Suficiente";
    }
    else{
        echo "Insuficiente";
    }
    echo " (".$nota.")."
    ?>
</body>

</html>