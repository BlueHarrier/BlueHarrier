import java.io.File;

public class FilesReadMethodTester {
    public static void main(String args[]){
        final File FILE_UTF8 = getFile("text_UTF-8.txt");
        final File FILE_ANSII = getFile("text_ANSII.txt");
        System.out.println("Scanner\n");
        FilesWithScanner.tryFiles(FILE_UTF8, FILE_ANSII);
        System.out.println("\n========================\n");
        System.out.println("FileReader\n");
        FilesWithFileReader.tryFiles(FILE_UTF8, FILE_ANSII);
        System.out.println("\n========================\n");
        System.out.println("FileReader + Scanner\n");
        FilesWithFileReaderScanner.tryFiles(FILE_UTF8, FILE_ANSII);
        System.out.println("\n========================\n");
        System.out.println("BufferedReader\n");
        FilesWithBufferedReader.tryFiles(FILE_UTF8, FILE_ANSII);
        System.out.println("\n========================\n");
        System.out.println("Files\n");
        FilesWithFiles.tryFiles(FILE_UTF8, FILE_ANSII);
    }

    public static File getFile(String fileName){
        final String SEPARATOR = System.getProperty("file.separator");
        String path = System.getProperty("user.dir") + SEPARATOR + fileName;
        return new File(path);
    }
}
