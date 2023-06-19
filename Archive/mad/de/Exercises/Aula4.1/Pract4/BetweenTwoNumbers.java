import java.util.Scanner;

public class BetweenTwoNumbers {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        if (input > 0){
            if (input < 26) System.out.println("It's between 1 and 25");
            else System.out.println("It's not between 1 and 25");
        }
        else System.out.println("It's not between 1 and 25");
        in.close();
    }
}
