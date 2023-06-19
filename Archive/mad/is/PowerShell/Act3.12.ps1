# Características del programa:
# 1. Listar servicios del sistema
# 2. Listar detalles de un servicio (por nombre)
# 3. Gestor de servicios:
#	1. Crear servicio
#	2. Eliminar servicio
#	3. Iniciar servicio
#	4. Detner servicio
#	5. Pausar servicio
#	6. Reanudar servicio
#	7. Reiniciar servicio
#	8. Volver
# 4. Salir

Clear-Host;

function menu_servicios{
	while ($true){
		echo "Gestor de servicios";
		echo "1. Crear servicio";
		echo "2. Eliminar servicio";
		echo "3. Iniciar servicio";
		echo "4. Detener servicio";
		echo "5. Pausar servicio";
		echo "6. Reanudar servicio";
		echo "7. Reiniciar servicio";
		echo "8. Volver";
		$ans = Read-Host;
		
		Clear-Host;
		
		if ($ans -lt 8){
			echo "Inserte el nombre del servicio";
			$serv = Read-Host;
		}
		
		switch ($ans){
			# Nuevo servicio
			1{New-Service -Name $serv;}
			
			# Eliminar servicio
			2{Remove-Service -Name $serv;}
			
			# Iniciar servicio
			3{Start-Service -Name $serv;}
			
			# Detener servicio
			4{Stop-Service -Name $serv;}
			
			# Pausar servicio
			5{Suspend-Service -Name $serv;}
			
			# Reanudar servicio
			6{Resume-Service -Name $serv;}
			
			# Reiniciar servicio
			7{Restart-Service -Name $serv;}
			
			# Volver
			8{return;}
			
			# Mostrar error
			default{echo "Opción no válida";}
		}
		
		echo "";
	}
}

while ($true){
	echo "¿Qué desea hacer?";
	echo "1. Listar servicios";
	echo "2. Mostrar información de un servicio";
	echo "3. Gestionar servicios";
	echo "4. Salir";
	$ans = Read-Host;
	
	Clear-Host;
	
	switch ($ans){
		# Mostrar servicios
		1{
			Get-Service;
			echo "";
		}
		
		# Mostrar detalles de un servicio
		2{
			echo "Inserte el nombre del servicio";
			$serv = Read-Host;
			Get-Service $serv;
			echo "";
		}
		
		# Gestor de servicios
		3{
			menu_servicios;
			Clear-Host;
		}
		
		# Salir
		4{return;}
		
		# Mostrar error
		default{echo "Opción no válida";}
	}
}