$users = Net User;
$files = {};

for ($i = 0; $i -lt $users.Length; $i++){
	$user = $users[$i];
	$files[$i] = "C:/users/" + $user.name;
}

echo $files;
