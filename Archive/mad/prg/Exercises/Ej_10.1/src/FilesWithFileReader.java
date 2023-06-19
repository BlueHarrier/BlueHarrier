import java.io.File;
import java.io.FileReader;

public class FilesWithFileReader extends FilesReadTest {
    public static void printFile(File file){
        try{
            FileReader fileReader = new FileReader(file);
            int read = fileReader.read();
            while (read != -1){
                System.out.print((char)read);
                read = fileReader.read();
            }
            fileReader.close();
            System.out.print("\n");
        }catch (Exception e) {e.printStackTrace();}
    }

    public static void tryFiles(File utf8, File ansii){
        System.out.println("UTF-8:");
        printFile(utf8);
        System.out.println("\n------------------------\n");
        System.out.println("ANSII:");
        printFile(ansii);
    }
}
