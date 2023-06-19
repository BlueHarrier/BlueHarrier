import java.util.Scanner;

public class Radon {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        while (cases-- > 0){
            int height = in.nextInt();
            int width = in.nextInt();
            boolean[][] granite = new boolean[width][height];
            for (int y = 0; y < height; y++){
                String line = in.next();
                for (int x = 0; x < width; x++){
                    char c = line.charAt(x);
                    granite[x][y] = (c == 'g');
                }
            }
            System.out.println( countGranite(granite, width, height) );
        }
        in.close();
    }

    public static int countGranite(boolean[][] board, int width, int height){
        int ore[][] = new int[width][height];
        int oreAmount = 0;
        for (int x = 0; x < board.length; x++){
            for (int y = 0; y < board[x].length; y++){
                if (board[x][y] && ore[x][y] == 0){
                    oreAmount++;
                    ore[x][y] = oreAmount;
                    addGranite(board, ore, x, y, oreAmount);
                }
            }
        }
        return oreAmount;
    }

    public static void addGranite(boolean[][] board, int[][] ore, int x, int y, int id){
        int minX = ((x > 0) ? -1 : 0) + x;
        int maxX = ((x < board.length - 1) ? 1 : 0) + x;
        for (int dX = minX; dX <= maxX; dX++){
            int minY = ((y > 0) ? -1 : 0) + y;
            int maxY = ((y < board[dX].length - 1) ? 1 : 0) + y;
            for (int dY = minY; dY <= maxY; dY++){
                if (dX == x && dY == y) continue;
                if (board[dX][dY] && ore[dX][dY] == 0){
                    ore[dX][dY] = id;
                    addGranite(board, ore, dX, dY, id);
                }
            }
        }
    }
}
