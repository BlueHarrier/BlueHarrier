<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tabla periódica</title>
</head>
<style>
    body{
        background-color: blue;
    }
    header{
        padding: 3em;
        border-color: grey;
        border-style: solid;
    }
    *{
        text-align: center;
        color: white;
    }
    input, select, option{
        color: black;
    }
</style>
<body>
    <header>
        <h1>
            Tabla Periódica de los Elementos
        </h1>
    </header>
    <section>
        <form action="result.php" method="post">
            <label for="group">Seleccione grupo que desea consultar: </label>
            <select name="group">
                <option value="0" selected>Gases nobles</option>
                <option value="1">Halógenos</option>
                <option value="2">No metales</option>
                <option value="3">Metaloides</option>
                <option value="4">Otros metales</option>
                <option value="5">Metales de transición</option>
                <option value="6">Alcalinoférreos</option>
                <option value="7">Metales alcalinos</option>
                <option value="8">Lantánidos</option>
                <option value="9">Actínidos</option>
            </select>
            <input type="submit" value="Buscar"/>
        </form>
    </section>
</body>
</html>