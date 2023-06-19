import java.util.Scanner;

/* Class that checks if a quote has been said by a male or female citizen from a town or not.
 * @author Daniel "BlueHarrier" Píriz
 * @verion 1.0.0
 * @since 12/02/2023
 */

public class Dialectos {

    // Define men and women quite constants
    public static final String MEN = "Colega, coleguita, colegón";
    public static final String WOMEN = ", bueno pero ésto que quede entre nosotros.";

    /* Main function.
     * @params String[] Arguments of the program
     */
    public static void main(String args[]){
        // Generate new Scanner
        Scanner in = new Scanner(System.in);

        while (true){
            // Pick next dialogue
            String dialogue = in.nextLine();

            // Break the loop when the user says so
            if (dialogue.equals("fin de la conversación")) break;

            // Check if it is a man, generates the new String and continues
            if (isMan(dialogue)){
                String print = "[HOMBRE] " + Character.toUpperCase(dialogue.charAt(MEN.length() + 1)) + dialogue.substring(MEN.length() + 2);
                System.out.println(print);
                continue;
            }
            
            // Check if it is a woman, generates the new String and continues
            if (isWoman(dialogue)){
                String print = "[MUJER] " + dialogue.substring(0, dialogue.length() - WOMEN.length()) + ".";
                System.out.println(print);
                continue;
            }

            // If neither of the conditionals are matched, then it's a stranger
            System.out.println("[EXTRANJERO] " + dialogue);
        }

        // Close Scanner
        in.close();
    }

    /* Checks if the dialogue was said by a man.
     * @param String Input dialogue
     * @return boolean Whether the input was said by a man
     */
    public static boolean isMan(String dialogue){
        if (dialogue.length() < MEN.length()) return false;
        String subStr = dialogue.substring(0, MEN.length());
        return subStr.equals(MEN);
    }

    /* Checks if the dialogue was said by a woman.
     * @param String Input dialogue
     * @return boolean Whether the input was said by a woman
     */
    public static boolean isWoman(String dialogue){
        if (dialogue.length() < WOMEN.length()) return false;
        String subStr = dialogue.substring(dialogue.length() - WOMEN.length());
        return subStr.equals(WOMEN);
    }
}
