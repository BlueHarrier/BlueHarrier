import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class FilesWithFiles extends FilesWriteTest{
    public static void createFile(File outputFile){
        try{
            Path path = outputFile.toPath();
            Files.writeString(path, LOREM);
        }catch(Exception e){e.printStackTrace();}
    }
}
