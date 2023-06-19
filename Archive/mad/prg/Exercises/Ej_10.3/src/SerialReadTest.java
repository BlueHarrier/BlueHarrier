import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class SerialReadTest {
    public static void main(String[] args){
        System.out.println("Orden correcto");
        try{
            FileInputStream fileInput= new FileInputStream("SerializedOutput.bin");
            ObjectInputStream objectInput= new ObjectInputStream(fileInput);
            ArrayList<Alumno> alumnos = (ArrayList<Alumno>) objectInput.readObject();
            ArrayList<Profesor> profesores = (ArrayList<Profesor>) objectInput.readObject();
            System.out.print("Alumnos: ");
            printAlumnos(alumnos);
            System.out.print("\nProfesores: ");
            printProfesores(profesores);
            objectInput.close();
        }catch (Exception e) {e.printStackTrace();}

        System.out.println("Orden inverso");
        try{
            FileInputStream fileInput= new FileInputStream("SerializedOutput.bin");
            ObjectInputStream objectInput= new ObjectInputStream(fileInput);
            ArrayList<Profesor> profesores = (ArrayList<Profesor>) objectInput.readObject();
            ArrayList<Alumno> alumnos = (ArrayList<Alumno>) objectInput.readObject();
            System.out.print("Profesores: ");
            printProfesores(profesores);
            System.out.print("\nAlumnos: ");
            printAlumnos(alumnos);
            objectInput.close();
        }catch (Exception e) {e.printStackTrace();}
    }

    public static void printAlumnos(ArrayList<Alumno> alumnos){
        for (Alumno alumno : alumnos){
            System.out.print("\t" + alumno.nombre);
            for (int nota : alumno.notas){
                System.out.print(", ");
                System.out.print(nota);
            }
        }
    }

    public static void printProfesores(ArrayList<Profesor> profesores){
        for (Profesor profesor : profesores){
            System.out.print("\t" + profesor.nombre);
            for (String asignatura : profesor.asignaturas){
                System.out.print(", " + asignatura);
            }
        }
    }
}
