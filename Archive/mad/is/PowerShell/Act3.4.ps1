#Dados dos arrays no ordenados y sin repeticiones, hacer merge
$array1 = @(4, 2, 1, 5, 6);
$array2 = @(3, 4, 2, 1, 7);
$totalArray = $array1 + $array2;


$finalList = [System.Collections.ArrayList]::new();

foreach ($i in $totalArray){
	if (-not $finalList.Contains($i)){
		$finalList.Add($i);
	}
}

$finalList.Sort();

echo $finalList;