/* Objeto de partido de canicas.
 * @author Daniel "BlueHarrier" Píriz
 * @version 1.0.0
 * @since 13/02/2023
 */

public class Partido {

    // Declaración de variables.
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private int golesLocal;
    private int golesVisitante;
    private String fecha;

    /* Constructor básico de partido.
     * @param Equipo Equipo local
     * @param Equipo Equipo visitante
     */
    public Partido(Equipo local, Equipo visitante){
        this.equipoLocal = local;
        this.equipoVisitante = visitante;
        this.golesLocal = 0;
        this.golesVisitante = 0;
        this.fecha = null;
    }

    /* Setter de fecha del partido.
     * @param String Nueva fecha
     */
    public void setFecha(String fecha){
        this.fecha = fecha;
    }

    /* Getter de fecha del poartido.
     * @return String Fecha
     */
    public String getFecha(){
        return this.fecha;
    }

    /* Fija los goles (puntos) de ambos equipos y añade su puntuación.
     * @param int Goles del equipo local
     * @param int Goles del equipo visitante
     */
    public void setGoles(int local, int visitante){
        this.golesLocal = local;
        this.golesVisitante = visitante;
        if (local > visitante){
            this.equipoLocal.anadirPuntos(1);
            return;
        }
        if (local < visitante) this.equipoVisitante.anadirPuntos(1);
    }

    /* Getter de goles en array.
     * @return int[] Array de dos dimensiones con los goles locales y visitantes
     */
    public int[] getGoles(){
        return new int[]{this.golesLocal, this.golesVisitante};
    }
}
