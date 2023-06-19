import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Serializator {
    public static void main(String[] args){
        Alumno alumno = new Alumno("Manulo", 8);
        final String SEPARATOR = System.getProperty("file.separator");
        String path = System.getProperty("user.dir") + SEPARATOR + "alumno.bin";
        File file = new File(path);
        try{
            FileOutputStream outputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutput = new ObjectOutputStream(outputStream);
            objectOutput.writeObject(alumno);;
        }catch (Exception e) {e.printStackTrace();}
    }
}
