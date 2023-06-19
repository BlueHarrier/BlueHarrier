import java.io.Serializable;
import java.util.ArrayList;

public class Alumno implements Serializable {
    public String nombre;
    public ArrayList<Integer> notas;

    public Alumno(String nombre, ArrayList<Integer> notas){
        this.nombre = nombre;
        this.notas = notas;
    }
}