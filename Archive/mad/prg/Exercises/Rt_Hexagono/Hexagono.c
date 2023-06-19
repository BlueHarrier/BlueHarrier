#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char* printLinea(int espacios, int tamano, char caracter){
	int total = espacios + tamano;
	char* string = malloc(sizeof(char) * (total + 1));
	int i = 0;
	while (i < tamano){
		string[i] = (i < espacios) ? ' ' : caracter;
		i++;
	}
	return string;
}


int main(){
	while (1){
		int tamano;
		char carac;
		scanf("%i %c", &tamano, &carac);

		if (tamano == 0 && carac == '0') break;
		if (tamano == 0) continue;

		char** repeticion = malloc(sizeof(char*) * (tamano - 1));

		int i = 0;
		while(i < tamano){
			int num_espacios = tamano - (i + 1);
			int num_caracteres = tamano + (i * 2);
			char* str = printLinea(num_espacios, num_caracteres, carac);
			printf("%s\n", str);
			if (i < (tamano - 1)) repeticion[i] = str;
			else free(str);
			i++;
		}

		i = tamano - 2;
		while (i >= 0){
			printf("%s\n", repeticion[i]);
			free(repeticion[i]);
			i--;
		};

		free(repeticion);
	}

	return 0;
}