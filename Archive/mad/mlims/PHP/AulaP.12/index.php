<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Juego de los gatos</title>
    <style>
        h1{
            text-align: center;
        }
    </style>
</head>

<body>
    <h1>El juego de los gatos</h1>
    <form action="./player_settings.php" method="post">
        <fieldset>
            <legend>Número de gatos</legend>
            <input type="number" name="players" required/><br/>
            <input type="submit" value="Comenzar"/>
        </fieldset>
    </form>
</body>

</html>