<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Par o impar</title>
</head>

<body>
    <section>
        El número es 
        <?php
        function es_par($input){
            return ($input % 2 == 0);
        }
        $num = (int)$_POST["input"];
        if (es_par($num)) echo "par.";
        else echo "impar.";
        ?>
    </section>
</body>

</html>