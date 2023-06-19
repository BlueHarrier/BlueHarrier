import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class FilesWithFileReaderScanner extends FilesReadTest {
    public static void printFile(File file){
        try{
            FileReader fileReader = new FileReader(file);
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNext()){
                System.out.println(scanner.nextLine());
            }
            scanner.close();
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
