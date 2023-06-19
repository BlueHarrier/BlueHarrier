import math
print ("¿Qué capacidad tiene tu disco duro? (En MB)")
cap = float(input())
disk = int(math.ceil(cap / 1.44))
print ("Necesitarás " + str(disk) + " disquetes para realizar la copia.")