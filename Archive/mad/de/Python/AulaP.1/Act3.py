# Coger el nombre
name = input("Introduzca su nombre: ")

# Coger el sexo (solo acepta "m" o "f", en mayúscula o en minúscula)
sex = ""
while (sex != "m" and sex != "f"):
    sex = input("Introduzca su sexo (M/F): ").lower()
    if (sex != "m" and sex != "f"): print("Por favor, introduzca un dato válido")

# Seleccionar el grupo en base a la entrada
group = ""
if (sex == "m"):
    if (name[0] > "n"):
        group = "A"
    else:
        group = "B"
else:
    if (name[0] <= "M"):
        group = "A"
    else:
        group = "B"

# Imprimir grupo
print("Usted está en el grupo " + group)