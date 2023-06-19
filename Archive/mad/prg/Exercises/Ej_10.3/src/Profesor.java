import java.io.Serializable;
import java.util.ArrayList;

public class Profesor implements Serializable {
    public String nombre;
    public ArrayList<String> asignaturas;

    public Profesor(String nombre, ArrayList<String> asignaturas){
        this.nombre = nombre;
        this.asignaturas = asignaturas;
    }
}