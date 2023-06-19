import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestEvaluacion {

    // Setup the default values of the CSV file
    static final String MODULES[] = {"BBDD", "PRG", "ED", "LMSGI", "SI", "FOL"};
    static final String STUDENTS[] = {"Juan", "Bartolo", "Manuel"};
    static final float MARKS[][] = {
        {3f,5f,2f,5f,5f,7f},
        {-1f,-1f,2f,3f,4f,5f},
        {10f,9f,8f,7f,-1f,-1f}
    };

    // Setup precalculated averages
    static final float STUDENT_AVGS[] = {4.5f, 3.5f, 8.5f};
    static final float MODULE_AVGS[] = {6.5f, 7f, 4f, 5f, 4.5f, 6f};

    // Filepath
    static final String FILE_PATH = "C:\\Users\\daw1\\Documents\\DAW-PRG-BBDD\\programacion\\Practica6.1\\tests\\test.csv";

    // Test of all the student's marks
    @Test
    public void testListarNotaAlumno(){
        EvaluacionResultados classTest = new EvaluacionResultados(FILE_PATH);
        for (int i = 0; i < MARKS.length; i++){
            float marks[] = classTest.listarNotaAlumno(STUDENTS[i]);
            for (int j = 0; j < MARKS[i].length; j++){
                assertEquals(marks[j], MARKS[i][j], 0.1);
            }
        }
    }

    // Test of all the modules's marks
    @Test
    public void testListarNotaModulo(){
        EvaluacionResultados classTest = new EvaluacionResultados(FILE_PATH);
        for (int i = 0; i < MODULES.length; i++){
            float marks[] = classTest.listarNotasModulos(MODULES[i]);
            for (int j = 0; j < STUDENTS.length; j++){
                assertEquals(marks[j], MARKS[j][i], 0.1);
            }
        }
    }

    // Test of the average of each student
    @Test
    public void testMediaAlumno(){
        EvaluacionResultados classTest = new EvaluacionResultados(FILE_PATH);
        for (int i = 0; i < STUDENTS.length; i++){
            float avg = classTest.mediaAlumno(STUDENTS[i]);
            assertEquals(avg, STUDENT_AVGS[i], 0.1);
        }
    }

    // Test of the average of each module
    @Test
    public void testMediaModulo(){
        EvaluacionResultados classTest = new EvaluacionResultados(FILE_PATH);
        for (int i = 0; i < MODULES.length; i++){
            float avg = classTest.mediaModulo(MODULES[i]);
            assertEquals(avg, MODULE_AVGS[i], 0.1);
        }
    }
}
