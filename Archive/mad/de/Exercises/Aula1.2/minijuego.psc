Algoritmo minijuego
	Definir puntos Como Entero
	Definir dado1 Como Entero
	Definir dado2 Como Entero
	Definir suma Como Entero
	
	puntos = 3
	
	Para i <- 0 Hasta 5 Con Paso 1 Entonces
		dado1 = Aleatorio(1, 6)
		dado2 = Aleatorio(1, 6)
		suma = dado1 + dado2
		
		Si suma % 3 == 0 Entonces
			puntos = puntos + 1
		SiNo 
			Si suma % 2 = 0 Entonces
				puntos = puntos - 1
			FinSi
		FinSi
		Si suma == 5 Entonces
			puntos = 0
			i = 5
		SiNo
			Si puntos == 0 Entonces
				i = 5
			FinSi
		FinSi
		
		Imprimir suma " -> " puntos
	FinPara
	
	Si puntos > 0 Entonces
		Imprimir "Victoria"
	SiNo
		Imprimir "Derrota"
	FinSi
FinAlgoritmo
