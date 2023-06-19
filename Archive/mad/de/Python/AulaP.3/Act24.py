number_of_packages = int(input("Introduzca el número de paquetes: "))
average = 0
heaviest = 0
lightest = -1

for pack in range(1, number_of_packages + 1):
    pack_weight = int(input(f"Inserte peso del paquete Nº {pack}: "))
    if pack_weight > heaviest:
        heaviest = pack_weight
    if pack_weight < lightest or lightest == -1:
        lightest = pack_weight
    average += pack_weight

average /= number_of_packages

print(f"La media de peso es de {average}, el paquete más pesado pesaba {heaviest} y el más ligero {lightest}")
