
import java.util.Scanner;

public class MainAvanzado{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int ans = 0;
		while (ans != 4){
			System.out.println("1. ¿Desea un libro?\n2. ¿Desea devolver un libro?\n3. ¿Desea dar de alta un libro?\n4. ¿Desea salir?");
			System.out.print("Inserte el número de lo que desea hacer: ");
			ans = in.nextInt();
			switch (ans){
				case 1:
					System.out.println("¿Qué libro desea devolver?\n");
					// Etc, etc...
					break;
					
				case 2:
					System.out.println("Introduce el código del libro\n");
					// Etc, etc...
					break;
				
				case 3:
					System.out.println("Introduce sus datos separados por \";\"\n");
					// Etc, etc...
					break;
				
				case 4:
					// Evita interferir con default
					break;
				
				default:
					System.out.println("Error: el número introducido no es válido.\n");
			}
		}
	}
}