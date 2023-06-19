<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listado de prácticas de arrays</title>
</head>
<body>
    <h2>Ejercicio 1</h2>
    <?php
    $nums = [2, 4, 6, 8, 10, 12, 14, 16, 18, 20];
    foreach ($nums as $n){
        echo $n."<br/>";
    }
    ?>

    <h2>Ejercicio 2</h2>
    <?php
    $v[1]=90;
    $v[30]=7;
    $v['e']=99;
    $v['hola']=43;
    foreach ($v as $val){
        echo $val."<br/>";
    }
    ?>

    <h2>Ejercicio 3</h2>
    <?php
    $views = [9, 12, 0, 17];
    foreach ($views as $view){
        if ($view != 0) echo $view."<br/>";
    }
    ?>

    <h2>Ejercicio 4</h2>
    <?php
    $array = ["Pedro", "Ana", 34, 1];
    print_r($array);
    ?>

    <h2>Ejercicio 5</h2>
    <?php
    $data['Nombre'] = "Pedro Torres";
    $data['Dirección'] = "C/Mayor, 37";
    $data['Teléfono'] = "123456789";
    print_r($data);
    ?>

    <h2>Ejercicio 6</h2>
    <?php
    $cities = ["Madrid", "Barcelona", "Londres", "New York", "Los Angeles", "Chicago"];
    for ($i = 0; $i < sizeof($cities); $i++){
        echo "La ciudad con índicie ".$i." es ".$cities[$i]."<br/>";
    }
    ?>

    <h2>Ejercicio 7</h2>
    <?php
    $cities = [
        "MD" => "Madrid",
        "BC" => "Barcelona",
        "LD" => "Londres",
        "NY" => "New York",
        "LA" => "Los Angeles",
        "CH" => "Chicago"];
    $keys = array_keys($cities);
    foreach ($keys as $key){
        echo "El índice de la array que contiene ".$cities[$key]." es ".$key."<br/>";
    }
    ?>

    <h2>Ejercicio 8</h2>
    <?php
    $names = ["Pedro",  "Ismael", "Sonia", "Clara", "Susana", "Alfonso", "Teresa"];
    echo sizeof($names)."<br/>";
    echo "<ul>";
    foreach ($names as $name){
        echo "<li>".$name."</li>";
    }
    echo "</ul>";
    ?>

    <h2>Ejercicio 9</h2>
    <?php
    $lenguajes_cliente = ["JavaScript", "Flash", "Web Assembly", "WebGL"];
    $lenguajes_servidor = ["PHP", "Java", "C++"];
    $lenguajes = array_merge($lenguajes_cliente, $lenguajes_servidor);
    print_r($lenguajes);
    ?>

    <h2>Ejercicio 10</h2>
    <?php
    $nums = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
    $avg = 0;
    foreach ($nums as $num){
        if ($num % 2 == 0){
            $avg += $num;
        }
        else{
            echo $num."<br/>";
        }
    }
    echo "Media: ".($avg / 5)."<br/>";
    ?>

    <h2>Ejercicio 11</h2>
    <?php
    $array1 = ["Lagartija", "Araña", "Perro", "Gato", "Ratón"];
    $array2 = ["12", "34", "45", "52", "12"];
    $array3 = ["Sauce", "Pino", "Naranjo", "Chopo", "Perro", "34"];
    $new_array = array_merge($array1, $array2, $array3);
    print_r($new_array);
    ?>

    <h2>Ejercicio 12</h2>
    <?php
    $new_array = $array1;
    foreach ($array2 as $value){
        array_push($new_array, $value);
    }
    foreach ($array3 as $value){
        array_push($new_array, $value);
    }
    print_r($new_array);
    ?>

    <h2>Ejercicio 13</h2>
    <?php
    print_r(array_reverse($new_array));
    ?>

    <h2>Ejercicio 14</h2>
    <?php
    $estadios_futbol = array("Barcelona" => "Camp Nou", "Real Madrid" => "Santiago Bernabeu", "Valencia" => "Mestalla", "Real Sociedad" => "Anoeta");
    echo "<table border = 1>
            <tr>
                <td><b>Índice</b></td>
                <td><b>Valor</b></td>
            </tr>";
    $keys = array_keys($estadios_futbol);
    foreach ($keys as $key){
        echo "<tr>";
        echo "<td>".$key."</td>";
        echo "<td>".$estadios_futbol[$key]."</td>";
        echo "</tr>";
    }
    echo "</table>";
    ?>

    <h2>Ejercicio 15</h2>
    <?php
    $numeros = array(3, 2, 8, 123, 5, 1);
    sort($numeros);
    echo "<table border = 1>
            <tr>
                <td><b>Índice</b></td>
                <td><b>Valor</b></td>
            </tr>";
    $keys = array_keys($numeros);
    foreach ($keys as $key){
        echo "<tr>";
        echo "<td>".$key."</td>";
        echo "<td>".$numeros[$key]."</td>";
        echo "</tr>";
    }
    echo "</table>";
    ?>

    <h2>Ejercicio 16</h2>
    <?php
    $array = [5 => 1, 12 => 2, 13 => 56, "x" => 42];
    echo sizeof($array)."<br/>";
    unset($array[5]);
    $array = array_values($array);
    echo print_r($array)."<br/>";
    ?>

    <h2>Ejercicio 17</h2>
    <?php
    $families = ["Los Simpson" => 
        [
        "padre" => "Homer", 
        "madre" => "Marge",
        "hijos" => ["Bart", "Lisa", "Maggie"]],
    "Los Griffin" => [
        "padre" => "Peter",
        "madre" => "Lois",
        "hijos" => ["Chris", "Meg", "Stewie"]
    ]];
    echo "<ul>";
    foreach ($families as $family){
        foreach ($family as $member){
            if (is_array($member)){
                echo "<li>Hijos:</li><ul>";
                foreach ($member as $son){
                    echo "<li>".$son."</li>";
                }
                echo "</ul>";
            }
            else{
                echo "<li>".$member."</li>";
            }
        }
    }
    echo "</ul>";
    ?>

    <h2>Ejercicio 18</h2>
    <?php
    $sports = ["Fútbol", "Baloncesto", "Natación", "Ténis"];
    for ($i = 0; $i < count($sports); $i++){
        echo $sports[$i];
        if ($i < count($sports) - 1) echo ", ";
        else echo "<br/>";
    }
    $i = 0;
    echo $sports[$i]."<br/>";
    $i++;
    echo $sports[$i]."<br/>";
    $i = count($sports) - 1;
    echo $sports[$i]."<br/>";
    $i--;
    echo $sports[$i]."<br/>";
    ?>

    <h2>Ejercicio 19</h2>
    <?php
    $friends = [
        "Madrid" => ["nombre" => "Pedro", "edad" => 32, "telefono" => "91-999.99.99"],
        "Barcelona" => ["nombre" => "Susana", "edad" => 34, "telefono" => "93-000.00.00"],
        "Toledo" => ["nombre" => "Sonia", "edad" => 42, "telefono" => "925-09.09.09"]
    ];
    $keys = array_keys($friends);
    foreach ($keys as $key){
        $friend = $friends[$key];
        echo "En ".$key." se encuentra ".$friend["nombre"].". Tiene ".$friend["edad"]." años y su teléfono es ".$friend["telefono"].".<br/>";
    }
    ?>
</body>
</html>