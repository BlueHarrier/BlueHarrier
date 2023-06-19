import java.util.Scanner;
import java.util.Stack;

/* Actualización con doubles para la calculadora de pila
 * @author Daniel "BlueHarrier" Píriz
 * @version 2.0.0
 * @since 22/05/2023
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
    private Stack<Double> pile;

    /* Default constructor.
     */
    public CalculadoraRPN(){
        this.pile = new Stack<Double>();
    }

    /* Performs an operation based on the received input.
     */
    public void operate(String input){
        char operator = input.charAt(0);
        switch (operator){
            case '+':
                add();
                break;

            case '-':
                subtract();
                break;

            case '*':
                multiply();
                break;

            case '/':
                divide();
                break;

            default:
                pile.push(Double.parseDouble(input));
                break;
        }
    }

    /* Shows the current top of the pile.
     * @return int Peek on the pile
     */
    public double show(){
        if (pile.size() == 0) return 0.0;
        return pile.peek();
    }

    /* Makes an addition based on the operation pile and pushes it back.
     */
    private void add(){
        double firstAdder = pile.pop();
        double secondAdder = pile.pop();
        pile.push(firstAdder + secondAdder);
    }

    /* Makes an subtraction based on the operation pile and pushes it back.
     */
    private void subtract(){
        double firstAdder = pile.pop();
        double secondAdder = pile.pop();
        pile.push(firstAdder - secondAdder);
    }

    /* Makes a multiplication based on the operation pile and pushes it back.
     */
    private void multiply(){
        double firstMultiplier = pile.pop();
        double secondMultiplier = pile.pop();
        pile.push(firstMultiplier * secondMultiplier);
    }

    /* Makes a division based on the operation pile and pushes it back.
     */
    private void divide(){
        double firstMultiplier = pile.pop();
        double secondMultiplier = pile.pop();
        pile.push(firstMultiplier / secondMultiplier);
    }
}