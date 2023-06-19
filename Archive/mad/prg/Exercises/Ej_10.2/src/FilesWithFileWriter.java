import java.io.File;
import java.io.FileWriter;

public class FilesWithFileWriter extends FilesWriteTest{
    public static void createFile(File outputFile){
        try{
            FileWriter fileWriter = new FileWriter(outputFile);
            fileWriter.append(LOREM);
            fileWriter.close();
        }catch(Exception e) {e.printStackTrace();}
    }
}
