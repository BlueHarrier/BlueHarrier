import java.io.Serializable;

/* Clase Alumno mapeada de alumnos.csv. Es serializable.
 * @author Daniel "BlueHarrier" Píriz
 * @version 1.0.0
 * @since 16/03/2023
 */

public class Alumno implements Serializable{
    // Variables mapeadas de alumnos.csv
    public String nombre;
    public String eMail;
    public String DNI;
    public String nacimiento;

    /* Constructor básico de Alumno.
     * @param String Nombre del alumno
     * @param String Correo electrónico del alumno
     * @param String DNI del alumno
     * @param String Fecha de nacimiento del alumno (Ej.: "DD/MM/AAAA")
     */
    public Alumno(String nombre, String eMail, String DNI, String nacimiento){
        this.nombre = nombre;
        this.eMail = eMail;
        this.DNI = DNI;
        this.nacimiento = nacimiento;
    }
}
