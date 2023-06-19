
/**
 * Interface que abstrae la URI de conexión a la bbdd
 */
public interface Conexion {
    /**
     * Obtener el nombre de usuario
     * @return String
     */
    static String getUser(){ return ""; };

    /**
     * Obtener el password
     * @return String
     */
    static String getPassword(){ return ""; };

    /**
     * Obtener el FQDN del host o la ip
     * @return String con FQDN o ip
     */
    static String getHost(){ return ""; };

    /**
     * Obtener el puerto de conexión
     * @return int con el puerto de la db
     */
    static int getPort(){ return 0; };

    /**
     * Obtener la db
     * @return String con el nombre de la base de datos
     */
    static String getDb(){ return ""; };

    /**
     * Obtener el URI completo a la bbdd. Tendrá la forma
     * jdbc:mysql://user:pass@host:port/db
     * @return URI
     */
    static String getUri(){ return ""; };
}
