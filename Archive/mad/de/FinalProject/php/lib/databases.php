<?php
function create_connection(){
	$host = "db";
	$usr = "root";
	$pass = "root";
	$db = "tparkdb";
	$conn = mysqli_connect($host, $usr, $pass, $db) or die("Error");
	return $conn;
}
?>