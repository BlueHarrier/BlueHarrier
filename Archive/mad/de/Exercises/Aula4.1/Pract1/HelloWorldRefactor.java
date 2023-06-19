import java.util.Scanner;

public class HelloWorldRefactor{

    public static void print(int reps){
        for (int i = 0; i < reps; i++){
            System.out.println("Hello world");
         }  
    }

    public static void mani(String args[]){
        Scanner in = new Scanner (System.in);
        int repetitions = in.nextInt();
        print(repetitions);
        in.close();
    }
}