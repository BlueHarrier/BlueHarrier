import java.io.File;
import java.nio.file.Files;
import java.util.List;

public class ArchivoDaoImp implements ArchivoDao{
    /* Transfiere todas las líneas de un archivo introducido a String.
    * @param String Ruta del archivo
    * @return String String con la información de dicho archivo
     */
    public String getAll(String pathToFile){
        File file = new File(pathToFile);
        try {
            List<String> lines = Files.readAllLines(file.toPath());
            StringBuilder output = new StringBuilder();
            for (String line : lines){
                output.append(line + "\n");
            }
            return output.toString();
        }catch (Exception e) {e.printStackTrace();}
        return null;
    }

    /* Escribe un String en un archivo.
    * @param String Ruta del archivo
    * @param String Texto a escribir
    * @return int Número de caracteres escritos
     */
    public int writeAll(String pathToFile, String text){
        File file = new File(pathToFile);
        try{
            Files.writeString(file.toPath(), text);
            return text.length();
        }catch (Exception e) {e.printStackTrace();}
        return -1;
    }
}
