
$date = Read-Host "Introduzca la fecha del recordatorio (DD/MM/AAAA): ";

# No tengo anotados los triggers, pero la fecha se aplicaría sobre ellos.
Register-ScheduledTask -Action &{[System.Reflection.Assembly]::LoadWithPartialName('System.Windwos.Forms');[System.Windows.Forms.MessageBox]::Show('Más te vale no olvidarte del aniversario de mañana. ¡¡¡GAÑAN!!!', 'WARNING')};

# Y -TaskName no funciona, no me está dejando crear la tarea y luego registrarla.