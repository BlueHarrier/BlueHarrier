import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import org.junit.Test;

/* Tests unitarios para DAOObjectManagerTestImpl.
 * INCLUIR ARCHIVOS:
 *  - ./alumnos.csv
 *  - ./alumnosSerializados.serialize
 * @author Daniel "BlueHarrier" Píriz
 * @version 1.0.0
 * @since 27/03/2023
 */

public class DAOObjectManagerTest {

    // Datos de muestra, idénticos a ./alumnos.csv
    final static int DATA_ROWS = 2;
    final static String[] NAMES = {"Juan", "Pedro"};
    final static String[] EMAILS = {"juan@miemail.es", "pedro.gonzalez@mi.email.es"};
    final static String[] IDS = {"12345678a", "23456789b"};
    final static String[] BIRTH_DATES = {"25/1/2000", "1/10/2005"};

    /* (Test) Comprueba la funcionalidad de lectura de archivos csv.
     */
    @Test
    public void csvReadTest(){
        DAOObjectManagerImpl DAOObject = new DAOObjectManagerImpl();
        File CSVFile = getLocalFile("alumnos.csv");
        DAOObject.readAlumnosCSV(CSVFile);
        assertStudents(DAOObject.alumnos);
    }

    /* (Test) Comprueba la funcionalidad de la lectura de archivos serializados.
     */
    @Test
    public void serialReadTest(){
        DAOObjectManagerImpl DAOObject = new DAOObjectManagerImpl();
        File binFile = getLocalFile("alumnosSerializados.serialize");
        DAOObject.readAlumnoSerialized(binFile);
        assertStudents(DAOObject.alumnos);
    }

    /* (Test) Comprueba la funcionalidad de la escritura de archivos serializados.
     */
    @Test
    public void serialWriteTest(){
        ArrayList<Alumno> students;
        DAOObjectManagerImpl DAOObject = new DAOObjectManagerImpl();
        String path = System.getProperty("java.io.tmpdir") + "alumnosSerializados.serialize";
        File binFile = new File(path);
        DAOObject.alumnos = fillTestArrayList();
        DAOObject.writeAlumnoSerialized(binFile);
        students = readTempSerialized(binFile);
        assertStudents(students);
    }

    /* Lee un archivo serializado de alumnos temporal.
     * @param File Ruta del archivo serializado temporal
     * @return ArrayList<Alumno> Lista cargada con los alumnos del archivo
     */
    private ArrayList<Alumno> readTempSerialized(File binFile){
        ArrayList<Alumno> students = new ArrayList<Alumno>();
        try{
            FileInputStream fileInput = new FileInputStream(binFile);
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);
            students = (ArrayList<Alumno>) objectInput.readObject();
            objectInput.close();
        }
        catch(Exception e) { e.printStackTrace(); }
        return students;
    }

    /* Comprueba la validez de la ArrayList de alumnos recibida.
     * @param ArrayList<Alumno> Lista de alumnos para comprobar
     */
    private void assertStudents(ArrayList<Alumno> students){
        assertEquals(DATA_ROWS, students.size());
        for (int i = 0; i < students.size(); i++){
            Alumno student = students.get(i);
            assertEquals(NAMES[i], student.nombre);
            assertEquals(EMAILS[i], student.eMail);
            assertEquals(IDS[i], student.DNI);
            assertEquals(BIRTH_DATES[i], student.nacimiento);
        }
    }

    /* Toma un archivo concreto como recurso local.
     * @param String Nombre del archivo
     * @return File Objeto File listo para su uso
     */
    private File getLocalFile(String fileName){
        String path = this.getClass().getResource(fileName).getPath();
        return new File(path);
    }

    /* Rellena una ArrayList de muestra para realizar pruebas de escritura.
     */
    private ArrayList<Alumno> fillTestArrayList(){
        ArrayList<Alumno> students = new ArrayList<>();
        for (int i = 0; i < DATA_ROWS; i++){
            Alumno student = new Alumno(NAMES[i], EMAILS[i], IDS[i], BIRTH_DATES[i]);
            students.add(student);
        }
        return students;
    }
}
