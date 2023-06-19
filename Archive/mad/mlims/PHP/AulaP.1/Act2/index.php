<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <h1>Ejercicio 1</h1>
    <?php
    // Definir variables y constantes (transformadas a metros)
    define ("PINTURA", 8);
    $largo = 3.33;
    $alto = 2;
    $ancho = 1.8;

    // Comentario
    echo "<i>(Todos los valores se han pasado a metros)</i><br>";

    // Cálculo y resultado
    $area = 2 * ($largo * $alto + $ancho * $alto);
    $precio = $area * PINTURA;
    echo "La pintura necesaria es de ".$area."m2, y su valor será ".$precio."€.";
    ?>
    <h1>Ejercicio 2</h1>
    <?php
    // Definir variables y constantes
    define ("PI", 3.14159265359);
    define ("METAL", 150);
    define ("ALTURA", 0.08);
    define ("RADIO", 0.02);
    define ("CAPITAL_INICIAL", 120000);
    $capital = CAPITAL_INICIAL;
    define ("MANO_DE_OBRA", 20500);
    define ("DISTRIBUCION", 15000);
    define ("PUBLICIDAD", 1200);

    // Restar los gastos básicos al capital
    $capital -= MANO_DE_OBRA + DISTRIBUCION + PUBLICIDAD;

    // Calcular valor de cada bote
    $area_bote = 2 * PI * RADIO * ALTURA;
    $precio_bote = $area_bote * METAL;

    // Calcular cuántos botes podemos fabricar
    $botes = floor($capital / $precio_bote);
    echo "
    <ol>
        <li>Podremos fabricar un  total de ".$botes." botes.</li>";
    
    // Calcular el beneficio de la venta
    define ("PRECIO", 12);
    $recaudacion = $botes * PRECIO;
    $beneficio = $recaudacion - CAPITAL_INICIAL;
    echo "
        <li>Se ha obtenido un beneficio de ".$beneficio."€.</li>
    </ol>";
    ?>
</body>

</html>