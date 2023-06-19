// Include Randomizer, ArrayList, PrintWriter and UTF_16 encoding
import java.util.Random;
import java.util.ArrayList;
import java.io.PrintWriter;
import static java.nio.charset.StandardCharsets.UTF_8;;

/* Class that simulates a data transmission.
 * @author Daniel "BlueHarrier" Píriz
 * @version 1.0.0
 * @since 26/01/2023
 */

public class TransmisionDeArchivos {
    // Lorem Ipsum (test)
    public static final String LOREM_IPSUM = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean sed eleifend massa, a dapibus justo. Ut viverra ullamcorper ex, vitae pretium enim efficitur porta. In a maximus elit. Aliquam tortor erat, elementum nec ornare sit amet, gravida nec sem. Curabitur scelerisque euismod enim ut interdum. Phasellus aliquet, justo vitae eleifend facilisis, orci velit venenatis lectus, quis imperdiet neque nisl efficitur arcu. Fusce quis tortor placerat, scelerisque elit nec, mattis diam. Fusce id scelerisque diam. Duis at semper urna, ac condimentum augue. Aliquam non nibh id odio cursus iaculis. Suspendisse volutpat semper dui, non porta augue dapibus ac. Aliquam non mauris elit. Mauris nec turpis a erat tincidunt dapibus quis eget eros. Integer accumsan sodales ante eu ultricies. Nullam posuere, sapien vel consectetur rhoncus, tellus ligula commodo quam, et scelerisque mauris sapien quis quam.";
    
    // Constants for transmision
    public static final String PREAMBLE = "\u00AA\u00AA\u00AA\u00AA\u00AA\u00AA\u00AA";
    public static final String WEFT_BEGIN = "\u00AB";
    public static final String BROADCAST = "FF:FF:FF:FF:FF:FF";
    public static final String ORIGIN = "68:94:23:F2:7A:67";

    // Text length
    public static final int DATA_LENGTH = 100;

    // Unicode shortcuts
    public static char H_PIPE = '\u2550';
    public static char V_PIPE = '\u2551';
    public static char L_U_PIPE = '\u255D';
    public static char R_U_PIPE = '\u255A';
    public static char L_D_PIPE = '\u2557';
    public static char R_D_PIPE = '\u2554';
    public static char T_L_PIPE = '\u2563';
    public static char T_U_PIPE = '\u2569';
    public static char T_R_PIPE = '\u2560';
    public static char T_D_PIPE = '\u2566';
    public static char Q_PIPE = '\u256C';
    public static char NULL = '\u0000';

    public static final String FILL_STRIP = 
    // Preamble
    "\u2551\u0000\u0000\u0000\u0000\u0000\u0000\u0000"+
    // Begin of strip
    "\u2551 \u0000 "+
    // Destination address
    "\u2551\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"+
    // Origin address
    "\u2551\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"+
    // Message length
    "\u2551\u0000\u0000\u0000 "+
    // Message
    "\u2551\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"+
    // Weft ID
    "\u2551\u0000\u0000\u0000\u2551";

    public static final PrintWriter OUT = new PrintWriter(System.out, true, UTF_8);

    /* Main program function.
     * @param String[] Arguments of the program.
     */
    public static void main(String[] args){
        // Print intro lines
        printFirstStrike();
        OUT.print(V_PIPE);
        OUT.print("PRE");
        printStrip(' ', 4);
        OUT.print(V_PIPE + "SFD" + V_PIPE + "D. DES");
        printStrip(' ', 11);
        OUT.print(V_PIPE + "D. ORG");
        printStrip(' ', 11);
        OUT.print(V_PIPE + "LONG" + V_PIPE + "DATA");
        printStrip(' ', DATA_LENGTH - 4);
        OUT.print(V_PIPE + "N\u00BA " + V_PIPE);
        OUT.print('\n');
        OUT.flush();

        // Generate array list with the transmited data of the String
        ArrayList<String> transmitingData = convertForTransmision(LOREM_IPSUM);
        for (String data : transmitingData){
            transmitData(data);
        }

        // Finish strike and close
        printLastStrike();
    }

