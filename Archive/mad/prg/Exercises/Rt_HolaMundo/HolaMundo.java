import java.util.Scanner;

public class HolaMundo{
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		if (0 <= n && n <= 5){
			for (int i = 0; i < n; i++){
				System.out.println("Hola mundo.");
			}
		}
	}
}