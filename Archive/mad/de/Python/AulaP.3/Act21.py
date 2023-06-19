width = float(input("Introduzca el ancho: "))
height = float(input("Introduzca la altura: "))
depth = float(input("Introduzca el hondo: "))

diag1 = (width ** 2 + height ** 2) ** 0.5
diag2 =(width ** 2 + depth ** 2) ** 0.5
diag3 = (height ** 2 + depth ** 2) ** 0.5

if (diag1 > diag2 and diag1 > diag3):
    print(f"La diagonal más grande es la que hay entre el ancho y el alto: {diag1}.")
elif (diag2 > diag3):
    print(f"La diagonal más grande es la que hay entre el ancho y el hondo: {diag2}.")
else:
    print(f"La diagonal más grande es la que hay entre el alto y el hondo: {diag3}.")

global_diag = (height ** 2 + diag2 ** 2) ** 0.5
print(f"La diagonal de la sala sería {global_diag}.")

bird_time = 10
bird_speed = global_diag / bird_time
print(f"Un pájaro que tarde {bird_time} segundos en llegar a la otra esquina volaría a {bird_speed} u/s.")