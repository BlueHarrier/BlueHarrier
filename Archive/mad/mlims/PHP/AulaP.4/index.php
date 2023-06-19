<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PHP 29-11-2022</title>
</head>
<body>
    <h2>Enunciado 1</h2>
    <?php
    $n = 2;
    switch ($n){
        case 0:
            echo "Blanco";
            break;
        case 1:
            echo "Azul";
            break;
        case 2:
            echo "Rojo";
            break;
        case 3:
            echo "Verde";
            break;
    }
    ?>

    <h2>Enunciado 2</h2>
    <?php
    define("RATIO", 166.386);
    $n = 100;
    echo $n * RATIO." pst.";
    ?>

    <h2>Enunciado 3</h2>
    <?php
    $n = 5;
    for ($i = 0; $i < $n; $i++){
        echo "Hola a todos<br/>";
    }
    ?>

    <h2>Enunciado 4</h2>
    <?php
    for ($i = 0; $i < 20; $i++){
        echo ($i + 1)."<br/>";
    }
    ?>

    <h2>Enunciado 5</h2>
    <?php
    $n = 14;
    for ($i = 0; $i < $n; $i++){
        echo ($i + 1)."<br/>";
    }
    ?>

    <h2>Enunciado 6</h2>
    <?php
    for ($i = 10; $i >= 0; $i--){
        echo $i."<br/>";
    }
    ?>

    <h2>Enunciado 7</h2>
    <?php
    $n = 16;
    for ($i = $n; $i > 0; $i--){
        echo $i."<br/>";
    }
    ?>

    <h2>Enunciado 8</h2>
    <?php
    $n = 0;
    echo "10 x 5 = ";
    for ($i = 0; $i < 5; $i++){
        $n += 10;
    }
    echo $n;
    ?>


    <h2>Enunciado 9</h2>
    <?php
    $n = 6;
    for ($i = 0; $i < $n; $i++){
        echo "*";
    }
    ?>

    <h2>Enunciado 10</h2>
    <?php
    $n = 347;
    echo $n;
    if ($n % 2 == 0) echo " es par";
    else echo " es impar";
    ?>

    <h2>Enunciado 11</h2>
    <?php
    $n = 8;
    $prnt;
    if ($n % 2 == 0) $prnt = "=";
    else $prnt = "*";
    for ($i = 0; $i < $n; $i++){
        echo $prnt;
    }
    ?>

    <h2>Enunciado 12</h2>
    <?php
    $n = 18;
    for ($i = 1; $i <= $n; $i++){
        if ($n % $i == 0) echo $i."<br/>";
    }
    ?>

    <h2>Enunciado 13</h2>
    <?php
    $n1 = 3;
    $n2 = 10;
    $r = 0;
    for ($i = $n1; $i <= $n2; $i++){
        $r += $i;
    }
    echo $r;
    ?>

    <h2>Enunciado 14</h2>
    <?php
    $n = rand(0, 1);
    if ($n == 1) echo "Cara";
    else echo "Cruz";
    ?>

    <h2>Enunciado 15</h2>
    <?php
    $n = [4, -6, -7, 9, 10];
    for ($i = 0; $i < 5; $i++){
        if ($n[$i] < 0) echo "Negativo";
        else echo "Positivo";
        echo "<br/>";
    }
    ?>
</body>
</html>