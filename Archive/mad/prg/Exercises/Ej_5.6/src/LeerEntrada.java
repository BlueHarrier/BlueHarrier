import java.util.Scanner;

public class LeerEntrada{
	private Scanner in = new Scanner(System.in);
	
	String leerString(){
		return in.nextLine();
	}
	
	int leerInt(){
		return in.nextInt();
	}
	
	boolean continuar(){
		System.out.print("\n¿Continuar? (y/n): ");
		String line;
		do{
			line = in.nextLine();
		}
		while (line.isEmpty());
		char ch = line.toLowerCase().charAt(0);
		return (ch == 'y' || ch == 's');
	}
}