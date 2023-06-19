import java.util.Scanner;

public class Hexagono {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {

            int tamano = sc.nextInt();
            char carac = sc.next().charAt(0);

            if (tamano == 0 && carac == '0') break;

            if (tamano == 0) continue;

            int signo = 1;
            int i = 0;
            do {
                int num_espacios = tamano - (i + 1);
                int num_caracteres = tamano + (i * 2);
                printLinea(num_espacios, ' ');
                printLinea(num_caracteres, carac);
                System.out.println();
                if (num_espacios == 0) signo = -1;
                i += signo;
            } while (i >= 0);
        }
        sc.close();
    }

    public static void printLinea(int tamano, char caracter){
        for (int i = 0; i < tamano; i++){
            System.out.print(caracter);
        }
    }

}