number_of_packages = int(input("Introduzca el número de paquetes: "))
light = []
medium = []
heavy = []

for pack in range(1, number_of_packages + 1):
    pack_weight = int(input(f"Inserte peso del paquete Nº {pack}: "))
    if pack_weight <= 10:
        light[len(light)] = pack_weight
        continue
    if pack_weight >= 20:
        heavy[len(heavy)] = pack_weight
        continue
    medium[len(medium)] = pack_weight

print(f"Paquetes ligeros: {light}")
print(f"Paquetes medianos: {medium}")
print(f"Paquetes pesados: {heavy}")