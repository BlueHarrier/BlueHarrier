# Entrada
num1 = int(input("Introduzca el primer numero: "))
num2 = int(input("Introduzca el segundo numero: "))

# Elegir máximo y mínimo inicial
great = max(num1, num2)
small = min(num1, num2)

# Algoritmo de Euclides:
# dividir por el resto hasta que este sea 0, el divisor de entonces es el MCD.
while (True):
    mod = great % small
    if (mod == 0):
        break
    great = small
    small = mod

# Imprimir resultado
print(f"El MCD de los números {num1} y {num2} es {small}")