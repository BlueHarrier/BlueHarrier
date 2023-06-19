import java.util.Scanner;
import java.util.Stack;

/* Performs calculations using a pile class.
 * @author Daniel "BlueHarrier" Píriz
 * @version 1.0.0
 * @since 29/01/2023
 */

public class CalculadoraRPN{

    /* Manual calculator test.
     * @param String[] Arguments of the program
     */
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        CalculadoraRPN calculator = new CalculadoraRPN();
        String element = input.next();
        while (element.charAt(0) != '='){
            calculator.operate(element);
            element = input.next();
        }
        System.out.println(calculator.show());
        input.close();
    }

    // Pile definition
    private Stack<Integer> pile;

    /* Default constructor.
     */
    public CalculadoraRPN(){
        this.pile = new Stack<Integer>();
    }

    /* Performs an operation based on the received input.
     */
    public void operate(String input){
        char operator = input.charAt(0);
        switch (operator){
            case '+':
                add();
                break;

            case '*':
                multiply();
                break;
            
            default:
                pile.push(Integer.parseInt(input));
                break;
        }
    }

    /* Shows the current top of the pile.
     * @return int Peek on the pile
     */
    public int show(){
        return pile.peek();
    }

    /* Makes an addition based on the operation pile and pushes it back.
     */
    private void add(){
        int firstAdder = pile.pop();
        int secondAdder = pile.pop();
        pile.push(firstAdder + secondAdder);
    }

    /* Makes a multiplication based on the operation pile and pushes it back.
     */
    private void multiply(){
        int firstMultiplier = pile.pop();
        int secondMultiplier = pile.pop();
        pile.push(firstMultiplier * secondMultiplier);
    }
}