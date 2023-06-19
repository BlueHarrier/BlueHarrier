// Uses java util scanner
import java.util.Scanner;

/** This class will display session information and ask for two integer numbers to divide.
 * 
 * @author Daniel "BlueHarrier" Píriz
 * @version 1.0
 * @since 12/10/2022
 */

 public class SessionDataDiv{

    // Define colors and reset
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";

    // Create new scanner
    public static Scanner in = new Scanner(System.in);

    /** Class's main function, will display session information and ask for two integer numbers to divide.
     * 
     * @param String[] Program execution arguments
     * @return Void
     */

    public static void main(String args[]){
        // Pick up session info
        String user = System.getProperty("user.name");
        String operatingSys = System.getProperty("os.name");
        System.out.println("User " + user + " working from " + operatingSys + ".");

        // Perform division
        int dividend = askForInt("Insert dividend: ");
        int divided = askForInt("Insert divider: ");
        int quotient = dividend / divided;
        int rest = dividend % divided;
        String strOfQuotient = ANSI_BLUE + String.valueOf(quotient) + ANSI_RESET;
        String strOfRest = ANSI_RED + String.valueOf(rest) + ANSI_RESET;
        System.out.println("The result is " + strOfQuotient + ", and its rest is " + strOfRest + ".");
    }

    /** This function asks for an integer through the console with a custom message, and doesn't allow for anything that cannot be parsed.
     *  
     * @param String Custom message to display
     * @return Integer
     */

     public static int askForInt(String msg){
        // Enters infinite loop until valid int is imputed
        while(true){
            try{
                System.out.print(msg);
                int number = Integer.parseInt(in.nextLine());
                return number;
            }
            catch (Exception _e){
                System.out.println("ERROR: Invalid integer to parse, try again.");
            }
        }
     }
 }