    /* Generates the transmited data segments.
     * @param String Input string to transmit
     * @return ArrayList<String> Streamed wefts, ready to be sent.
     */
    public static ArrayList<String> convertForTransmision(String stringToTransmit){
        // Initialize transmision paramenters
        int stringPosition = 0;
        final int LIMIT = stringToTransmit.length();
        Random randomizer = new Random();
        int weftNumber = randomizer.nextInt(1000);
        ArrayList<String> outputSegments = new ArrayList<String>();

        // Create each weft until the string is over
        while (stringPosition < LIMIT){
            int segmentEnd = stringPosition + DATA_LENGTH;
            if (segmentEnd > LIMIT) segmentEnd = LIMIT;
            
            StringBuilder outputStream = new StringBuilder(PREAMBLE + WEFT_BEGIN + BROADCAST + ORIGIN);

            outputStream.append(parseIntToThreeDigits(segmentEnd - stringPosition));

            String segment = stringToTransmit.substring(stringPosition, segmentEnd);
            outputStream.append(segment);

            outputStream.append(parseIntToThreeDigits(weftNumber));

            outputSegments.add(outputStream.toString());
            weftNumber++;
            stringPosition = segmentEnd + 1;
        }

        // Return segments
        return outputSegments;
    }

    /* Converts an int into a String of three values.
     * @param int Input number to convert
     * @return String String of a three digits number
     */
    public static String parseIntToThreeDigits(int input){
        String output = Integer.toString(input);
        while (output.length() < 3){
            output = "0" + output;
        }
        if (output.length() > 3){
            output = output.substring(output.length() - 2);
        }
        return output;
    }

    /* Prints a strip of characters to the main console.
     * @param char Character to print to the screen
     * @param int Number of times the character has to be repeated
     */
    public static void printStrip(char character, int stripLength){
        for (int i = 0; i < stripLength; i++){
            OUT.print(character);
        }
        OUT.flush();
    }

    /* Performs the delayed transmision of data to the screen.
     * @param String Data to transmit
     */
    public static void transmitData(String data){
        printMiddleStrike();
        int j = 0;
        for (int i = 0; i < FILL_STRIP.length(); i++){
            char tableChar = FILL_STRIP.charAt(i);
            if (tableChar == '\u0000'){
                if ((j < data.length() - 3) || (i >= FILL_STRIP.length() - 4)){
                    OUT.print(data.charAt(j));
                    j++;
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                else{
                    OUT.print(' ');
                }
            }
            else OUT.print(tableChar);
            OUT.flush();
        }
        OUT.print("\n");
        OUT.flush();
    }

    /* Prints the beginning of the table.
     */
    public static void printFirstStrike(){
        OUT.print(R_D_PIPE);
        printStrip(H_PIPE, 7);
        OUT.print(T_D_PIPE);
        printStrip(H_PIPE, 3);
        OUT.print(T_D_PIPE);
        printStrip(H_PIPE, 17);
        OUT.print(T_D_PIPE);
        printStrip(H_PIPE, 17);
        OUT.print(T_D_PIPE);
        printStrip(H_PIPE, 4);
        OUT.print(T_D_PIPE);
        printStrip(H_PIPE, DATA_LENGTH);
        OUT.print(T_D_PIPE);
        printStrip(H_PIPE, 3);
        OUT.print(L_D_PIPE);
        OUT.print('\n');
    }

    /* Prints a strikethrough of the table.
     */
    public static void printMiddleStrike(){
        OUT.print(T_R_PIPE);
        printStrip(H_PIPE, 7);
        OUT.print(Q_PIPE);
        printStrip(H_PIPE, 3);
        OUT.print(Q_PIPE);
        printStrip(H_PIPE, 17);
        OUT.print(Q_PIPE);
        printStrip(H_PIPE, 17);
        OUT.print(Q_PIPE);
        printStrip(H_PIPE, 4);
        OUT.print(Q_PIPE);
        printStrip(H_PIPE, DATA_LENGTH);
        OUT.print(Q_PIPE);
        printStrip(H_PIPE, 3);
        OUT.print(T_L_PIPE);
        OUT.print('\n');
    }

    /* Prints the end of the table.
     */
    public static void printLastStrike(){
        OUT.print(R_U_PIPE);
        printStrip(H_PIPE, 7);
        OUT.print(T_U_PIPE);
        printStrip(H_PIPE, 3);
        OUT.print(T_U_PIPE);
        printStrip(H_PIPE, 17);
        OUT.print(T_U_PIPE);
        printStrip(H_PIPE, 17);
        OUT.print(T_U_PIPE);
        printStrip(H_PIPE, 4);
        OUT.print(T_U_PIPE);
        printStrip(H_PIPE, DATA_LENGTH);
        OUT.print(T_U_PIPE);
        printStrip(H_PIPE, 3);
        OUT.println(L_U_PIPE);
    }
}
