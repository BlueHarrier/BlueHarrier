
$params = @{
	Name = "Ejercicio4"
	BinaryPathName = '"C:\Windows\System32\WindowsPowerShell\v1.0\powershell.exe" -file "C:\Users\DaciaLogan\Desktop\DAW-SI\Examen_Powershell\sercice.ps1"'
	DependsOn = "NetLogon"
	DisplayName = "Ejercicio 4"
	StartupType = "Automatic"
	Description = "¿?"
};
New-Service @params;

# Resto del ejercicio en el archivo del servicio (service.ps1)