package ZonaVerde;

import java.util.Scanner;

public class ZonaVerde {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int height = in.nextInt();
            int width = in.nextInt();
            int[][] zoneId = new int[width][height];
            for (int y = 0; y < height; y++){
                String line = in.next();
                for (int x = 0; x < width; x++){
                    char c = line.charAt(x);
                    if (c == 'V'){
						zoneId[x][y] = 1;
					}
					else{
						zoneId[x][y] = 0;
					}
                }
            }

			int maxCount = 0;
            for (int y = 0; y < height; y++){
                for (int x = 0; x < width; x++){
                    if (zoneId[x][y] == 1){
						int count = flagZoneRecurse(zoneId, x, y, width, height, 0);
						if (count > maxCount) maxCount = count;
               		}
                }
            }

			System.out.println(maxCount);
        }
        in.close();
    }

	public static Integer flagZoneRecurse(int[][]zoneId, int x, int y, int width, int height, int count){
		count += 1;
		zoneId[x][y] = 2;

		int left = x > 0 ? zoneId[x - 1][y] : 0;
		if (left == 1) count = flagZoneRecurse(zoneId, x - 1, y, width, height, count);
		int up = y > 0 ? zoneId[x][y - 1] : 0;
		if (up == 1) count = flagZoneRecurse(zoneId, x, y - 1, width, height, count);
		int right = x < (width - 1) ? zoneId[x + 1][y] : 0;
		if (right == 1) count = flagZoneRecurse(zoneId, x + 1, y, width, height, count);
		int down =  y < (height - 1) ? zoneId[x][y + 1] : 0;
		if (down == 1) count = flagZoneRecurse(zoneId, x, y + 1, width, height, count);

		return count;
	}
}
