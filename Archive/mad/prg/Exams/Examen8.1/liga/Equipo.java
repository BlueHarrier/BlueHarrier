/* Objeto de equipo.
 * @author Daniel "BlueHarrier" Píriz
 * @version 1.0.0
 * @since 13/02/2023
 */

public class Equipo {
    
    // Declaración de variables.
    private String nombre;
    private int puntuacion;
    
    /* Constructor básico de equipo.
     * @param String Nombre del equipo
     */
    public Equipo(String nombre){
        this.nombre = nombre;
        this.puntuacion = 0;
    }

    /* Añadir puntos al equipo.
     * @param int Puntos a añadir
     */
    public void anadirPuntos(int puntos){
        this.puntuacion += puntos;
    }

    /* Setter de puntuación.
     * @param int Nueva puntuación
     */
    public void setPuntos(int puntos){
        this.puntuacion = puntos;
    }

    /* Getter de puntuación.
     * @return int Puntuación.
     */
    public int getPuntos(){
        return this.puntuacion;
    }

    /* Setter de nombre.
     * @param String Nuevo nombre
     */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    /* Getter de nombre.
     * @return String Nombre del equipo
     */
    public String getNombre(){
        return this.nombre;
    }
}
