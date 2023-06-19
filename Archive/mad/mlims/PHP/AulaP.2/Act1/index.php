<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cara o cruz</title>
</head>

<body>

</body>
    <?php
    $val = rand(0, 1);
    if ($val == 0){
        echo "<img src=./img/cara.jpg>";
    }
    else{
        echo "<img src=./img/cruz.png>";
    }
    ?>
</html>