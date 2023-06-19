# Importar randomizer
import random

# Función de obtención de ganador, devuelve -1 si hay empate
def get_winner(votes):
    winner = ''
    winner_count = 0
    stalemate = False
    for candidate in votes.keys():
        if (winner_count == votes[candidate]):
            stalemate = True
        if (votes[candidate] > winner_count):
            winner = candidate
            winner_count = votes[candidate]
            stalemate = 0
    if (stalemate):
        return -1
    return winner

# Constante de edad mínima y población
MIN_AGE = 18
POPULATION = 150000

# Definir votos en blanco, nulos y de cada candidato (diccionario)
blanks = 0
nulls = 0
votes = {'1': 0, '2': 0, '3': 0}

# Por cada voto, se genera y lo asigna a la categoría correspondiente
for i in range(0, POPULATION):
    next_vote = str(random.randrange(0, 5))
    if (next_vote == '0'):
        blanks += 1
        continue

    if (next_vote in votes):
        votes[next_vote] += 1
        continue

    nulls += 1

# Muestra los resultados de los candidatos, votos en blanco y nulos, y ganador si hay
for candidate in votes.keys():
    print(f"El candidato {candidate} ha obtenido {votes[candidate]} votos.")
print (f"Ha habido un total de {blanks} votos en blanco y {nulls} nulos.")
winner = get_winner(votes)
if (winner == -1):
    print("Ha habido un empate.")
else:
    print(f"Ha ganado {winner}.")