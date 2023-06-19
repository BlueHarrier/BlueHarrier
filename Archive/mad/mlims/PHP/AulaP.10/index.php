<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulario</title>
</head>

<style>
h1{
    font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
    text-align:center;
}

p{
    font-size:1.5rem;
}
</style>

<body>
    <h1>Datos para la estimación de la edad de jubilación</h1>
    <h2 class="intro">
        Rellene los <u style="text-decoration:underline; color:red;">siguientes datos</u>
    </h2>
    <p>
        <form action="result.php" method="post">
            <label for="name">Nombre y apellidos</label><br/>
            <input name="name" type="text" size="50" maxlength="50"/><br/>
            <label for="age">Edad</label><br/>
            <input name="age" type="number" size="3" maxlength="3"/><br/>
            <label for="civil_state">Estado civil</label><br/>
            <input name="civil_state" type="radio" value="0"/>Casado<br/>
            <input name="civil_state" type="radio" value="1"/>Separado<br/>
            <input name="civil_state" type="radio" value="2"/>Divorciado<br/>
            <input name="civil_state" type="radio" value="3"/>Viudo<br/>
            <label for="career">Vida laboral</label>
            <input name="career" type="checkbox" value="0"/>¿Has sido trabajador autónomo?<br/>
            <input name="career" type="checkbox" value="1"/>¿ha trabajado para alguna empresa?<br/>
            <input name="submit" type="submit" value="Enviar"/><br/>
            <input name="reset" type="reset" value="Restablecer"/><br/>
        </form>
    </p>
</body>

</html>