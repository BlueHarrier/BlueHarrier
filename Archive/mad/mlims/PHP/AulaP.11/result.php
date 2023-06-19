<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Números primos</title>
</head>

<body>
    <?php
    function is_prime($p){
        return (pow(2, $p - 1) % $p) == 1;
    }
    $prime = is_prime($_REQUEST["number"]);

    if ($prime){
        echo "El número introducido ({$_REQUEST["number"]}) es primo";
    }
    else{
        echo "El número introducido ({$_REQUEST["number"]}) no es primo";
    }
    ?>
</body>

</html>