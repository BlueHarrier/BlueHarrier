import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Controla el proceso especificado para la práctica 11
 * @since 11/05/2023
 * @author Daniel "BlueHarrier" Píriz
 * @version 1.0.0
 */

public class Controlador{

	static Scanner in  = new Scanner(System.in);
	static DaoImpMariaDB database;
	static final String DISPLAY_CLEAR = "\033[H\033[2J"; // Caracter clear
	
	/**
	 * Método principal del programa
	 * @param Argumentos
	 */
	public static void main(String[] args){
		boolean quit = false;
		do{
			displayClear();
			List<Alumno> studentsFromCsv = askForFile();
			askForStudentsUpload(studentsFromCsv);
			askForStudentsDelete();
			displayClear();
			System.out.println("¿Salir del programa? Y/N");
			String line = in.nextLine();
			char c = line.toLowerCase().charAt(0);
			quit = (c == 'y');
		} while(!quit);
		displayClear();
	}

	/**
	 * Pregunta por el archivo CSV a leer
	 * @return Lista con los alumnos obtenidos
	 */
	private static List<Alumno> askForFile(){
		File csvFile = getValidFile();

		DaoImpCSV csvObject = new DaoImpCSV(csvFile);
		return csvObject.getAll();
	}

	/**
	 * El segundo apartado no era un requerimiento para la actividad
	 * @throws Exception
	 */
	private static void askForStudentsUpdate() throws Exception{
		throw new Exception("Función no implementada");
	}

	/**
	 * Toma el archivo CSV, pregunta qué alumnos se desean añadir y se añaden a la base de datos
	 * @param studentsFromCsv Salida de askForFile()
	 */
	private static void askForStudentsUpload(List<Alumno> studentsFromCsv){
		displayClear();
		System.out.println("Introduzca los números de los alumnos que desea añadir o no añadir a la base de datos separados por espacios.");
		boolean[] selected = selectStudents(studentsFromCsv);
		ArrayList<Alumno> students = new ArrayList<>();
		for (int i = 0; i < studentsFromCsv.size(); i++){
			if (selected[i]) students.add(studentsFromCsv.get(i));
		}

		try{
			displayClear();
			String uri = MySQLConexion.getUri();
			System.out.println("Conectando a base de datos...");
			if (database == null) database = new DaoImpMariaDB(uri);
		}
		catch (Exception e){
			System.out.println("Se ha producido un error:");
			e.printStackTrace();
			System.out.print("\nPulse cualquier tecla para finalizar");
			in.nextLine();
			return;
		}

		displayClear();
		List<Long> ids = database.addList(students);
		System.out.print("Ids generadas: ");
		for (int i = 0; i < ids.size(); i++){
			System.out.print(ids.get(i));
			if (i < ids.size() - 1) System.out.print(", ");
		}
		System.out.print("\n");
	}

	/**
	 * Pregunta qué alumnos se desean eliminar de la base de datos
	 */
	private static void askForStudentsDelete(){
		List<Alumno> dbStudents = database.getAll();
		System.out.println("Introduzca los números de los alumnos que desea eliminar o no separados por espacios.");
		boolean[] selected = selectStudents(dbStudents);
		for (int i = 0; i < dbStudents.size(); i++){
			if (selected[i]) database.del(dbStudents.get(i).id);
		}
	}
	
	/**
	 * Pregunta y recoge un archivo válido de la entrada.
	 * @return Un archivo existente
	 */
	private static File getValidFile(){
		File file = null;
		do{
			System.out.print("Introduzca la ruta del archivo: ");
			String path = in.nextLine();
			file = new File(path);
			displayClear();
			if (!file.exists()) System.out.println("El archivo especificado no existe");
		}
		while (!file.exists());
		return file;
	}

	/**
	 * Ejecuta el menú de selección de alumnos.
	 * @param alumnos Lista con los datos de todos los alumnos
	 * @return Array de booleanos con los alumnos que se han seleccionado
	 */
	private static boolean[] selectStudents(List<Alumno> students){
		boolean[] selected = new boolean[students.size()];
		while (true){
			System.out.println("Escriba \"ALL\" para seleccionarlos todos, \"NONE\" para deseleccionarlos todos o \"CONTINUE\" para continuar.");
			printAllSelectedStudents(students, selected);

			String line = in.nextLine();
			if (line.equals("CONTINUE")) break;
			if (line.equals("ALL")){
				selectAll(selected);
				displayClear();
				continue;
			}
			if (line.equals("NONE")){
				deselectAll(selected);
				displayClear();
				continue;
			}

			StringTokenizer tokenizer = new StringTokenizer(line, " ");
			while (tokenizer.hasMoreTokens()){
				try{
					int id = Integer.parseInt(tokenizer.nextToken()) - 1;
					selected[id] = !selected[id];
				}
				catch (Exception e) { /*No hace nada */ }
			}
			displayClear();
		}
		return selected;
	}

	/**
	 * Imprime por pantalla los datos de todos los alumnos.
	 * @param alumnos Lista con todos los alumnos
	 * @param selected Array de booleanos con los alumnos seleccionados
	 */
	private static void printAllSelectedStudents(List<Alumno> students, boolean[] selected){
		for (int i = 0; i < students.size(); i++){
			System.out.print(i + 1);
			System.out.print(". ");
			if (selected[i]) System.out.print("[x]");
			else System.out.print("[ ]");
			Alumno student = students.get(i);
			System.out.print(student.nombre + ", ");
			System.out.print(student.eMail + "\n");
		}
	}

	/**
	 * Coloca todos los elementos de una array booleana a verdadero.
	 * @param array Array de booleanos
	 */
	private static void selectAll(boolean[] array){
		for (int i = 0; i < array.length; i++){
			array[i] = true;
		}
	}

	/**
	 * Coloca todos los elementos de una array booleana a falso.
	 * @param array Array de booleanos
	 */
	private static void deselectAll(boolean[] array){
		for (int i = 0; i < array.length; i++){
			array[i] = false;
		}
	}

	/**
	 * Limpia la consola
	 */
	private static void displayClear(){
		System.out.println(DISPLAY_CLEAR);
	}
}