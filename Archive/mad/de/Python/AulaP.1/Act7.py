# Imprimir los números impares del 1 al 100 (usando un while)
ran = range(1, 100)
i = 0
while (i < len(ran)):
    if (ran[i] % 2 == 1):
        print(str(ran[i]))
    i += 1