# Características del programa:
# 1. Gestor de usuarios
#	a) Coger usuarios locales
#	b) Crear un usuario local
#	c) Deshabilitar una cuenta de usuario local
#	d) Habilitar una cuenta de usuario local
#	e) Cambiar un nombre de usuario local
#	f) Volver
# 2. Gestor de grupos
#	a) Coger grupos locales
#	b) Crear un grupo local
#	c) Ver miembros de un grupo
#	d) Añadir usuarios a un grupo
#	e) Eliminar usuarios de un grupo
#	f) Cambiar nombre de un grupo
#	g) Eliminar un grupo local
#	h) Volver
# 3. Salir

Clear-Host;

function menu_users{
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

function menu_groups{
	while ($true){
		echo "Gestor de grupos";
		echo "1. Mostrar grupos locales";
		echo "2. Crear grupo local";
		echo "3. Ver miembros de un grupo local";
		echo "4. Añadir usuarios a un grupo";
		echo "5. Eliminar usuarios de un grupo";
		echo "6. Renombrar grupo";
		echo "7. Eliminar grupo local";
		echo "8. Volver";
		$ans = Read-Host;
		
		Clear-Host;
		
		switch ($ans){
			1{Get-LocalGroup;}
			
			2{
				echo "Inserte el nombre del nuevo grupo";
				$val = Read-Host;
				New-LocalGroup -name $val;
			}
			
			3{
				echo "Inserte el nombre del grupo que desea comprobar";
				$val = Read-Host;
				Get-LocalGroup -name $val
			}
			
			8{return;}
		}
	}
}

while ($true){
	echo "¿Qué deseas hacer?";
	echo "1. Gestionar usuarios";
	echo "2. Gestionar grupos";
	echo "3. Salir";
	$ans = Read-Host;
	
	Clear-Host;
	
	switch ($ans){
		# Información de procesos
		1{menu_users;}
		
		# Mostrar detalles de un proceso
		2{menu_groups;}
		
		# Salir
		3{return;}

		# Mostrar error
		default{echo "Opción no válida";}
	}
}