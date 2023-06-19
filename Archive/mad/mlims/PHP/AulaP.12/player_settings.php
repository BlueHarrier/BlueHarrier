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
        input.submit{
            width:100%;
            margin-left: -8px;
            text-align: center;
            position:fixed;
        }
    </style>
</head>

<body>
    <h1>Nombra los gatos</h1>
    <?php $cats = $_REQUEST["players"]; // Buffer de jugadores para la siguiente parte?>
    <form action="./result.php" method="post">
        <?php echo "<input type=\"number\" value=\"{$cats}\" name=\"players\" style=\"display:none;\"/>"; ?>
        <table>
            <tbody>
                <tr>
                    <?php
                    // Genera una columna para introducir los nombres
                    function create_player_td($player){
                        echo "<td>";
                        echo "<h2>Gato {$player}</h2>";
                        echo "<label for=\"name{$player}\">Nombre: </label>";
                        echo "<input type=\"text\" name=\"name{$player}\" required/>";
                        echo "</td>";
                    }

                    // Genera una columna por cada gato
                    for ($i = 0; $i < $cats; $i++){
                        create_player_td($i + 1);
                    }
                    ?>
                </tr>
            </tbody>
        </table>
        <input class="submit" type="submit" value="¡A jugar!"/>
    </form>
</body>

</html>