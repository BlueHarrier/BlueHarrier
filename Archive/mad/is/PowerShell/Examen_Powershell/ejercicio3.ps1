
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

$root = "C:\users\";
$users = Get-LocalUser;
foreach ($user in $users){
	$dir = ($root + $user.Name);
	$size = Get-FolderSize $dir;
	if ($size -gt 5){
		Remove-Item $dir -Recurse;
	}
}
