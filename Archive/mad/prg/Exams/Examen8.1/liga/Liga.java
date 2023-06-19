import java.util.HashMap;

/* Objeto de liga de canicas.
 * @author Daniel "BlueHarrier" Píriz
 * @version 1.0.0
 * @since 13/02/2023
 */

public class Liga {
    // Declaración de variables.
    private String nombre;
    private HashMap<Equipo, HashMap<Equipo, Partido>> partidos;

    /* Constructor básico de liga.
     * @param String Nombre de la liga
     */
    public Liga(String nombre){
        this.nombre = nombre;
        this.partidos = new HashMap<Equipo, HashMap<Equipo, Partido>>();
    }

    /* Setter de nombre de liga.
     * @param String Nuevo nombre
     */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    /* Getter de nombre de liga.
     * @return String Nombre de la liga
     */
    public String getNombre(){
        return this.nombre;
    }

    /* Setter de fecha de partido concreto.
     * @param Equipo Equipo local
     * @param Equipo Equipo visitante
     * @param String Fecha del partido
     */
    public void setFechaPartido(Equipo local, Equipo visitante, String fecha){
        getPartido(local, visitante).setFecha(fecha);
    }

    /* Setter de resultado de partido.
     * @param Equipo Equipo local
     * @param Equipo Equipo visitante
     * @param int Puntuación del equipo local
     * @param int Puntuación del equipo visitante
     */
    public void setResultadoPartido(Equipo local, Equipo visitante, int golesLocal, int golesVisitante){
        getPartido(local, visitante).setGoles(golesLocal, golesVisitante);
    }

    /* Getter de partido
     * @param Equipo Equipo local
     * @param Equipo Equipo visitante
     * @return Partido Partido solicitado
     */
    public Partido getPartido(Equipo local, Equipo visitante){
        return partidos.get(local).get(visitante);
    }

    /* Getter de partido
     * @param Equipo Equipo local
     * @param Equipo Equipo visitante
     * @return Equipo ganador del partido solicitado
     */
    public Equipo getGanador(Equipo local, Equipo visitante){
        int[] goles = getPartido(local, visitante).getGoles();
        if (goles[0] > goles[1]) return local;
        if (goles[0] < goles[1]) return visitante;
        return null;
    }
}
