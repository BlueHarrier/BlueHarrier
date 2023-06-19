# Entrada
in_number = int(input("Ingrese un número para comprobar: "))

# Evitar posible bucle infinito
if (in_number <= 0):
    in_number = 1

# Realizar operación
count = 1
operation = 0
while (True):
    operation += count ** 2
    if (operation > in_number):
        break
    count += 1

# Imprimir resultado
print(f"El número a partir del cual la serie supera a la entrada es {count}.")