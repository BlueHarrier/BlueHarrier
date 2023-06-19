<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tabla periódica</title>
</head>
<style>
    body {
        background-color: blue;
    }

    header {
        padding: 3em;
        border-color: grey;
        border-style: solid;
    }

    * {
        text-align: center;
        color: white;
    }

    table,
    td {
        margin-left: auto;
        margin-right: auto;
        border-collapse: separate;
        border: 1px double;
        border-color: white;
    }

    tr :first-child {
        font-weight: bold;
    }

    table {
        padding: 1mm
    }
</style>

<body>
    <header>
        <h1>
            Tabla Periódica de los Elementos
        </h1>
    </header>
    <section>
        <?php
        $table = [
            "Hidrógeno","Helio","litio","Berilio","Boro","Carbono","Nitrógeno","Oxígeno","Flúor","Neón","Sodio",
            "Magnesio","Aluminio","Silicio","Fósforo","Azufre","Cloro","Argón","Potasio","Calcio","Escandio",
            "Titanio","Varadio","Cromo","Manganeso","Hierro","Cobalto","Níquel","Cobre","Cinc","Galio","Germanio",
            "Arsenio","Selenio","Bromo","Kriptón","Rubidio","Estroncio","Itrio","Circonio","Niobio","Molibdeno",
            "Tecnecio","Rutenio","Rodio","Paladio","Plata","Cadmio","Indio","Estaño","Antimonio","Telurio","Yodo",
            "Xenón","Cesio","Bario","Lantano","Cerio","Praseodimio","Prometio","Samario","Europio","Gadolinio",
            "Terbio","Disprosio","Holmio","Erbio","Tulio","Iterbio","Lutecio","Hafnio","Tantalo","Wolframio",
            "Renio","Osmio","Iridio","Platino","Oro","Mercurio","Talio","Plomo","Bismuto","Polonio","Astato",
            "Radón","Actinio","Torio","Protactinio","Uranio","Neptunio","Plutonio","Americio","Curio","Berkelio",
            "Californio","Einstenio","Fermio","Mendelevio","Nobelio","Laurencio","Rutherfordio","Dubnio","Seabergio",
            "Bohrio","Hassio","Meitnerio","Darmstadio","Roentgenio","Copernicio"
        ];
        $groups = [
            
        ];
        echo "<table>";
        echo $_POST['group'];
        echo "</table>";
        ?>
    </section>
</body>

</html>
<?php
echo $_POST['group'];
?>