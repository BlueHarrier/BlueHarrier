#include <iostream>
using namespace std;

char* printLinea(int espacios, int tamano, char caracter){
	int total = espacios + tamano;
	char* string = new char[total + 1];
	for (int i = 0; i < total; i++){
		string[i] = (i < espacios) ? ' ' : caracter;
	}
	string[total] = '\0';
	return string;
}

int main(){
	while (true){
		int tamano;
		char carac;
		cin >> tamano >> carac;

		if (tamano == 0 && carac == '0') break;
		if (tamano == 0) continue;

		char** repeticion = new char*[tamano - 1];

		for (int i = 0; i < tamano; i++){
			int num_espacios = tamano - (i + 1);
			int num_caracteres = tamano + (i * 2);
			char* str = printLinea(num_espacios, num_caracteres, carac);
			cout << str << endl;
			if (i < (tamano - 1)) repeticion[i] = str;
			else delete str;
		}

		for (int i = (tamano - 2); i >= 0; i--){
			cout << repeticion[i] << endl;
			delete repeticion[i];
		}

		delete repeticion;
	}
}
