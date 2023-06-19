import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class FilesWithBufferedWriter extends FilesWriteTest{
    public static void createFile(File outputFile){
        try{
            FileWriter fileWriter = new FileWriter(outputFile);
            BufferedWriter buffWriter = new BufferedWriter(fileWriter);
            buffWriter.write(LOREM);
            buffWriter.close();
        }catch(Exception e) {e.printStackTrace();}
    }
}
