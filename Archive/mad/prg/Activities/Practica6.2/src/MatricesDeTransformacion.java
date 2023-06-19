import java.util.Scanner;

/* Class that calculates invert kinematics.
* @author Daniel "BlueHarrier" Píriz
* @version 1.0.0
* @since 1/12/2022
*/

public class MatricesDeTransformacion{
	// Define default matrix size
	public static final int MATRIX_SIZE = 11;

	/* "Calculates" the inverse kinematic of a 2 point arm.
	* @param int X coordinate
	* @param int Y coordinate
	* @return float[] Resulting angles of the transformation
	*/
	public static float[] cinematicaInversa2D(int positionX, int positionY){

		// Generate coordinate matrix: "x y"
		String[][] coordinates = new String [MATRIX_SIZE][MATRIX_SIZE];
		for (int x = 0; x < MATRIX_SIZE; x++){
			for (int y = 0; y < MATRIX_SIZE; y++){
				coordinates[x][y] = Integer.toString(x) + " " + Integer.toString(y);
			}
		}

		// Init angles array
		float[] angle = {0.0f, 0.0f};

		// Generate a scanner for the coordinates
		Scanner floatScanner = new Scanner (coordinates[positionX][positionY]);

		// Fill with the coordinates from the String input
		angle[0] = floatScanner.nextFloat();
		angle[1] = floatScanner.nextFloat();

		// Close scanner
		floatScanner.close();

		// Return angle
		return angle;
	}
}