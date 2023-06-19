#include <iostream>

using namespace std;

int* generateInputArray(int* length){
	cout << "Inserte tamaño de la array: ";
	cin >> *length;
	
	cout << "Inserte el valor mínimo: ";
	int mn;
	cin >> mn;
	cout << "Inserte el valor máximo: ";
	int mx;
	cin >> mx;
	if (mn > mx){
		int tmp = mx;
		mx = mn;
		mn = tmp;
	}
	int* array = new int[*length];
	for (int i = 0; i < *length; i++){
		array[i] = rand() % (mx - mn + 1) + mn;
	}
	
	return array;
}

int* getInputArray(int* length){
	cout << "Inserte tamaño de la array: ";
	cin >> *length;
	
	cout << "Inserte array: ";
	int* array = new int[*length];
	for (int i = 0; i < *length; i++){
		cin >> array[i];
	}
	
	return array;
}

int* removeNumber(int number, int* inArray, int* length){
	int count = 0;
	for (int i = 0; i < *length; i++){
		if (inArray[i] == number) count++;
	}
	
	int newLength = *length - count;
	int* newArray = new int[newLength];
	int c = 0;
	for (int i = 0; i < *length; i++){
		if (inArray[i] != number){
			newArray[c] = inArray[i];
			c++;
		}
	}
	
	delete[] inArray;
	
	*length = newLength;
	return newArray;
}

void printArray(int* array, int length){
	cout << "Nueva array: ";
	for (int i = 0; i < length; i++){
		cout << array[i] << " ";
	}
}

bool continueRemoving(){
	cout << endl << "¿Continuar? (y/n): ";
	string line;
	do{
		getline(cin, line);
	}
	while(line.empty());
	char ch = line.at(0);
	return (ch == 'y' || ch == 's');
}

int main(){
	int length;
	int* array = generateInputArray(&length);
	
	printArray(array, length);
	
	do{
		int number;
		cout << endl << "Indique el número a borrar: ";
		cin >> number;
		
		array = removeNumber(number, array, &length);
		
		printArray(array, length);
	}
	while(length > 0 && continueRemoving());
	
	delete[] array;
	return 0;
}