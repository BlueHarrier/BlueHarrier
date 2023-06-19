// Uses random generated value for testing (optional)
import java.util.Random;

import BHPrintingTools.AnsiBuilder;

// Use print writer for UTF-8 charset
import java.io.PrintWriter;
import static java.nio.charset.StandardCharsets.UTF_8;

/* Evaluacion testing class.
* @author Daniel "BlueHarrier" Píriz
* @since 30/11/2022
* @version 2.0.0
*/

public class Evaluacion{
	/* Main function.
	* @param String[] Arguments of the program
	*/
	public static void main(String[] args){
		// Modules setup
		Modulo modules[] = generateDefaultModules();
		
		// Student setup
		AlumnoCustom students[] = generateDefaultStudents();
		
		// Output setup
		PrintWriter out = new PrintWriter(System.out, true, UTF_8);
		
		// Asign random marks to the students
		Random rand = new Random();
		for (int i = 0; i < students.length; i++){
			for (int j = 0; j < modules.length; j++){
				students[i].setMark(j, (byte) rand.nextInt(10));
			}
		}
		
		// Pick modules names length and longest student name
		int nameLength[] = calculateModuleNameLength(modules);
		int longestStudent = findLongestStudentName(students);

		// Module names
		out.print(createStrikethrough(longestStudent, nameLength));
		out.print("|" + createCharStrip(' ', longestStudent));
		for (int i = 0; i < modules.length; i++){
			out.print("|" + modules[i].ansiColor + modules[i].name + AnsiBuilder.RESET);
		}
		out.print("|Total|\n");
		out.print(createStrikethrough(longestStudent, nameLength));
		
		// Students
		int[][] avgs = new int[modules.length + 1][2];	// [Module ID / total] [0: addition, 1: attendees]
		avgs[modules.length][1] = students.length;
		for (int i = 0; i < students.length; i++){
			out.print("|" + students[i].name);
			out.print(createCharStrip(' ', longestStudent - students[i].name.length()));
			for (int j = 0; j < modules.length; j++){
				byte m = students[i].getMark(j);
				String str;
				if (m > -1){
					avgs[j][0] += m;
					avgs[j][1]++;
					str = Byte.toString(m);
				}
				else str = "-";
				out.print("|" + ((str.charAt(0) == '-') ? AnsiBuilder.RESET : modules[j].ansiColor) + str + createCharStrip(' ', nameLength[j] - str.length()) + AnsiBuilder.RESET);
			}
			byte avg = students[i].calculateAverage();
			avgs[modules.length][0] += avg;
			String str = Byte.toString(avg);
			out.print("|" + str + createCharStrip(' ', 5 - str.length()) + "|\n");
		}
		out.print(createStrikethrough(longestStudent, nameLength));
		
		// Total averages
		out.print("|Media" + createCharStrip(' ', longestStudent - 5));
		for (int i = 0; i < avgs.length; i++){
			int avg = avgs[i][0] / avgs[i][1];
			String str = Integer.toString(avg);
			int len = (i < nameLength.length) ? nameLength[i] : 5;
			out.print("|" + ((i < modules.length) ? modules[i].ansiColor : AnsiBuilder.RESET) + str + createCharStrip(' ', len - str.length()) + AnsiBuilder.RESET);
		}
		out.println("|\n" + createStrikethrough(longestStudent, nameLength));
	}
	
	/* Generates an array of students with default values.
	* @return AlumnoCustom[] Predefined array of students
	*/
	public static AlumnoCustom[] generateDefaultStudents(){
		AlumnoCustom al[] = new AlumnoCustom[6];
		al[0] = new AlumnoCustom("Elton tito");
		al[1] = new AlumnoCustom("Paca gharte");
		al[2] = new AlumnoCustom("Nick Wilde");
		al[3] = new AlumnoCustom("Walter White");
		al[4] = new AlumnoCustom("Gordon Freeman");
		al[5] = new AlumnoCustom("Blue Harrier");
		
		al[0].setModules(new int[] {0, 1, 2, 3, 4, 5});
		al[1].setModules(new int[] {0, 1, 2, 3, 4, 5});
		al[2].setModules(new int[] {0, 1, 4, 5});
		al[3].setModules(new int[] {2, 3, 4, 5});
		al[4].setModules(new int[] {5});
		al[5].setModules(new int[] {0, 1, 2, 3, 4});
		
		return al;
	}
	
	/* Generate an array of modules with default values.
	* @return Modulo[] Predefined array of modules
	*/
	public static Modulo[] generateDefaultModules(){
		Modulo mod[] = new Modulo[6];
		mod[0] = new Modulo("BBDD", AnsiBuilder.RED);		// Bases de Datos					0
		mod[1] = new Modulo("PRG", AnsiBuilder.CYAN);		// Programación						1
		mod[2] = new Modulo("LMSGI", AnsiBuilder.YELLOW);	// Lenguajes de Marca				2
		mod[3] = new Modulo("ED", AnsiBuilder.GREEN);		// Entornos de Desarrollo			3
		mod[4] = new Modulo("SI", AnsiBuilder.BLUE);		// Sistemas Informáticos			4
		mod[5] = new Modulo("FOL", AnsiBuilder.PURPLE);		// Formación y Orientación Laboral	5
		return mod;
	}
	
	/* Takes the length of the module names.
	* @param  Modulo[] Input of all modules
	* @return int[] The length of each module's name
	*/
	public static int[] calculateModuleNameLength(Modulo[] modules){
		int[] len = new int[modules.length];
		for (int i = 0; i < modules.length; i++){
			len[i] = modules[i].name.length();
		}
		return len;
	}
	
	/* Obtains the longest name of the students.
	* @param AlumnoCustom[] Input of all students
	* @return int The length of the longest student's name
	*/
	public static int findLongestStudentName(AlumnoCustom[] students){
		int length = 0;
		for (int i = 0; i < students.length; i++){
			int newLength = students[i].name.length();
			if (length < newLength) length = newLength;
		}
		return length;
	}
	
	/* Creates a strip of characters given a length.
	* @param char Character to make the strip out of
	* @param int Size of the strip
	* @return String Strip of characters
	*/
	public static String createCharStrip(char c, int n){
		String str = "";
		for (int i = 0; i < n; i++){
			str += c;
		}
		return str;
	}
	
	/* Creates a full strike through based on the longes student name and the length of each module.
	* @param int Longest student's name length
	* @param int[] Size of the name of each module
	* @return String Strikethrough to print
	*/
	public static String createStrikethrough(int longestStudent, int[] nameLength){
		String str = "+" + createCharStrip('-', longestStudent);
		for (int i = 0; i < nameLength.length; i++){
			str += "+" + createCharStrip('-', nameLength[i]);
		}
		str += "+-----+\n";
		return str;
	}
}