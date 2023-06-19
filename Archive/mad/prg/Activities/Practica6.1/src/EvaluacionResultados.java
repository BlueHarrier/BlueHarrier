import java.io.File;

/* Evaluation class for modules and students.
 * @author Daniel "BlueHarrier" Píriz
 * @version 1.0.0
 * @since 16/1/2023
*/

public class EvaluacionResultados{
    
    // Private module names and students
    private String moduleNames[];
    private Alumno students[];

    /* Basic constructor.
     * @param String Name of the CSV file to take the data from
     */
    public EvaluacionResultados(String fileName){
        File file = new File(fileName);
        this.moduleNames = TrabajarArchivo.leerModulos(file);
        int studentNumber = TrabajarArchivo.countLines(file) - 1;
        if (studentNumber < 0) studentNumber = 0;
        this.students = new Alumno[studentNumber];
        for (int i = 0; i < studentNumber; i++){
            this.students[i] = TrabajarArchivo.leerAlumno(file, i);
        }
    }

    /* Returns all the marks of the given student.
     * @param String Student name
     * @return float[] Array with all the marks of the student
     */
    public float[] listarNotaAlumno(String alumno){
        Alumno student = null;
        for (Alumno st : this.students){
            if (st.getNombre().equals(alumno)){
                student = st;
                break;
            }
        }
        float marks[] = student.getNotas();
        return marks;
    }

    /* Returns all the marks for each student in the given module.
     * @param String Module name
     * @return float[] Array with all the marks of each student in the module
     */
    public float[] listarNotasModulos(String moduleName){
        int moduleID = 0;
        for (int i = 0; i < this.moduleNames.length; i++){
            if (this.moduleNames[i].equals(moduleName)){
                moduleID = i;
                break;
            }
        }
        float[] marks = new float[this.students.length];
        for (int i = 0; i < this.students.length; i++){
            marks[i] = this.students[i].getNota(moduleID);
        }
        return marks;
    }

    /* Calculates the average of the marks of a given student.
     * @param String Student name
     * @return float Average of the student
     */
    public float mediaAlumno(String student){
        float[] marks = listarNotaAlumno(student);
        return averageMarks(marks);
    }

    /* Calculates the average of the marks of the whole class for a given module.
     * @param String Module name
     * @return float Average of the module
     */
    public float mediaModulo(String module){
        float[] marks = listarNotasModulos(module);
        return averageMarks(marks);
    }

    /* Calculates an average of given marks array, considering -1 as not signed up.
     * @param float[] Marks array
     * @return float Average of the marks
     */
    private float averageMarks (float marks[]){
        int count = 0;
        float avg = 0;
        for (float mark : marks){
            if (mark > -1){
                avg += mark;
                count++;
            }
        }
        return avg / count;
    }
}