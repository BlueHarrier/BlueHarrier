// Import Java scanner for the test
import java.util.Scanner;
import java.io.PrintWriter;
import static java.nio.charset.StandardCharsets.UTF_8;

/* Runs a test for the MatricesDeTransformacion class.
* @author Daniel "BlueHarrier" Píriz
* @version 1.0.0
* @since 1/12/2022
*/

public class Test{
	/* Main function, test run.
	* @param String[] Arguments of the program
	*/
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out, true, UTF_8);
		out.println("Introduzca los numeros a probar:");
		int x, y;
		x = Math.max(Math.min(in.nextInt(), 14), -14);
		y = Math.max(Math.min(in.nextInt(), 14), -14);
		float[] angles = MatricesDeTransformacion.cinematicaInversa2D(x, y);
		String str = "Angulo resultante: ";
		str += Float.toString(angles[0]) + "º, ";
		str += Float.toString(angles[1]) + "º";
		out.println(str);
		in.close();
	}
}