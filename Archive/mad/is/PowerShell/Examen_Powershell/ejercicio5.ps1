
# No tengo anotadas y no recuerdos las funciones de lectura de archivo - consideramos cada línea cada índice de array

$banned_users = @{};

foreach ($user_name in $banned_users){
	$user = Get-LocalUser -Name $user_name;
	if ($user.Enabled){
		Disable-LocalUser $user;
	}
	elseif ($user.name -ne ""){
		Remove-LocalUser $user;
	}
	else{
		Remove-Item ("C:\users\" + $user_name);
	}
}