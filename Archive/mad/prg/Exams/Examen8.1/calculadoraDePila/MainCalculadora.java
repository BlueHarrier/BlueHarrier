import java.util.Scanner;
import java.util.Stack;

/* Performs calculations using a pile class.
 * @author Daniel "BlueHarrier" Píriz
 * @version 2.0.0
 * @since 29/01/2023
 */

// 13/02/2023 exam update

public class MainCalculadora{

    /* Manual calculator test.
     * @param String[] Arguments of the program
     */
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        MainCalculadora calculator = new MainCalculadora();
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
    public MainCalculadora(){
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

            case '!':
                factorial();
                break;
            
            default:
                this.pile.push(Integer.parseInt(input));
                break;
        }
    }

    /* Shows the current top of the pile.
     * @return int Peek on the pile
     */
    public int show(){
        return this.pile.peek();
    }

    /* Makes an addition based on the operation pile and pushes it back.
     */
    private void add(){
        int firstAdder = this.pile.pop();
        int secondAdder = this.pile.pop();
        this.pile.push(firstAdder + secondAdder);
    }

    /* Makes a multiplication based on the operation pile and pushes it back.
     */
    private void multiply(){
        int firstMultiplier = this.pile.pop();
        int secondMultiplier = this.pile.pop();
        this.pile.push(firstMultiplier * secondMultiplier);
    }

    /* Calculates the factorial based on the last number on the pile.
     */
    private void factorial(){
        int number = this.pile.pop();
        this.pile.push(factorialNumber(number));
    }

    /* Recursively calculates the factorial.
     * @param int Number to calculate the factorial of
     * @return int Resulting factorial
     */
    private int factorialNumber(int number){
        if(number > 1) return number * factorialNumber(number - 1);
        return 1;
    }
}