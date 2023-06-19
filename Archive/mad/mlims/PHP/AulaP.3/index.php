<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicios PHP</title>
</head>

<body>
    <h1>Ejercicio 1</h1>
    <p>
        <?php
        $litros_x_pintura = 0.1;
        $alto_pared = 4;
        $ancho_pared = 10;
        $precio_lata = 42;
        $total = (($alto_pared * $ancho_pared) * $litros_x_pintura) * $precio_lata;
        echo "El pintor deberá gastar ".$total."€ para pintar la pared.";
        ?>
    </p>
    <h1>Ejercicio 2</h1>
    <p>
        <?php
        $jeans = 6;
        $jeans_total = 240 * $jeans;
        $chaqueta_r = 8;
        $chaqueta_r_total = 70 * $chaqueta_r;
        $chaqueta_a = 4;
        $chaqueta_a_total = 90 * $chaqueta_a;
        $jersey = 6;
        $jersey_total = 160 * $jersey;
        $medias = 9;
        $medias_total = 40 * $medias;

        $subtotal = $jeans_total + $chaqueta_r_total + $chaqueta_a_total + $jersey_total + $medias_total;
        echo "El total ganado en el día es: ".$subtotal.".<br>";

        $prendas = $jeans + $chaqueta_r + $chaqueta_a + $jersey + $medias;
        echo "El promedio por prenda es de ".($subtotal / $prendas).".";
        ?>
    </p>
</body>

</html>