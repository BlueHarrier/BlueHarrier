<?php
if (!array_key_exists("type", $_REQUEST) || !array_key_exists("prompt", $_REQUEST)){
	header("Location: /");
	exit();
}

require_once("./lib/databases.php");
$type = $_REQUEST["type"];
$prompt = "%".$_REQUEST["prompt"]."%";

switch($type){
	case 0:
		$query =
		"SELECT `idParque` AS id, `Nombre_Parque` AS nombre, `idFoto` AS foto
		FROM `Parque`
		WHERE Nombre_Parque LIKE ?;";
		break;

	case 1:
		$query =
		"SELECT `idAtraccion` AS id, `Nombre` AS nombre, `idFoto` AS foto
		FROM `Atraccion`
		WHERE Nombre LIKE ?;";
		break;

	default:
		header("Location: /");
		exit();
}

$conn = create_connection();
$statement = $conn->prepare($query);
$statement->bind_param("s", $prompt);
$statement->execute();
$result = $statement->get_result();
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TParkDB</title>
    <link rel="stylesheet" href="css/stylesearcher.css">
    <link rel="icon" type="image/jpg" href="images/favicon_sin_fondo.png"/>
</head>
<body>
    <header>
        <div id="primerdiv">
            <a href="index.html"><img id="logo" src="images/Logo.png"></a>
            <a href="register.html" class="enlacescabecera">Register</a>
            <a href="login.html" class="enlacescabecera">Login</a>
        </div>
    </header>
    <section id="seccion-formulario">
        <form method="post" id="formulario">
            <select name="type">
                <option value="0">Parque</option>
                <option value="1">Atracción</option>
            </select>
            <input type="search" name="prompt">
            <input type="submit" value="Enviar">
        </form>
    </section>
    <section>
		<table>
			<?php
			while ($row = $result->fetch_assoc()){
				$id = $row["id"];
				$pic = $row["foto"];
				$name = $row["nombre"];
				$link = "/search_result.php/?type=$type&id=$id";
				$pic_link = "/images/db/$pic.png";

				echo "
				<tr>
					<td id='image'><img src=\"$pic_link\"/></td>
					<td id='text'><a href=\"$link\">$name</a></td>
				</tr>";
			}
			?>
		</table>
    </section>
    <footer>
        &#169; Diego José Guerra Garduño, Daniel Píriz Cacho, José Correa Fadis
    </footer>
</body>
</html>