import java.io.File;

public class FilesWriteMethodTester {
    public static void main(String[] args){
        FilesWithFiles.createFile(getFile("Files.txt"));
        FilesWithFileWriter.createFile(getFile("FileWriter.txt"));
        FilesWithBufferedWriter.createFile(getFile("BufferWriter.txt"));
        FilesWithFileOutputStream.createFile(getFile("FileOutputStream.txt"));
    }

    public static File getFile(String fileName){
        final String SEPARATOR = System.getProperty("file.separator");
        String path = System.getProperty("user.dir") + SEPARATOR + fileName;
        return new File(path);
    }
}
