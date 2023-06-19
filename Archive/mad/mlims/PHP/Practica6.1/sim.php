<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MONEY SERVICES</title>  
    <style>
        *{
            color:darkcyan;
            font-family: 'Times New Roman', Times, serif;
        }
        header h1{
            font-family: impact;
            text-align: center;
        }
        form fieldset legend{
            text-align: center;
            font-size:large;
            font-weight: bold;
        }
        form fieldset{
            text-align:center;
        }
        table{
            margin:auto;
            margin-top:50px;
        }
        table thead{
            text-align: center;
            font-weight: bold;
        }
    </style>
    <?php require_once('../lib/sql_connect.php'); ?>
</head>

<body>
    <header>
        <h1>Simulador de inversiones de intereses compuestos</h1>
    </header>
    <form action="sim.php" method="post">
        <fieldset>
            <legend>Datos del cliente</legend>
            <label for="name">Nombre y apellidos: </label>
            <input type="text" name="name"  size="40" maxlength="60" require/>
            <label for="id">DNI/CIF/NIF: </label>
            <input type="text" name="id" maxlength="9" minlength="9" require/>
            <label for="birth">Fehca de nacimiento: </label>
            <input type="date" name="birth" require/>
        </fieldset>
        <fieldset>
            <legend>Datos de la operación</legend>
            <label for="initial">Capital inicial: </label>
            <input type="number" name="initial" require/>
            <label for="year">Aportación anual: </label>
            <input type="number" name="year" require/>
            <label for="tax">Tipo de interés: </label>
            <select name="tax" require>
                <option name="7">7%</option>
                <option name="9">9%</option>
                <option name="15">15%</option>
            </select>
            <label for="span">Número de años: </label>
            <input type="number" name="span" require/>
        </fieldset>
        <fieldset>
            <legend>Simulación</legend>
            <lable for="submit">Iniciar simulación </lable>
            <input type="submit" name="submit" value="Enviar"s/>
            <lable for="clear">Restablecer campos </lable>
            <input type="reset" name="clear" value="Restablecer"/>
        </fieldset>
    </form>

    <table border>
        <?php
        if (empty($_REQUEST)){
            exit('');
        }

        $name = $_REQUEST["name"];
        $id = $_REQUEST["id"];
        $birth = $_REQUEST["birth"];
        $years = $_REQUEST["span"];
        $tax = intval($_REQUEST["tax"], 10) * 0.01;
        $initial_add = $_REQUEST["initial"];
        $year_add = $_REQUEST["year"];

        echo 
        '<thead>
            <tr>
                <td>Año</td>
                <td>Capital obtenido</td>
                <td>Capital inicial</td>
            </tr>
        </thead>';

        echo '<tbody>';

        function add_value($year, $initial_value, $tax){
            echo "<tr>";
            echo "<td>$year</td>";
            $final_value = $initial_value * (1 - $tax);
            echo "<td>$final_value €</td>";
            echo "<td>$initial_value €</td>";
            echo "</tr>";
            return $final_value;
        }

        $value = $initial_add;
        for ($i = 0; $i < $years; $i++){
            $value = add_value($i + 1, $value + $year_add, $tax);
        }

        echo '</tbody>';
        ?>
    </table>
</body>

</html>