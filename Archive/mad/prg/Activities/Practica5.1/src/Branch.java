// Requires the Java util Scanner class
import java.util.Scanner;

/* The Branch class contains the height of itself, and its constructor calculates it based on the input Scanner.
* @author Daniel "BlueHarrier" Píriz
* @version 1.0.0
* @since 29/11/2022
*/
public class Branch{	
	// Branch height
	private int branchHeight;
	
	/* Main tree constructor. Requires the root's scanner to transfer to children branches.
	* @param Scanner Console input for the branch building
	*/
	public Branch(Scanner in){
		// Set branch size
		int branchNum = in.nextInt();
		
		// Generate branches and update height
		for (int i = 0; i < branchNum; i++){
			Branch currentBranch = new Branch(in);
			int height = currentBranch.getHeight();
			if(branchHeight < height) branchHeight = height;
		}
		
		// Increase the height by one
		branchHeight++;
	}
	
	/* Branch height getter.
	* @return int Total height of the branch
	*/
	public int getHeight(){
		return branchHeight;
	}			
}