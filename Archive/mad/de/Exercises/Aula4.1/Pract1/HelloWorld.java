import java.util.Scanner;

public class HelloWorld{
    public static void mani(String args[]){
        Scanner in = new Scanner (System.in);
        int repetitions = in.nextInt();
        for (int i = 0; i < repetitions; i++){
            System.out.println("Hello world");
        }
        in.close();
    }
}