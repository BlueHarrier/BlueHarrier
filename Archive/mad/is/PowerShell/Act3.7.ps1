$p = Get-Process | Sort-Object -Property id;

for ($i = 0; $i -lt $p.count; $i++){
	Stop-Process -Force $p[$i];
}
