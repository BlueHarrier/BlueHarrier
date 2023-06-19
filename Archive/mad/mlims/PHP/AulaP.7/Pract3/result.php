<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Doble</title>
</head>

<body>
    <section>
        El doble es 
        <?php
        function doble($input){
            return $input * 2;
        }
        $num = (int)$_POST["input"];
        echo doble($num).".";
        ?>
    </section>
</body>

</html>