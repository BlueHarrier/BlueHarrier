import java.util.HashMap;
import java.util.HashSet;

/* Singleton de equipos.
 * @author Daniel "BlueHarrier" Píriz
 * @version 1.0.0
 * @since 13/02/2023
 */

public class Equipos{
    // HashSet de equipos (sin repeticiones).
    private static HashSet<Equipo> equipos = new HashSet<Equipo>();

    /* Añade nuevo equipos.
     * @param Equipo Equipo a añadir
     */
    public static void anadirEquipo(Equipo equipo){
        equipos.add(equipo);
    }

    /* Elimina un equipo del set.
     * @param Equipo Equipo a eliminar
     */
    public static void quitarEquipo(Equipo equipo){
        equipos.remove(equipo);
    }

    /* Agrupa a los equipos para competir.
     * @return HashMap<Equipo, HashMap<Equipo, Partido>> Agrupación de equipos en forma de HashMap doble
     */
    public static HashMap<Equipo, HashMap<Equipo, Partido>> agrupar(){
        HashMap<Equipo, HashMap<Equipo, Partido>> partidos = new HashMap<Equipo, HashMap<Equipo, Partido>>();
        for(Equipo local : equipos){
            HashMap<Equipo, Partido> partidosLocales = new HashMap<Equipo, Partido>();
            for (Equipo visitante : equipos){
                if (visitante == local) continue;
                Partido partido = new Partido(local, visitante);
                partidosLocales.put(visitante, partido);
            }
            partidos.put(local, partidosLocales);
        }
        return partidos;
    }
}