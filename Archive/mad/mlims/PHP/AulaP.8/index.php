<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formularios dinámicos</title>
</head>

<body>
    <form action="result.php" method="post">
        <label for="name">Nombre </label><input name="name" type="text"/>
        <label for="surname">Apellido </label><input name="surname" type="text"/>
        <label for="age">Edad </label><input name="age" type="number" size="2"/>
        <br/><br/>
        <input name="cmd" type="submit" value="Enviar"/>
        <input name="cmd" type="reset" value="Limpiar"/>
    </form>
</body>

</html>