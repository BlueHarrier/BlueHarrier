import java.util.Scanner;

public class PicPocPong{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        while (true){
            int moves = in.nextInt();
            if (moves == 0) break;
            boolean goingLeft = false;
            int scores[] = {0, 0};
            for (int i = 0; i < moves; i++){
                String newMove = in.next();
                if (newMove.equals("PIC")) goingLeft = !goingLeft;
                if (newMove.equals("PONG!")){
                    scores[goingLeft ? 1 : 0]++;
                }
            }
            System.out.println(Integer.toString(scores[0]) + " " + Integer.toString(scores[1]));
        }
        in.close();
    }
}