import java.util.HashMap;
import java.util.HashSet;

public class examen2aEvaluacion {

    // Mapa de la actividad 3
    private static HashMap<String, HashSet<String>> studentsSkips = new HashMap<String, HashSet<String>>();


    public static void main(String[] args){
        // Para probar los métodos

        System.out.println("Ejercicio 1:\n...................");
        char[][] matrizEntrada = {{'1', 'c', 'a'},
                {'a', '2', '1'},
                {'a', '2', 'c'}};
        int[][] matrizSalida;

        matrizSalida = obtenerEnteros(matrizEntrada);

        for (int[] fila: matrizSalida) {
            for (int celda: fila) {
                System.out.print(" "+celda+" ");
            }
            System.out.println();
        }


        System.out.println("\n\n\nEjercicio 2:\n...................");
        String textoEnClaro = "¿Como llevo el examen? ... chrf cnerpr dhr inf OVRA.";

        System.out.println( rot13(textoEnClaro) );



        System.out.println("\n\n\nEjercicio 3:\n...................");
        System.out.println( "Lleva: " + registrarFalta("Luis", "12-03-2023") + " faltas.");
        System.out.println( "Lleva: " + registrarFalta("Luis", "13-03-2023") + " faltas.");
        System.out.println( "Lleva: " + registrarFalta("Luis", "14-03-2023") + " faltas.");
        System.out.println( "Lleva: " + registrarFalta("Pedro", "12-03-2023") + " faltas.");

        System.out.println( mostrarFaltas("Luis") + " y " + mostrarFaltas("Pedro"));



        System.out.println("\n\n\nEjercicio 4:\n...................");
        String texto = "Esto esta bien escrito y leído.\nAdios.";
        ArchivoDaoImp deArchivos = new ArchivoDaoImp();

        deArchivos.writeAll("archivoEscrito.txt", texto);

        System.out.println( deArchivos.getAll("archivoEscrito.txt") );

    }


    /* Devuelve una array de dos dimensiones con los números de la array de char de entrada.
    * @param char[][] Array de char de entrada
    * @return int[][] Números que contiene la anterior array ó 0.
     */
    public static int[][] obtenerEnteros(char[][] inputArray){
        int[][] intOnlyArray = new int[inputArray.length][];
        for (int i = 0; i < inputArray.length; i ++){
            intOnlyArray[i] = new int[inputArray[i].length];
            for (int j = 0; j < inputArray[i].length; j++){
                // Inversión explicada en la hoja de examen y README.md
                int parsedChar = ((int) inputArray[i][j]) - 48;
                if (parsedChar >= 0 && parsedChar <= 9) intOnlyArray[i][j] = parsedChar;
            }
        }
        return intOnlyArray;
    }

    /* Rota 13 posiciones las letras del alfabeto.
    * @param String Cadena de entrada
    * @return String Cadena de salida rotada
    */
    public static String rot13(String stringToRot){
        StringBuilder rotatedString = new StringBuilder();
        for (int i = 0; i < stringToRot.length(); i++){
            char nextChar = stringToRot.charAt(i);
            if (Character.isLetter(nextChar)){
                boolean upperCase = Character.isUpperCase(nextChar);
                int charValue = (int) nextChar;
                charValue -= upperCase ? 65 : 97;
                charValue += 13;
                charValue %= 26;
                charValue += upperCase ? 65 : 97;
                char charToLoad = (char) charValue;
                rotatedString.append(charToLoad);
            }
            else rotatedString.append(nextChar);
        }
        return rotatedString.toString();
    }

    /* Registra una falta en la lista de faltas por alumno.
    * @param String Nombre del alumno
    * @param String Fecha de la falta
    * @return int Número de faltas que tiene el alumno
     */
    public static int registrarFalta (String name, String date){
        HashSet<String> skippedDays = studentsSkips.get(name);
        if (skippedDays == null){
            skippedDays = new HashSet<String>();
            skippedDays.add(date);
            studentsSkips.put(name, skippedDays);
        }
        else skippedDays.add(date);
        return skippedDays.size();
    }

    /* Muestra el número de faltas que tiene un alumno en formato humano.
    * @param String Nombre del alumno
    * @return String Lista de lectura humana con las faltas del alumno
     */
    public static String mostrarFaltas(String name){
        HashSet<String> skippedDays = studentsSkips.get(name);
        if (skippedDays == null) return "El alumno indicado no existe";
        StringBuilder skips = new StringBuilder(name + " ha faltado los siguientes días:\n");
        for (String date : skippedDays){
            skips.append(date + "\n");
        }
        return skips.toString();
    }
}