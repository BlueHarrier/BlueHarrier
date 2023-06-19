package programacion.Ejercicios.Rt_Buscaminas;

import java.io.PrintWriter;
import java.util.Random;
import static java.nio.charset.StandardCharsets.UTF_8;

public class Buscaminas {
    
	public static final String ANSI_BLACK = "\u001B[30m";	// Black
	public static final String ANSI_WHITE = "\u001B[37m";	// White
	public static final String ANSI_RED = "\u001B[31m";		// Red
	public static final String ANSI_GREEN = "\u001B[32m";	// Green
	public static final String ANSI_YELLOW = "\u001B[33m";	// Yellow
	public static final String ANSI_BLUE = "\u001B[34m";	// Blue
	public static final String ANSI_PURPLE = "\u001B[35m";	// Purple
	public static final String ANSI_CYAN = "\u001B[36m";	// Cyan
	public static final String ANSI_RESET = "\u001B[0m";	// Reset

    public static final char TILE_HIDEN = '\u25a0';
    public static final char TILE_VOID = ' ';
    public static final char TILE_MINE = '\u2B24';
    public static final char[] ALPHABET = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public static final int MINE_CHANCE = 5;
    public static final int MINE_VALUE = -1;
    
    public static final String[] NUMBER_COLOR = {ANSI_CYAN, ANSI_GREEN, ANSI_RED, ANSI_BLUE, ANSI_PURPLE, ANSI_YELLOW, ANSI_RESET, ANSI_RESET};

    public static void main(String[] args) throws InterruptedException{
        PrintWriter output = new PrintWriter(System.out, false, UTF_8);
        boolean[][] visibleTiles = new boolean[16][16];
        for (int i = 0; i < visibleTiles.length; i++){
            for (int j = 0; j < visibleTiles[i].length; j++){
                visibleTiles[i][j] = false;
            }
        }
        printBoard(output, generateRandomGame(0, 0, 16, 16, 64), visibleTiles);
    }

    public static void printBoard(PrintWriter output, int[][] gameMatrix, boolean[][] boardMatrix){
        output.print("\033[H\033[2J");
        output.print(TILE_VOID);
        for (int i = 0; i < gameMatrix.length; i++){
            if (i < 10) output.print(i);
            else output.print(ALPHABET[i - 10]);
        }
        output.print("\n");
        for (int i = 0; i < gameMatrix.length; i++){
            if (i < 10) output.print(i);
            else output.print(ALPHABET[i - 10]);
            for (int j = 0; j < gameMatrix[i].length; j++){
                printTile(output, gameMatrix[i][j], boardMatrix[i][j]);
            }
            output.print("\n");
        }
        output.flush();
    }

    public static void printTile(PrintWriter output, int tileValue, boolean isVisible){
        if (isVisible){
            switch (tileValue) {
                case 0:
                    output.print(TILE_VOID);
                    break;
                
                case MINE_VALUE:
                    output.print(TILE_MINE);
                    break;

                default:
                    output.print(NUMBER_COLOR[tileValue - 1]);
                    output.print(tileValue);
                    output.print(ANSI_RESET);
                    break;
            }
        }
        else{
            output.print(TILE_HIDEN);
        }
    }

    public static int[][] generateRandomGame(int initX, int initY, int width, int height, int mines){
        int[][] gameMatrix = new int[width][height];
        Random randomizer = new Random();
        int mineCount = 0;
        while (mineCount < mines){
            for (int y = 0; y < width; y++){
                for (int x = 0; x < height; x++){
                    if (x == initX && y == initY) continue;
                    if (placeMine(randomizer, gameMatrix, x, y)) mineCount++;
                    if (mineCount == mines) break;
                }
                if (mineCount == mines) break;
            }
        }
        for (int y = 0; y < width; y++){
            for (int x = 0; x < height; x++){
                countSurroundingMines(gameMatrix, x, y);
            }
        }
        return gameMatrix;
    }

    public static boolean placeMine(Random randomizer, int[][] gameMatrix, int x, int y){
        boolean chance = randomizer.nextInt(100) < MINE_CHANCE;
        if (chance) gameMatrix[x][y] = MINE_VALUE;
        return chance;
    }

    public static void countSurroundingMines(int[][] gameMatrix, int x, int y){
        if (gameMatrix[x][y] == MINE_VALUE) return;
        int xStart = (x > 0) ? -1 : 0;
        int xEnd = (x < gameMatrix.length - 1) ? 2 : 1;
        int yStart = (y > 0) ? -1 : 0;
        int yEnd = (y < gameMatrix[x].length - 1) ? 2 : 1;
        for (int dX = xStart; dX < xEnd; dX++){
            for (int dY = yStart; dY < yEnd; dY++){
                if (dX == x && dY == y) continue;
                if (gameMatrix[x + dX][y + dY] == MINE_VALUE) gameMatrix[x][y]++;
            }
        }
    }
}
