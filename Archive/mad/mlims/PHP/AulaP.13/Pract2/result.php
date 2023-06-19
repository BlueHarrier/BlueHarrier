<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <?php
        $number_a = $_REQUEST["number_a"];
        $number_b = $_REQUEST["number_b"];
        
        function DCM($a, $b){
            do{
                $mod = $a % $b;
                $a = $b;
                $b = $mod;
            } while($mod != 0);
            return $a;
        }

        $DCM = DCM($number_a, $number_b);
        echo "El MCD de los números es {$DCM}.";
    ?>
</body>

</html>