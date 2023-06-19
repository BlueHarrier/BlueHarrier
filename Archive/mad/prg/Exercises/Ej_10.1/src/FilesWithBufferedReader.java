import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FilesWithBufferedReader extends FilesReadTest{
    public static void printFile(File file) {
        try{
            FileReader fileReader = new FileReader(file);
            BufferedReader buffReader = new BufferedReader(fileReader);
            String line = buffReader.readLine();
            while(line != null){
                System.out.println(line);
                line = buffReader.readLine();
            }
            buffReader.close();
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
