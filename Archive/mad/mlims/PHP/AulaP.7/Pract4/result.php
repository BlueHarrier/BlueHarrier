<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Número primo</title>
</head>

<body>
    <section>
        El número 
        <?php
        function es_primo($input){
            $n = abs($input);
            if ($n < 2) return true;
            for ($i = 2; $i < ($n - 1); $i++){
                if ($n % $i == 0) return false;
            }
            return true;
        }
        $num = (int)$_POST["input"];
        if (es_primo($num)) echo "es";
        else echo "no es";
        ?>
        primo.
    </section>
</body>

</html>