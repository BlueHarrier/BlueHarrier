<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Población</title>
</head>
<style>
    body{
        background-color: lightseagreen;
    }
    header{
        padding: 3em;
        border-color: grey;
        border-style: solid;
    }
    *{
        text-align: center;
    }
    table, td{
        margin-left: auto;
        margin-right: auto;
        border-collapse: separate;
        border: 1px double;
        border-color: grey;
    }
    tr :first-child{
        font-weight: bold;
    }
    table{
        padding:1mm
    }
</style>
<body>
    <header>
        <h1>Evolución población mundial</h1>
    </header>
    <section>
        <table>
            <tr>
                <td>Periodo</td>
                <td>Población</td>
                <td>% aumento</td>
            </tr>
            <?php
            $population = [
                [1970, 3692492000],
                [1975, 4068109000],
                [1980, 4434682000],
                [1985, 4830978000],
                [1990, 5263593000],
                [1995, 5674328000],
                [2000, 6070581000],
                [2005, 6453628000],
                [2008, 6709132760],
                [2010, 6854196000],
                [2011, 7000000000]
            ];
            
            $size = count($population);
            $sum = 0;

            for ($i = 1; $i < $size; $i++){
                echo "<tr><td>".$population[$i][0]."</td><td>".$population[$i][1]."</td>";
                $p = 0;
                if ($i > 0){
                    $p = 1.0 - ($population[$i-1][1] / $population[$i][1]);
                    $p = round($p * 1000) / 10;
                }
                echo "<td>".$p."%</td></tr>";
                $sum += $p;
            }

            ?>
        </table>
    </section>
</body>
</html>