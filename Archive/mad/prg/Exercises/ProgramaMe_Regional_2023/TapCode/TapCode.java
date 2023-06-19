import java.util.Scanner;

public class TapCode {
    static char[][] CODE = {
        {'A', 'B', 'C', 'D', 'E'},
        {'F', 'G', 'H', 'I', 'J'},
        {'L', 'M', 'N', 'O', 'P'},
        {'Q', 'R', 'S', 'T', 'U'},
        {'V', 'W', 'X', 'Y', 'Z'},
    };
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        while (cases-- > 0){
            String word = in.next().toUpperCase();
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < word.length(); i++){
                if (i > 0) builder.append(" ");
                int[] code = getCharCode(word.charAt(i));
                feedBuilder(builder, code[0]);
                builder.append(" ");
                feedBuilder(builder, code[1]);
            }
            System.out.println(builder.toString());
        }
        in.close();
    }

    public static int[] getCharCode(char letter){
        if (letter == 'K') letter = 'C';
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){
                if (letter == CODE[i][j]) return new int[]{i + 1, j + 1};
            }
        }
        return null;
    }

    public static void feedBuilder(StringBuilder builder, int amount){
        for (int i = 0; i < amount; i++){
            builder.append('*');
        }
    }
}
