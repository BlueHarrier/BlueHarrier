import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* Implementación básica de DAOObjectManager utilizando ArrayList para guardar los alumnos.
 * @author Daniel "BlueHarrier" Píriz
 * @version 1.0.0
 * @since 27/03/2023
 */

public class DAOObjectManagerImpl implements DAOObjectManager {

    // ArrayList para guardar alumnos
    public ArrayList<Alumno> alumnos = null;

    /* Lee los alumnos guardados desde un archivo CSV especificado.
     * NOTA: la primera lína de un csv normalmente son los nombres de las tablas y debe ser ignorarada.
     * @param File Archivo CSV para leer
     */
    public void readAlumnosCSV(File file){
        this.alumnos = new ArrayList<>();
        try{
            List<String> lines = Files.readAllLines(file.toPath());
            // Se salta la línea 0 (nombres de las columnas)
            for (int i = 1; i < lines.size(); i++){
                String line = lines.get(i);
                StringTokenizer tokenizer = new StringTokenizer(line, ",");
                String name = tokenizer.nextToken();
                String eMail = tokenizer.nextToken();
                String DNI = tokenizer.nextToken();
                String birthDate = tokenizer.nextToken();
                Alumno alumno = new Alumno(name, eMail, DNI, birthDate);
                this.alumnos.add(alumno);
            }
        }
        catch (Exception e) { e.printStackTrace(); }
    } 

    /* Escribe los alumnos guardados en un archivo serializado (Ej.: .bin, .serialize...).
     * @param File Ruta del archivo binario a escribir
     */
    public void writeAlumnoSerialized(File file) {
        try{
            FileOutputStream fileOutput = new FileOutputStream(file);
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
            objectOutput.writeObject(this.alumnos);
            objectOutput.close();
        }
        catch(Exception e) { e.printStackTrace(); }
    }

    /* Lee alumnos de un archivo serializado (Ej.: .bin, .serialize...).
     * @param File Archivo serializado para leer
     */
    public void readAlumnoSerialized(File file) {
        this.alumnos = new ArrayList<>();
        try{
            FileInputStream fileInput = new FileInputStream(file);
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);
            this.alumnos = (ArrayList<Alumno>) objectInput.readObject();
            objectInput.close();
        }
        catch(Exception e) { e.printStackTrace(); }
    }
}
