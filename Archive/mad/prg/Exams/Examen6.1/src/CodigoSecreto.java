import java.util.Random;

/* Class that manages a secretly generated code.
 * @author Daniel "BlueHarrier" Píriz
 * @verion 1.0.0
 * @since 12/02/2023
 */

public class CodigoSecreto{
    // Secret code array
    private int secretCode[];

    /* Basic constructor. Generates the secret code.
     * @param int Digits for the code.
     */
    public CodigoSecreto(int digits){
        // Generate new randomizer
        Random randomizer = new Random();

        // Generate secret code
        secretCode = new int[digits];
        for (int i = 0; i < digits; i++){
            secretCode[i] = randomizer.nextInt(9);
        }
    }

    /* Converts a string into a valid code.
     * @param String Input string
     * @return int[] Array of numbers that conform the code
     */
    public int[] convertirCodigo(String s){
        // Parse each letter individually
        int ret[] = new int[s.length()];
        for (int i = 0; i < s.length(); i++){
            ret[i] = Integer.parseInt(s.substring(i, i + 1));
        }
        return ret;
    }

    /* Compares and prints the validity of the code.
     * @param int[] Code to try
     * @return boolean Whether the code was completely correct or not
     */
    public boolean pruebaCodigo(int[] c){
        // Count how many correct numbers the player had
        int count = 0;

        // Compare, count and print
        for (int i = 0; i < secretCode.length; i++){
            if (secretCode[i] == c[i]){
                System.out.print("=");
                count++;
            }
            else{
                System.out.print(secretCode[i] > c[i] ? "M" : "m");
            }
        }
        System.out.println(count);

        // Array.equals is not necessary here, we already know the answer
        return (count == secretCode.length);
    }
}