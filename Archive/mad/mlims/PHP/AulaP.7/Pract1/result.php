<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Texto en negrita</title>
</head>

<body>
    <section>
        Se ha escrito el siguiente texto: 
        <?php
        function negrita($input){
            return "<b>".$input."</b>";
        }
        echo negrita($_POST["input"]);
        ?>
    </section>
</body>

</html>