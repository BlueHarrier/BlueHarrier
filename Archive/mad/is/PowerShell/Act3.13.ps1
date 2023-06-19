# Características del programa:
# 1. Gestor de archivos
#	1. Listar archivos de un directorio
#	2. Borrar archivo
#	3. Renombrar archivo
#	4. Mostrar tamaño de directorio
#	5. Cambiar propietario de archivo
#	6. Comprimir archivo + ruta opcional (.zip)
#	7. Volver
# 2. Gestor de archivos
#	1. Obtener directorios de una ruta
#	2. Borrar directorio
#	3. Renombrar directorio
#	4. Mostrar tamaño de directorio
#	5. Cambiar propietario de directorio
#	6. Comprimir un directorio + ruta opcional (.zip)
#	7. Volver
# 3. Salir

Clear-Host;

function menu_archivos{
	while ($true){
		Write-Host "Gestor de archivos";
		Write-Host "1. Listar archivo";
		Write-Host "2. Borrar archivo";
		Write-Host "3. Renombrar archivo";
		Write-Host "4. Comprobar tamaño de un archivo";
		Write-Host "5. Cambiar propiedad de archivo";
		Write-Host "6. Comprimir archivo";
		Write-Host "7. Volver";
		$ans = Read-Host;
		
		Clear-Host;

		if ($ans -lt 6){
			if ($ans -ne 1) {Write-Host "Inserte ruta del archivo";}
			else {Write-Host "Inserte directorio";}
			$directory = Read-Host;
		}

		switch ($ans){
			# Listado
			1{Get-ChildItem $directory -file;}
			
			# Borrar
			2{Remove-Item $directory -Recurse;}

			# Renombrar
			3{
				Write-Host "Inserte el nuevo nombre del archivo";
				$new_name = Read-Host;
				Rename-Item $directory -NewName $new_name;
			}

			# Tamaño
			4{Write-Host ((Get-Item $directory).length / 1MB) "MB";}

			# Cambiar propiedad
			5{
				$acl = Get-Acl -Path $directory;
				Write-Host "Inserte usuario al que se quiere dar permiso";
				$user = Read-Host;
				$acl.SetOwner([System.Security.Principal.NTAccount]$user);
				Set-Acl -Path $directory -AclObject $acl;
			}
			
			# Comprimir
			6{
				Write-Host "Inserte ruta del archivo comprimido (en blanco si no desea cambiar la carpeta)";
				$dest = Read-Host;
				if ($dest -eq ""){
					$dest = $directory + ".zip";
				}
				Compress-Archive -Path $directory -DestinationPath $dest;
			}

			# Volver
			7{return;}
			
			# Mostrar error
			default{Write-Host "Opción no válida";}
		}
		
		Write-Host "";
	}
}


function menu_directorios{
	while ($true){
		Write-Host "Gestor de directorio";
		Write-Host "1. Listar directorio";
		Write-Host "2. Borrar directorio";
		Write-Host "3. Renombrar directorio";
		Write-Host "4. Comprobar tamaño de un directorio";
		Write-Host "5. Cambiar propiedad de directorio";
		Write-Host "6. Comprimir directorio";
		Write-Host "7. Volver";
		$ans = Read-Host;
		
		Clear-Host;

		if ($ans -lt 6){
			Write-Host "Inserte directorio";
			$directory = Read-Host;
		}

		switch ($ans){
			# Listado
			1{Get-ChildItem $directory -directory;}
			
			# Borrar
			2{Remove-Item $directory -Recurse;}

			# Renombrar
			3{
				Write-Host "Inserte el nuevo nombre del directorio";
				$new_name = Read-Host;
				Rename-Item $directory -NewName $new_name;
			}

			# Tamaño
			4{Write-Host ((Get-Item $directory).length / 1MB) "MB";}

			# Cambiar propiedad
			5{
				$acl = Get-Acl -Path $directory;
				Write-Host "Inserte usuario al que se quiere dar permiso";
				$user = Read-Host;
				$acl.SetOwner([System.Security.Principal.NTAccount]$user);
				Set-Acl -Path $directory -AclObject $acl;
			}
			
			# Comprimir
			6{
				Write-Host "Inserte ruta del archivo comprimido (en blanco si no desea cambiar la carpeta)";
				$dest = Read-Host;
				if ($dest -eq ""){
					$dest = $directory + ".zip";
				}
				Compress-Archive -Path $directory -DestinationPath $dest;
			}

			# Volver
			7{return;}
			
			# Mostrar error
			default{Write-Host "Opción no válida";}
		}
		
		Write-Host "";
	}
}

while ($true){
	Write-Host "¿Qué desea hacer?";
	Write-Host "1. Gestor de archivos";
	Write-Host "2. Gestor de directorios";
	Write-Host "3. Salir";
	$ans = Read-Host;
	
	Clear-Host;
	
	switch ($ans){
		# Mostrar servicios
		1{menu_archivos;}
		
		# Mostrar detalles de un servicio
		2{menu_directorios;}
		
		# Salir
		3{return;}
		
		# Mostrar error
		default{Write-Host "Opción no válida";}
	}
}