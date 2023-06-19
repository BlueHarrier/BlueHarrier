// Import File, Files, List and StringTokenizer
import java.io.File;
import java.nio.file.Files;
import java.util.List;
import java.util.StringTokenizer;

/* Class that helps you work over files for this specific practice.
 * @author Daniel "BlueHarrier" Píriz
 * @since 01/03/2023
 * @version 1.0.0
 */
public class TrabajarArchivo {
    
    // Tokenizer delimiter
    private static final String DELIMITER = ",";

    /* Reads the modules name from a given file.
     * @param File File to read from
     * @return String[] String array of the names
     */
    public static String[] leerModulos(File file){
        try{
            List<String> lines = Files.readAllLines(file.toPath());
            StringTokenizer tokenizer = new StringTokenizer(lines.get(0), DELIMITER);
            String[] names = new String[tokenizer.countTokens()];
            int i = 0;
            while (tokenizer.hasMoreTokens()){
                names[i] = tokenizer.nextToken();
                i++;
            }
            return names;
        }
        catch (Exception e){e.printStackTrace();}
        return null;
    }

    /* Count the lines of a given file.
     * @param File File to read from
     * @return int Number of lines of the file
     */
    public static int countLines(File file){
        try{
            List<String> lines = Files.readAllLines(file.toPath());
            return lines.size();
        }
        catch (Exception e){e.printStackTrace();}
        return -1;
    }

    /* Reads the name and marks of a given student.
     * @param File File to read from
     * @return Alumno The full Alumno object
     */
    public static Alumno leerAlumno(File file, int student){
        try{
            List<String> lines = Files.readAllLines(file.toPath());
            StringTokenizer tokenizer = new StringTokenizer(lines.get(student + 1), DELIMITER);
            String name = tokenizer.nextToken();
            int marksNumber = tokenizer.countTokens();
            float[] marks = new float[marksNumber];
            for (int i = 0; i < marksNumber; i++){
                marks[i] = Float.parseFloat(tokenizer.nextToken());
            }
            return new Alumno(name, marks);
        }
        catch (Exception e){e.printStackTrace();}
        return null;
    }
}
