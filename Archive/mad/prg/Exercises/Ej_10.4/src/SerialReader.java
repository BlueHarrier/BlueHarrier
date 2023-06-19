import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class SerialReader {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Nombre del archivo:");
        String fileName = in.next();
        final String SEPARATOR = System.getProperty("file.separator");
        String path = System.getProperty("user.dir") + SEPARATOR + fileName;
        File file = new File(path);
        try{
            FileInputStream inputStream = new FileInputStream(file);
            ObjectInputStream objectInput = new ObjectInputStream(inputStream);
            Alumno alumno = (Alumno) objectInput.readObject();
            System.out.println(alumno.toString());
            objectInput.close();
        }catch(Exception e) {e.printStackTrace();}
        in.close();
    }
}
