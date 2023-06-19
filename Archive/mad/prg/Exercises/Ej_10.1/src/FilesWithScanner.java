import java.util.Scanner;
import java.io.File;

public class FilesWithScanner extends FilesReadTest {
    public static void printFile(File file) {
        try{
            Scanner fileStream = new Scanner(file);
            while (fileStream.hasNextLine()){
                System.out.println(fileStream.nextLine());
            }
            fileStream.close();
        } catch (Exception e) {e.printStackTrace();}  
    }

    public static void tryFiles(File utf8, File ansii){
        System.out.println("UTF-8:");
        printFile(utf8);
        System.out.println("\n------------------------\n");
        System.out.println("ANSII:");
        printFile(ansii);
    }
}
