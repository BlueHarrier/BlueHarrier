# Inicio de la cuenta, es el sumatorio de 2^n (manual)
count = 0
for i in range(1, 64):
    subcount = 1
    for j in range(0, i):
        subcount *= 2
    count += subcount

# Pasar a toneladas (1Kg = 20.000 granos y 1 ton = 1.000 Kg)
tons = int(count / 20000 / 1000)

# Imprimir resultado
print(f"El rey tendría que pagar {tons} toneladas de trigo al creador del ajedrez.")