# Inicio de la cuenta, es el sumatorio de 2^n
count = 0
for i in range(1, 64):
    count += 2 ** i

# Pasar a toneladas (1Kg = 20.000 granos y 1 ton = 1.000 Kg)
tons = int(count / 20000 / 1000)

# Imprimir resultado
print(f"El rey tendría que pagar {tons} toneladas de trigo al creador del ajedrez.")