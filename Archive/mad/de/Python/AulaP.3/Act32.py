# Tomamos el consumo y el precio del Kw
consumption = int(input("Introduzca el consumo que ha tenido la familia (Kw): "))
price = float(input("Introduzca el precio del kilovatio: "))

# Calculamos cuánto se pasa la factura de 700 Kw
difference = 0
if (consumption > 700):
    difference = consumption - 700
    consumption = 700

# Caluclamos y mostramos el total
total = price * (consumption + difference * 1.05)
print (f"La familia pagaría {total}€ de luz.")