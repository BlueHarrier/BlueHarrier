import java.util.Scanner;

public class Factorial{
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		int[] in = new int[cases];
		for (int i = 0; i < cases; i++){
			in[i] = scanner.nextInt();
		}
		for (int i = 0; i < cases; i++){
			switch (in[i]){
				case 0:
					System.out.println("1");
					break;
				
				case 1:
					System.out.println("1");
					break;
					
				case 2:
					System.out.println("2");
					break;
					
				case 3:
					System.out.println("6");
					break;
					
				case 4:
					System.out.println("4");
					break;
				
				default:
					System.out.println("0");
					break;
			}
		}
	}
}