// Use IO file class
import java.io.File;

/* In/Out test class
 * @author Daniel "BlueHarrier" Píriz
 * @since 05/12/2022
 * @version 1.0.0
 */

public class Main {
    /* Main function. Reads and writes letters for each person.
     * @param String[] args
     */
    public static void main(String[] args) {
        // Create files
        File dest = new File("./destinatarios.csv");
        File lett = new File("./carta.txt");

        // Check wether either of the file exists or not
        if (!dest.exists()){
            System.out.println("ERROR: El archivo de destinatarios no existe");
            return;
        }
        if (!lett.exists()){
            System.out.println("ERROR: El archivo de carta no existe");
            return;
        }

        // Take destinations count
        int destCount = TrabajarArchivo.countLines(dest);

        // Letter creation
        String letterStr = TrabajarArchivo.leerArchivo(lett);
        for (int i = 1; i < destCount; i++){
            Parametros param = TrabajarArchivo.leerParametros(dest, i);
            StringBuilder outStr = new StringBuilder(letterStr);
            replaceAll(outStr, "\u0024\u0024nombre\u0024\u0024", param.getNombre());
            replaceAll(outStr, "\u0024\u0024email\u0024\u0024", param.getEmail());
            replaceAll(outStr, "\u0024\u0024oferta\u0024\u0024", param.getOferta());
            replaceAll(outStr, "\u0024\u0024saldo\u0024\u0024", param.getSaldo());
            String fName = param.getNombre() + ".txt";
            TrabajarArchivo.escribeArchivo(outStr.toString(), "./" + fName);
        }
    }

    /* Replace each substring with a new one inside a StringBuilder
     * @param StringBuilder Input and output StringBuilder
     * @param String String to replace
     * @param String Substitute string
     */
    public static void replaceAll(StringBuilder strBuilder, String from, String with){
        int index = strBuilder.indexOf(from);
        while (index != -1){
            strBuilder.replace(index, index + from.length(), with);
            index += with.length();
            index = strBuilder.indexOf(from, index);
        }
    }
}