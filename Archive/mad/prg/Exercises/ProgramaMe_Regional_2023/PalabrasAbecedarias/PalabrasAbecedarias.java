import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

public class PalabrasAbecedarias {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        while (true){
            String line = in.nextLine();
            if (line.equals("ABCD")) break;
            StringTokenizer tokenizer = new StringTokenizer(line, " ");
            HashSet<String> alphabeticWords = new HashSet<>();
            while (tokenizer.hasMoreTokens()){
                String word = tokenizer.nextToken().toLowerCase();
                if ( alphabeticWord(word) ) alphabeticWords.add(word);
            }
            System.out.println( alphabeticWords.size() );
        }
        in.close();
    }

    public static boolean alphabeticWord(String word){
        char prevChar = word.charAt(0);
        for (int i = 1; i < word.length(); i++){
            char nextChar = word.charAt(i);
            if (nextChar == 'ñ') nextChar = 'n';
            if (nextChar >= prevChar) prevChar = nextChar;
            else return false;
        }
        return true;
    }
}
