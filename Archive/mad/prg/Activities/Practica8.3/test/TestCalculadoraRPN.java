import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.Scanner;

/* Testing class of the pile calculator.
 * @author Daniel "BlueHarrier" Píriz
 * @version 1.0.0
 * @since 29/01/2023
 */

public class TestCalculadoraRPN {

    /* General testing for the pile.
     * @param String List of operations to perform
     * @param int Expected result
     */
    public static void generalPileTest(String operation, int expected){
        CalculadoraRPN calculator = new CalculadoraRPN();
        Scanner operationScanner = new Scanner(operation);
        while (operationScanner.hasNext()){
            String element = operationScanner.next();
            calculator.operate(element);
        }
        operationScanner.close();

        int result = calculator.show();
        assertEquals(expected, result);
    }

    /* Tests the operation 3 2 * 2 + 4 *, which results in 32.
     */
    @Test
    public void pileTestShort(){
        final String OPERATION = "3 2 * 2 + 4 *";
        final int EXPECTED = 32;

        generalPileTest(OPERATION, EXPECTED);
    }

    /* Tests the operation 3 2 * 2 + 4 * 3 * 2 + 4 * 3 + 2 * 2 + 4 *, which results in 3168.
     */
    @Test
    public void pileTestLong(){
        final String OPERATION = "3 2 * 2 + 4 * 3 * 2 + 4 * 3 + 2 * 2 + 4 *";
        final int EXPECTED = 3168;

        generalPileTest(OPERATION, EXPECTED);
    }
}
