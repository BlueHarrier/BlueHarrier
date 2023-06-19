import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

public class SerialWriteTest {
    public static void main(String[] args){
        ArrayList<Alumno> alumnos = generateDefaultStudents();
        ArrayList<Profesor> profesores = generateDefaultTeachers();
        try{
            FileOutputStream fileOutput = new FileOutputStream("SerializedOutput.bin");
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
            objectOutput.writeObject(alumnos);
            objectOutput.writeObject(profesores);
            objectOutput.close();
        }catch (Exception e) {e.printStackTrace();}
    }

    public static ArrayList<Alumno> generateDefaultStudents(){
        ArrayList<Alumno> alumnos = new ArrayList<>();
        alumnos.add(new Alumno("Paco", generateRandomMarks(3)));
        alumnos.add(new Alumno("Pedro", generateRandomMarks(2)));
        alumnos.add(new Alumno("Pablo", generateRandomMarks(5)));
        return alumnos;
    }

    public static ArrayList<Integer> generateRandomMarks(int modulos){
        ArrayList<Integer> marks = new ArrayList<>();
        Random randomizer = new Random();
        for (int i = 0; i < modulos; i++){
            marks.add(randomizer.nextInt(0, 11));
        }
        return marks;
    }

    public static ArrayList <Profesor> generateDefaultTeachers(){
        ArrayList<Profesor> profesores = new ArrayList<>();
        profesores.add(new Profesor("Manolo", toArrayList(new String[]{"BBDD", "PRG"})));
        profesores.add(new Profesor("Pepito", toArrayList(new String[]{"LMSGI", "ED"})));
        profesores.add(new Profesor("Menganito", toArrayList(new String[]{"SI", "FOL"})));
        return profesores;
    }

    public static ArrayList<String> toArrayList(String[] array){
        ArrayList<String> list = new ArrayList<>();
        for (String element : array){
            list.add(element);
        }
        return list;
    }
}
