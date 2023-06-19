import java.util.Scanner;

public class PantallaDeCarga{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        while (true){
            int resolution[] = {0, 0};
            resolution[0] = in.nextInt();
            resolution[1] = in.nextInt();
            if (resolution[0] == 0 && resolution[1] == 0) break;
            if (isValid(in, resolution)) System.out.println("SI");
            else System.out.println("NO");
        }
        in.close();
    }

    static boolean isValid(Scanner in, int[] resolution){
        char chunks[][][] = new char[resolution[0] / 8][resolution[1] / 8][2];
        boolean rt = true;
        for (int y = 0; y < resolution[1]; y++){
            String line = in.next();
            int chunkY = y/8;
            int chunkX = 0;
            char charSet[] = chunks[chunkX][chunkY];
            for (int x = 0; x < resolution[0]; x++){
                if (!rt) break;
                char c = line.charAt(x);
                if (x/8 > chunkX){
                    chunkX++;
                    charSet = chunks[chunkX][chunkY];
                }
                if (c != charSet[0] && c != charSet[1]){
                    if (charSet[0] == '\u0000'){
                        charSet[0] = c;
                        continue;
                    }
                    if (charSet[1] == '\u0000'){
                        charSet[1] = c;
                        continue;
                    }
                    rt = false;
                }
            }
        }
        return rt;
    }
}