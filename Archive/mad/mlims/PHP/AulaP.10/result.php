<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulario</title>
</head>

<style>
p{
    font-size:1.5rem;
}
</style>

<body>
    <p>
        <?php
        $name = $_REQUEST["name"];
        $age = $_REQUEST["age"];
        $state = $_REQUEST["civil_state"];
        $career = $_REQUEST["career"];

        echo "Son nombre es ".$name.".<br/>";
        echo "Tiene ".$age." años.<br/>";
        echo "Su estado civil es: ";
        switch ($state){
            case 0:
                echo "CASADO";
                break;
            
            case 1:
                echo "SEPARADO";
                break;
            
            case 2:
                echo "DIVORCIADO";
                break;

            case 3:
                echo "VIUDO";
                break;

            default:
                echo "NO ESPECIFICADO";
                break;
        }
        echo "<br/>";
        if ($career[0] == 1) echo "Ha trabajado por cuenta propia<br/>";
        if ($career[1] == 1) echo "Ha trabajado por cuenta ajena<br/>";
        echo "<br/>Su jubilación se espera dentro de ".(68 - $age);
        ?>
    </p>
</body>

</html>