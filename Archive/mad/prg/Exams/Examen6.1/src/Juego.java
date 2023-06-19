import java.util.Scanner;

/* Plays the code game and tries CodigoSecreto
 * @author Daniel "BlueHarrier" Píriz
 * @verion 1.0.0
 * @since 12/02/2023
 */

public class Juego {
    /* Main class.
     * @param String[] Arguments of the program
     */
    public static void main(String args[]){
        // Generate new Scanner
        Scanner in = new Scanner(System.in);

        // Pick up number of digits and create new code
        int digits = in.nextInt();
        CodigoSecreto code = new CodigoSecreto(digits);
        
        // Requires the player to try codes until it's successful
        int insertedCode[];
        do{
            String input = in.next();
            insertedCode = code.convertirCodigo(input);
        }while(!code.pruebaCodigo(insertedCode));

        // Close the Scanner
        in.close();
    }
}
