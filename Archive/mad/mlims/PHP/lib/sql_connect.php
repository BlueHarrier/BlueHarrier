<?php
function database_connect($db){
    $host = "127.0.0.1";
    $usr = "root";
    $pass = "";
    $conn = mysqli_connect($host, $usr, $pass, $db) or die("Error de conexión");
    return $conn;
}

function generate_table($query){
    $count = mysqli_num_rows($query);

    for ($i = 0; $i < $count; $i++){
        $results = mysqli_fetch_assoc($query);
        echo "<tr>";
        foreach ($results as $result){
            echo "<td>$result</td>";
        }
        echo "</tr>";
    }
}
?>