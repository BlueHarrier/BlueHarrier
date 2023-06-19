import java.util.Scanner;

public class JuegosEnCinta {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        while (cases-- > 0){
            int tapeLength = in.nextInt();
            int gameNumber = in.nextInt();
            int tapeSides[] = new int[2];
            boolean fits = true;
            for (int i = 0; i < gameNumber; i++){
                int nextGame = in.nextInt();
                if (tapeSides[0] + nextGame <= tapeLength) tapeSides[0] += nextGame;
                else if (tapeSides[1] + nextGame <= tapeLength) tapeSides[1] += nextGame;
                else fits = false;
            }
            System.out.println(fits ? "SI" : "NO");
        }
        in.close();
    }
}
