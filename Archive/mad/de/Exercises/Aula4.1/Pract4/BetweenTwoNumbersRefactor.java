import java.util.Scanner;

public class BetweenTwoNumbersRefactor {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        if (isBetweenOneAndTwentyFive(input)) System.out.println("It's between 1 and 25");
        else System.out.println("It's not between 1 and 25");
        in.close();
    }

    public static boolean isBetweenOneAndTwentyFive(int n){
        return (n > 0 && n <26);
    }
}
