
function Get-FolderSize ($path){
	$files = Get-ChildItem $path -File;
	$size = 0
	foreach ($file in $files){
		$size += $file.length;
	}
	$directories = Get-ChildItem $path -Dir;
	foreach ($directory in $directories){
		$size += Get-FolderSize $directory;
	}
	return $size;
}

$size = (Get-FolderSize "C:\")/1GB;

# (Coger tamaño del disco)
$total_size = 50;

$difference = $total_size - $size;

if ($difference -le 1){
	&{[System.Reflection.Assembly]::LoadWithPartialName('System.Windwos.Forms');[System.Windows.Forms.MessageBox]::Show('Menos de 1GB disponible en el disco', 'WARNING')}
}