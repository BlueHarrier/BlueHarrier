<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tipos de datos</title>
</head>

<body>
    <?php
    // Inicializar definiciones
    define ("CON", "Esta es una constante");
    $var_a = "var_b";
    $$var_a = "Esta es la variable B";
    $var_c = 12;
    $var_d = &$var_c;

    // Comprobaciones
    echo "''CON'' es una constante, y siempre valdrá lo mismo. Su valor es ''".CON."''.<br>";
    echo "''var_a'' es una variable normal y corriente que vale ''".$var_a."'', y si defino la variable de la variable de var_a, obtengo la variable var_b, que vale ''".$var_b."''.<br>";
    echo "La variable ''var_c'' vale ".$var_c.", y su compañera ''var_d'' no solo vale también ".$var_d.", sino que valdrá siempre lo mismo que var_c, pues están vinculadas.";
    ?>
</body>

</html>