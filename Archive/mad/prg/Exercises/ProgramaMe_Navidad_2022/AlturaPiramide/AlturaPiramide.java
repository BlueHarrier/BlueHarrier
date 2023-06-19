import java.util.Scanner;

public class AlturaPiramide {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        while (true){
            int height = in.nextInt();
            if (height == 0) break;
            int i = 0;
            while (height > 0){
                height -= Math.pow(2 * i + 1, 2);
                i++;
            }
            System.out.println(i);
        }
        in.close();
    }
}
