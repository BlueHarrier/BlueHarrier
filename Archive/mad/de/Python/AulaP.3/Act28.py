# Importar randomizer
import random

# Inizializar puntuación
score = random.randrange(1, 10)
print(f"La partida ha comenzado con {score} puntos.")

# Python no tiene bucle do-while, así que hay que emularlo con 'while (True)' y 'break'
while (True):
	# Genera una nueva tirada y muestra el resultado
	num1 = random.randrange(1, 7)
	num2 = random.randrange(1, 7)
	result = num1 + num2
	print(f"Ha salido un {result}.")

	# Si el resultado es 5, imprime el resultado y sale
	if (result == 5):
		print(f"Fin de la partida, has obtenido {score} puntos.")
		break

	# Añadir o eliminar puntos según sea múltiplo de 2 (par) o 3
	if (result % 2 == 0 or result % 3 == 0):
		score += 1
		continue # Se continua para ahorrar ciclos
	else:
		score -= 1
	
	# Si se termina la partida, imprime la derrota y sale
	if (score <= 0 and result == 7):
		print(f"Has perdido con {score} puntos.")
		break
