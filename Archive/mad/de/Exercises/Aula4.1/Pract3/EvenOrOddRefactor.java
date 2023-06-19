import java.util.Scanner;

public class EvenOrOddRefactor {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        String output;
        if (input % 2 == 0) output = "Is even";
        else output = "Is odd";
        System.out.println(output);
        in.close();
    }
}
