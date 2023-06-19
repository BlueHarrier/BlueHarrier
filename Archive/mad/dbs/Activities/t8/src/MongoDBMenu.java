import java.util.Scanner;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

public class MongoDBMenu{

	private static final String CLI_CLEAR = "\033[H\033[2J";
	public static final String ANSI_BLACK = "\u001B[30m";	// Black
	public static final String ANSI_WHITE = "\u001B[37m";	// White
	public static final String ANSI_RED = "\u001B[31m";		// Red
	public static final String ANSI_GREEN = "\u001B[32m";	// Green
	public static final String ANSI_YELLOW = "\u001B[33m";	// Yellow
	public static final String ANSI_BLUE = "\u001B[34m";	// Blue
	public static final String ANSI_PURPLE = "\u001B[35m";	// Purple
	public static final String ANSI_CYAN = "\u001B[36m";	// Cyan
	public static final String ANSI_RESET = "\u001B[0m";	// Reset

	public static final String[] MAIN_MENU = {
		"1. Mostrar bases de datos",
		"2. Seleccionar base de datos",
		"3. Buscar elemento",
		"4. Alterar elemento",
		"5. Alterar base de datos",
		"6. Salir"
	};

	public static Scanner in = new Scanner(System.in);
	public static MongoDBConnection connection;
	public static MongoDatabase selectedDB;

	public static void main(String[] args){
		init();
		mainMenu();
	}

	public static void init(){
		System.out.print("¿Iniciar sesión con credenciales por defecto? (Y/N): ");
		{
			char ans = in.nextLine().toLowerCase().charAt(0);
			if (ans == 'n'){
				System.out.print(CLI_CLEAR + "Nombre de usuario: ");
				String user = in.nextLine();
				System.out.print(CLI_CLEAR + "Contraseña: ");
				String pass = in.nextLine();
				connection = new MongoDBConnection(user, pass);
			}
			else connection  = new MongoDBConnection();
		}

		try{
			Thread.sleep(1000);
		}catch (Exception e){}
		System.out.print(CLI_CLEAR);
	}

	public static void printDatabases(){
		MongoIterable<String> databases = connection.getDatabases();
		for (String database : databases){
			System.out.println(database);
		}
		System.out.print("\n");
	}

	public static void mainMenu(){
		while (true){
			if (selectedDB != null) System.out.println(ANSI_BLUE + "Base de datos seleccionada: " + selectedDB.getName());
			System.out.println(ANSI_RESET + "Introduzca una opción:");
			for (int i = 0; i < MAIN_MENU.length; i++){
				if (selectedDB == null && (i > 1 && i < 5)) System.out.print(ANSI_RED);
				else System.out.print(ANSI_RESET);
				System.out.println(MAIN_MENU[i]);
			}

			int ans = getValidNumber();
			System.out.print(CLI_CLEAR);

			switch(ans){
				case 1:
					printDatabases();
					break;

				case 2:
					selectDatabaseMenu();
					break;

				case 3:
					if (selectedDB == null){
						System.out.println(ANSI_RED + "Selecciona una base de datos primero\n");
						break;
					}
					break;

				case 4:
					if (selectedDB == null){
						System.out.println(ANSI_RED + "Selecciona una base de datos primero\n");
						break;
					}
					break;

				case 5:
					if (selectedDB == null){
						System.out.println(ANSI_RED + "Selecciona una base de datos primero\n");
						break;
					}
					break;

				case 6:
					System.out.println("Adiós");
					return;

				default:
					System.out.println(ANSI_RED + "Opción no válida\n");
					break;
			}
		}
	}

	public static void selectDatabaseMenu(){
		MongoIterable<String> databases = connection.getDatabases();
		System.out.println("Seleccione una base de datos:");
		int i = 0;
		for (String database : databases){
			System.out.printf("%d. %s\n", i + 1, database);
			i++;
		}

		int ans = getValidNumber();
		i = 1;
		for (String database : databases){
			if (i == ans){
				selectedDB = connection.getDatabase(database);
				System.out.print(CLI_CLEAR);
				return;
			}
			i++;
		}
		System.out.print(CLI_CLEAR);
	}

	public static void searchElementMenu(){
		System.out.print("Filtro de búsqueda: ");
		//String filter = in.nextLine();
		
	}

	public static int getValidNumber(){
		try{
			return in.nextInt();
		}
		catch (Exception e){
			return -1;
		}
	}
}