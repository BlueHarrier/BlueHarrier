
function Show-HeaviestFileRecurse ($path){
	$files = Get-ChildItem $path -File;
	$oldest = -1;
	foreach ($file in $files){
		if ($oldest -ne -1){
			if ($oldest.creation -lt $heaviest_file.creation){
					$oldest = $file;
			}
		}
		else{
			$oldest = $file;
		}
	}
	if ($oldest -ne -1){
		Write-Host ($oldest, " pesa ", ($oldest.length/1MB), "MB");
	}
	$directories = Get-ChildItem $path -Dir;
	foreach ($directory in $directories){
		Show-HeaviestFileRecurse $directory;
	}
}

$root = "C:\users\";

Show-HeaviestFileRecurse $root;
