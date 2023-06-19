<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Juego del gato</title>
    <style>
        h1{
            text-align: center;
        }
        h2{
            text-align: center;
            margin-top:0px;
        }
        table{
            width:100%;
        }
        table td{
            border-style: double;
            border-radius: 10px;
            padding:5px;
        }
    </style>
</head>

<body>
    <h1>Partida</h1>
    <table>
        <tbody>
            <tr>
                <?php
                // Toma el número de gatos
                $cats = $_REQUEST["players"];

                // Suma dos dados de seis caras
                function roll(){
                    return rand(1, 6) + rand(1, 6);
                }

                function generate_game(){
                    // Primera tirada del juego
                    $first_roll = roll();
                    echo "<p>Ha salido un <b>{$first_roll}</b>: ";
                    if ($first_roll == 7 || $first_roll == 11){
                        echo "¡has ganado a la primera!</p>";
                        return 7;
                    }
                    if ($first_roll == 2 || $first_roll == 3 || $first_roll == 12){
                        echo "¡has perdido y no has hecho más que empezar!</p>";
                        return -1;
                    }
                    echo "la partida continúa, tienes <b>6 vidas</b>.";
                    echo "</p>";

                    // Por cada tirada adicional
                    for ($lifes = 5; $lifes >= 0; $lifes--){
                        $roll = roll();
                        echo "<p>Ha salido un <b>{$roll}</b>: ";
                        if ($roll == 7){
                            echo "¡has metido la pata y has perdido!</p>";
                            return -1;
                        }
                        if ($lifes == 0){
                            echo "¡no te quedan vidas, has perdido!</p>";
                            return -1;
                        }
                        if ($roll == $first_roll){
                            $lifes++;
                            echo "¡hurra, has vivido para contarlo con <b>{$lifes} vidas</b>!</p>";
                            return $lifes + 1;
                        }
                        echo "la partida continúa, tienes <b>{$lifes} vidas</b>.</p>";
                    }
                }

                // Genera una tabla con los juegos completos
                function create_player_td($name, &$score){
                    echo "<td>";
                    echo "<h2>{$name}</h2>";
                    $score = generate_game();
                    echo "</td>";
                }
                
                // Por cada gato, se guarda su nombre y su puntuación, -1 si ha perdido
                for ($i = 1; $i <= $cats; $i++){
                    $cat_name = $_REQUEST["name{$i}"];
                    $scores[$cat_name] = -1;
                    create_player_td($cat_name, $scores[$cat_name]);
                }
                ?>
            </tr>
        </tbody>
    </table>
    
    <?php
    // Se toma la puntuación más elevada
    $highest = 0;
    foreach ($scores as $score){
        if ($score > $highest){
            $highest = $score;
        }
    }

    // Se obtienen quién o quiénes son los ganadores
    $names = array_keys($scores);
    $number_of_winners = 0;
    for ($i = 0; $i < $cats; $i++){
        if ($scores[$names[$i]] >= $highest){
            $winners[$number_of_winners] = $names[$i];
            $number_of_winners++;
        }
    }

    // Si no hay ganadores
    if ($number_of_winners == 0){
        echo "<h2>¡Increíble, nadie ha ganado!</h2>";
        return;
    }

    // Si hay un solo ganador
    if ($number_of_winners == 1){
        echo "<h2>¡Ha ganado {$winners[0]} con {$highest} vidas!</h2>";
        return;
    }

    // Si hay un empate, además se muestran quiénes son
    echo "<h2>¡Parece que tenemos un empate en {$highest} vidas!</h2>";
    echo "<p style=\"text-align: center;\">¡";
    for ($i = 0; $i < $number_of_winners; $i++){
        echo "{$winners[$i]}";
        if ($i ==  $number_of_winners - 2) echo " y ";
        elseif ($i != $number_of_winners - 1) echo ", ";
    }
    echo "!</p>";
    ?>

</body>

</html>