$params = @{
	Name = "TurboService"
	BinaryPathName = '"C:\Windows\System32\Turbo.exe"'
	DependsOn = "NetLogon"
	DisplayName = "Turbo Service"
	StartupType = "Automatic"
	Description = "Broom broom"
};
New-Service @params;