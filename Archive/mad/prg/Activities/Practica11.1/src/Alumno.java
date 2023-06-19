import java.util.StringTokenizer;

/**
 * Clase Alumno mapeada de alumnos.csv. Es serializable.
 * @author Daniel "BlueHarrier" Píriz
 * @version 1.0.0
 * @since 16/03/2023
 */

public class Alumno{
    // Variables mapeadas de alumnos.csv
    public long id;
    public String nombre;
    public String eMail;
    public String DNI;
    public String nacimiento;

    /**
     * Constructor básico de Alumno.
     * @param String Nombre del alumno
     * @param String Correo electrónico del alumno
     * @param String DNI del alumno
     * @param String Fecha de nacimiento del alumno (Ej.: "DD/MM/AAAA")
     */
    public Alumno(long id, String nombre, String eMail, String DNI, String nacimiento){
        this.id = id;
        this.nombre = nombre;
        this.eMail = eMail;
        this.DNI = DNI;
        StringTokenizer tokenizer = new StringTokenizer(nacimiento, "/");
        if (tokenizer.countTokens() < 3){
            this.nacimiento = nacimiento;
            return;
        }
        String day = tokenizer.nextToken();
        String month = tokenizer.nextToken();
        String year = tokenizer.nextToken();
        this.nacimiento = String.format("%s-%s-%s", year, month, day);
    }

    /**
     * Convierte los atributos del objeto en un string para introducirlos en MySQL
     */
    @Override
    public String toString(){
        return String.format("('%s', '%s', '%s', '%s')", nombre, eMail, DNI, nacimiento);
    }
}
