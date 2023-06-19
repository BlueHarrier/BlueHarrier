<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dados</title>
</head>

<body>
    <?php
    $dado = rand(0, 5);
    $img = "";
    if ($dado == 0){
        $img = "dado1.png";
    }elseif ($dado == 1){
        $img = "dado2.png";
    }elseif ($dado == 2){
        $img = "dado3.png";
    }elseif ($dado == 3){
        $img = "dado4.png";
    }elseif ($dado == 4){
        $img = "dado5.png";
    }else{
        $img = "dado6.png";
    }

    echo ("<img src=./img/".$img."/>")
    ?>
</body>

</html>