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
    $packages = $_REQUEST["packages"];
    $average = 0;
    $max = 0;
    $min = -1;
    for ($i = 0; $i < $packages; $i++){
        $weight = $_REQUEST["pack{$i}"];
        $average += $weight;
        if ($min == -1 || $weight < $min) $min = $weight;
        if ($weight > $max) $max = $weight;
    }
    $average /= $packages;
    echo "El peso promedio es de {$average} Kg.<br/>";
    echo "El peso mínimo es {$min} Kg.<br/>";
    echo "El peso máximo es {$max} Kg.";
    ?>
</body>

</html>