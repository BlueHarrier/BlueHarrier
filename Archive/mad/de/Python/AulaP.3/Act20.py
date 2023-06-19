pi = 3.14159265359

radius = float(input("Introduzca el radio del cilindro: "))
height = float(input("Introduzca su altura: "))

if (radius < height):
    volume = pi * radius ** 2 * height
    print("El volumen del cilindro es " + str(volume))
else:
    side_area = pi * 2 * radius * (height + radius)
    print("El área del lateral es " + str(side_area))