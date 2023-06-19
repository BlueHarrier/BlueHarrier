import java.io.File;

/* Interfaz de control de carga de archivos CSV y archivos serializados.
 * IMPORTANTE: requiere una array o una colección de clase para guardar los datos.
 * @author Daniel "BlueHarrier" Píriz
 * @version 1.0.0
 * @since 24/03/2023
 */

public interface DAOObjectManager {
    /* Lee los alumnos guardados desde un archivo CSV especificado.
     * NOTA: la primera lína de un csv normalmente son los nombres de las tablas y debe ser ignorarada.
     * @param File Archivo CSV para leer
     */
    public void readAlumnosCSV(File file);

    /* Escribe los alumnos guardados en un archivo serializado (Ej.: .bin, .serialize...).
     * @param File Ruta del archivo binario a escribir
     */
    public void writeAlumnoSerialized(File file);

    /* Lee alumnos de un archivo serializado (Ej.: .bin, .serialize...).
     * @param File Archivo serializado para leer
     */
    public void readAlumnoSerialized(File file);
}
