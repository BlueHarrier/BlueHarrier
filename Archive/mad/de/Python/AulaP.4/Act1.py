# return (pow(2, $p - 1) % $p) == 1;

def is_prime(number):
    number = abs(number)
    if number <= 2:
        return True
    return (2 ** (number - 1) % number) == 1

while (True):
    in_str = input("Introduzca un número ó q para salir: ")
    if in_str == "q":
        break
    in_num = int(in_str)
    if is_prime(in_num):
        print("El número es primo.")
    else:
        print("El número no es primo.")
    