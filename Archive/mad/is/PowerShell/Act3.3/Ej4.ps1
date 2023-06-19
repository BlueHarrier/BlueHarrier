$array = 14, 25, 80, 33, 7, 28, 56, 70, 91, 88;
$par = @();
$impar = @();

foreach ($i in $array){
	if ($i % 2 -eq 0){
		$par += $i
	}
	else{
		$impar += $i
	}
}
echo "Pares:" $par;
echo "Impares:" $impar;