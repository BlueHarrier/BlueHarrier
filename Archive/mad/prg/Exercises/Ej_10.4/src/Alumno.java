import java.io.Serializable;

public class Alumno implements Serializable{
    private static final long serialVersionUID = 1234;
    public String nombre;
    public int nota;

    public Alumno(String nombre, int nota){
        this.nombre = nombre;
        this.nota = nota;
    }

    @Override
    public String toString(){
        return nombre + "," + Integer.toString(nota);
    }
}
