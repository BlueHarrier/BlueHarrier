/**
 * Implementación de Conexion para Daniel23 en el host dbcli.luiscastelar.duckdns.org
 * @since 11/05/2023
 * @author Daniel "BlueHarrier" Píriz
 * @version 1.0.0
 */

public class MySQLConexion implements Conexion{

    // Credenciales
    private static final String USER = "Daniel23";
    private static final String PASS = "cl6Z";
	private static String IP = "dbcli.luiscastelar.duckdns.org";
	private static String PORT = "45682";
	private static String DB = "23_db_Daniel";

    /**
     * Obtener el nombre de usuario
     * @return String
     */
    static String getUser(){ return USER; };

    /**
     * Obtener el password
     * @return String
     */
    static String getPassword(){ return PASS; };

    /**
     * Obtener el FQDN del host o la ip
     * @return String con FQDN o ip
     */
    static String getHost(){ return IP; };

    /**
     * Obtener el puerto de conexión
     * @return int con el puerto de la db
     */
    static int getPort(){ return Integer.parseInt(PORT); };

    /**
     * Obtener la db
     * @return String con el nombre de la base de datos
     */
    static String getDb(){ return DB; };

    /**
     * Obtener el URI completo a la bbdd. Tendrá la forma
     * jdbc:mysql://user:pass@host:port/db
     * @return URI
     */
    static String getUri(){ 
        return 
        "jdbc:mysql://" +
        USER + ":" + PASS + "@" +
        IP + ":" +
        PORT + "/" +
        DB + 
        "?useLegacyDateTimeCode=false&serverTimezone=Europe/Madrid";
    };
}
