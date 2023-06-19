import java.util.Scanner;

public class SpaceInvaders{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        while (cases-- > 0){
            int records = in.nextInt();
            int doubleRecords = records * 2;
            StringBuilder output = new StringBuilder();
            output.setLength(records * 3);
            for (int i = 0; i < records; i++){
                String name = in.next();
                output.setCharAt(i, name.charAt(0));
                output.setCharAt(i + records, name.charAt(1));
                output.setCharAt(i + doubleRecords, name.charAt(2));
            }
            System.out.println(output);
        }
        in.close();
    }
}