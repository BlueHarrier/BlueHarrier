public class SQLCredentials {
    private static final String USER = "Daniel23";
    private static final String PASS = "cl6Z";
	private static String IP = "dbcli.luiscastelar.duckdns.org";
	private static String PORT = "45682";
	private static String DB = "23_db_Daniel";


    public static String createUri(){
        return createUri(USER, PASS);
    }

    public static String createUri(String user, String pass){
        return createUri(IP, PORT, DB, user, pass);
    }

    public static String createUri(String ip, String port, String db, String user, String pass){
        return 
        "jdbc:mysql://" +
        user + ":" + pass + "@" +
        ip + ":" +
        port + "/" +
        db + 
        "?useLegacyDateTimeCode=false&serverTimezone=Europe/Madrid";
    }

}
