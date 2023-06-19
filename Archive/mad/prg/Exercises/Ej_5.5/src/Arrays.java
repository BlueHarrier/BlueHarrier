import java.util.Scanner;
import java.lang.Math;

public class Arrays{
	
	static int[] generateInputArray(Scanner in){
		System.out.print("Inserte tamaño de la array: ");
		int length = in.nextInt();
		int[] inArray = new int[length];
		
		System.out.print("Inserte el valor mínimo: ");
		int min = in.nextInt();
		System.out.print("Inserte el valor máximo: ");
		int max = in.nextInt();
		if (min > max){
			int tmp = max;
			max = min;
			min = tmp;
		}
		for (int i = 0; i < length; i++){
			inArray[i] = (int) Math.round(Math.random() * (max - min + 1) + min);
		}
		
		return inArray;
	}
	
	static int[] getInputArray(Scanner in){
		System.out.print("Inserte tamaño de la array: ");
		int length = in.nextInt();
		int[] inArray = new int[length];
		
		System.out.print("Inserte array: ");
		for (int i = 0; i < length; i++){
			inArray[i] = in.nextInt();
		}
		
		return inArray;
	}
	
	static int[] removeNumber(int[] inArray, int number){
		int count = 0;
		for (int val : inArray){
			if (val == number)
				count++;
		}
		
		int[] newArray = new int[(inArray.length - count)];
		int c = 0;
		for (int val : inArray){
			if (val != number){
				newArray[c] = val;
				c++;
			}
		}
		
		return newArray;
	}
	
	static void printArray(int[] array){
		System.out.print("Nueva array: ");
		for (int val : array){
			System.out.print(val);
			System.out.print(" ");
		}
	}
	
	static boolean continueRemoving(Scanner in){
		System.out.print("\n¿Continuar? (y/n): ");
		String line;
		do{
			line = in.nextLine();
		}
		while (line.isEmpty());
		char ch = line.toLowerCase().charAt(0);
		return (ch == 'y' || ch == 's');
	}
	
	public static void main(String[] args){
		Scanner in = new Scanner (System.in);
		
		int[] array = generateInputArray(in);
		
		printArray(array);
		
		do{
			System.out.print("\nIndique el número a borrar: ");
			int number = in.nextInt();
			
			array = removeNumber(array, number);
			
			printArray(array);
		}
		while(array.length > 0 && continueRemoving(in));
	}
}