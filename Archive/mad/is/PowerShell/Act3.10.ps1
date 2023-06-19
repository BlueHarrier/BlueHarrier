# Características del programa:
# 1. Mostrar todos los procesos
# 2. Mostrar detalles de un proceso por nombre o por ID
# 3. Iniciar procesos
# 4. Detener proceso
# 5. Salir (que no se te olvide, melón, que vas a hacer un while true)

Clear-Host;

function menu_get_process{
	while ($true){
		echo "Información de procesos";
		echo "1. Mostrar todos los procesos";
		echo "2. Mostrar detalles de un proceso";
		echo "3. Volver";
		$ans = Read-Host;
		
		Clear-Host;
		
		switch ($ans){
			1{Get-Process;}
			
			2{
				echo "Inserte el nombre o ID del proceso del cual se necesita la información";
				$val = Read-Host;
				try {
					Get-Process -id $val;
				}
				catch {
					Get-Process -name $val;
				}
			}
			
			3{return;}
		}
	}
}

function menu_manage_process{
	while ($true){
		echo "Gestión de procesos";
		echo "1. Abrir nuevo proceso";
		echo "2. Cerrar proceso";
		echo "3. Volver";
		$ans = Read-Host;
		
		Clear-Host;
		
		switch ($ans){
			1{
				echo "Inserte nombre del proceso que desea abrir";
				$val = Read-Host;
				Start-Process $val;
			}
			
			2{
				echo "Inserte el nombre o ID del proceso que desea cerrar";
				$val = Read-Host;
				try {
					Stop-Process -id $val;
				}
				catch {
					Stop-Process -name $val;
				}
			}
			
			3{return;}
		}
	}
}

while ($true){
	echo "¿Qué deseas hacer?";
	echo "1. Información de procesos";
	echo "2. Gestionar procesos";
	echo "3. Salir";
	$ans = Read-Host;
	
	Clear-Host;
	
	switch ($ans){
		# Información de procesos
		1{menu_get_process;}
		
		# Mostrar detalles de un proceso
		2{menu_manage_process;}
		
		# Salir
		3{return;}

		# Mostrar error
		default{echo "Número no reconocido";}
	}
}