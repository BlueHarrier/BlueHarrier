// Requires the Java util Scanner class
import java.util.Scanner;

/* The class Tree generates a tree based on the input and prints the total height of it
* @author Daniel "BlueHarrier" Píriz
* @version 1.0.2
* @since 5/11/2022
*/

public class Tree {
	/* Main function. Counts and prints the height of a given number of trees.
	* @param String[] Arguments of the program
	*/
	public static void main(String args[]){
		// Initialize input
		Scanner in  = new Scanner(System.in);
		
		// Create an entire tree based on the input and the number of cases
		int cases = in.nextInt();
		for (int i = 0; i < cases; i++){
			Branch root = new Branch(in);
			System.out.println(Integer.toString(root.getHeight()));
		}
	}
}
