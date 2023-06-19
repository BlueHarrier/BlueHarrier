import java.util.Scanner;

public class LaPulga{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        while (cases-- > 0){
            int barSize = in.nextInt();
            int jumpMultiplier = in.nextInt();
            int time = in.nextInt();
            time = time % (barSize + 1);
            System.out.println(Integer.toString(time * jumpMultiplier));
        }
        in.close();
    }
}