package Pasajeros;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class Pasajeros {

	public static class Pasajero{
		public int edad;
		public boolean antiguo;
		public int mes;

		public Pasajero(int edad, boolean antiguo, int mes){
			this.edad = edad;
			this.antiguo = antiguo;
			this.mes = mes;
			this.id = id;
		}

		@Override
		public String toString(){
			return String.format("%i %i %i", edad, antiguo ? 1 : 0, mes);
		}
	}

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
		ArrayList<Pasajero> normales = new ArrayList<>();
		ArrayList<Pasajero> mayores = new ArrayList<>();
        for (int i = 0; i < cases; i++){
            int edad = in.nextInt();
			int antiguo = in.nextInt();
			int mes = in.nextInt();
			Pasajero pasajero = new Pasajero(edad, antiguo == 1, mes);
			if (pasajero.edad > 60)  mayores.add(pasajero);
			else normales.add(pasajero);
        }

		Pasajero[] ordenFinal = new Pasajero[cases];
		int pos = 0;
		{
			ArrayList<Pasajero> anoAnterior = new ArrayList<>();
			ArrayList<Pasajero> primerAno = new ArrayList<>();
			for (Pasajero pasajero : mayores){
				if (pasajero.antiguo) anoAnterior.add(pasajero);
				else primerAno.add(pasajero);
			}

			
		}

		for (Pasajero pasajero : ordenFinal){
			if (pasajero == null) continue;
			System.out.println(pasajero.toString());
		}
        in.close();
    }
}
