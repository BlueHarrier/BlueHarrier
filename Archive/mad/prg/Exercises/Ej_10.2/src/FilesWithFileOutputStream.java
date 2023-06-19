import java.io.File;
import java.io.FileOutputStream;

public class FilesWithFileOutputStream extends FilesWriteTest{
    public static void createFile(File outputFile){
        try{
            FileOutputStream outputStream = new FileOutputStream(outputFile);
            for (int i = 0; i < LOREM.length(); i++){
                int charVal = (int)LOREM.charAt(i);
                outputStream.write(charVal);
            }
            outputStream.close();
        }catch(Exception e) {e.printStackTrace();}
    }
}
