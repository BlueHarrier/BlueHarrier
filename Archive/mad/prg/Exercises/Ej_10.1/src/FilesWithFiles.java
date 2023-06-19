import java.io.File;
import java.nio.file.Files;
import java.util.List;

public class FilesWithFiles extends FilesReadTest{
    public static void printFile(File file) {
        try{
            List<String> lines = Files.readAllLines(file.toPath());
            for (String line : lines){
                System.out.println(line);
            }
        }catch(Exception e){e.printStackTrace();}
    }

    public static void tryFiles(File utf8, File ansii){
        System.out.println("UTF-8:");
        printFile(utf8);
        System.out.println("\n------------------------\n");
        System.out.println("ANSII:");
        printFile(ansii);
    }
}