import java.util.Scanner;

public class EvenOrOdd {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        String output;
        if (input % 2 == 0){
            output = "Is even";
            System.out.println(output);
        }
        else{
            output = "Is odd";
            System.out.println(output);
        }
        in.close();
    }
}
