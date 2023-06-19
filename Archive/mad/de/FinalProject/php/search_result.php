<?php
if (!array_key_exists("type", $_REQUEST) || !array_key_exists("id", $_REQUEST)){
	header("Location: /");
	exit;
}

require_once("./lib/classes.php");
$type = $_REQUEST["type"];
$id = $_REQUEST["id"];

switch ($type){
	case 0:
		$item = new Parque($id);
		break;
	
	case 1:
		$item = new Atraccion($id);
		break;
	
	default:
		header("Location: /");
		exit;
}
?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Resultados</title>
    <link rel="stylesheet" href="/css/stylesearch.css">
    <link rel="icon" type="image/jpg" href="/images/favicon_sin_fondo.png"/>
</head>

<body>
    <header>
        <div id="primerdiv">
            <a href="index.html"><img id="logo" src="/images/Logo.png"></a>
            
            <h1><?php if ($item->exists) echo $item->nombre; ?></h1>
            
            <div id="enlaces">
                <a href="/register.html">Register</a>
                <a href="/login.html">Login</a>
            </div>
        </div>

    </header>
    <section>
        <?php $item->generar_pagina(); ?>
      </section>
    <footer>
        &#169; Diego José Guerra Garduño, Daniel Píriz Cacho, José Correa Fadis
    </footer>
</body>

</html>