# Características del programa:
# 1. Mostrar todos los procesos
# 2. Mostrar detalles de un proceso por nombre o por ID
# 3. Iniciar procesos
# 4. Detener proceso
# 5. Salir (que no se te olvide, melón, que vas a hacer un while true)

$ErrorActionPreference = "SilentlyContinue";

while ($true){
	echo "¿Qué deseas hacer?";
	echo "1. Mostrar todos los procesos";
	echo "2. Mostrar detalles de un proceso";
	echo "3. Iniciar un proceso";
	echo "4. Detener un proceso";
	echo "5. Salir";
	$ans = Read-Host;
	
	switch ($ans){
		# Mostrar procesos
		1{Get-Process;}
		
		# Mostrar detalles de un proceso
		2{
			echo "Inserte el nombre o ID del proceso para comprobar:";
			$in = Read-Host;
			$val = 0;
			if ([int]::TryParse($in, [ref]$val)) {Get-Process -Id $in;}
			else {Get-Process -Name $in;}
		}
		
		# Iniciar proceso
		3{
			echo "Inserte el nombre del proceso para iniciar:";
			$name = Read-Host;
			$proc = Start-Process $name;
		}
		
		# Detener proceso
		4{
			echo "Inserte el nombre o ID del proceso para detener:";
			$in = Read-Host;
			$val = 0;
			if ([int]::TryParse($in, [ref]$val)) {Stop-Process -Id $in;}
			else {Stop-Process -Name $in;}
		}
		
		# Salir
		5{return;}
		
		# Mostrar error
		default{echo "Número no reconocido";}
	}
}