number1 = int(input("Introduzca un número de dos cifras: ")[1])
number2 = int(input("Introduza otro número de dos cifras: ")[1])

result = number1 + number2

if (result % 2 == 0):
    print("El resultado de la suma será par.")
else:
    print("El resultado de la suma será impar.")