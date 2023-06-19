package HambreCero;

import java.util.Scanner;

public class HambreCero {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while (in.hasNext()){
			int a = in.nextInt();
			int b = in.nextInt();
			int anos = 0;
			while (a < b){
				a *= 3;
				b *= 2;
				anos++;
			}
			System.out.println(anos);
		}
	}
}
