import java.util.Scanner;

public class PiramidesAcleopatra {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        while (cases-- > 0){
            int year1 = in.nextInt();
            if (year1 > 0) year1--;
            int year2 = in.nextInt();
            if (year2 > 0) year2--;
            int year3 = in.nextInt();
            if (year3 > 0) year3--;

            int diff1 = Math.abs(year1 - year2);
            int diff2 = Math.abs(year3 - year2);

            if (diff1 == diff2){
                System.out.println("EMPATE");
                continue;
            }
            if (diff1 < diff2){
                System.out.println(year1 >= 0 ? year1 + 1 : year1);
            }
            else{
                System.out.println(year3 >= 0 ? year3 + 1 : year3);
            }
            
        }
        in.close();
    }
}
