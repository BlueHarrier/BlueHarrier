public class MongoDBCredentials {
    private static final String USER = "root";
    private static final String PASS = "root";
	private static String IP = "localhost";
	private static String PORT = "27017";

    public static String createUri(){
        return createUri(USER, PASS);
    }

    public static String createUri(String user, String pass){
        return createUri(IP, PORT, user, pass);
    }

    public static String createUri(String ip, String port, String user, String pass){
        return String.format("mongodb://%s:%s@%s:%s", user, pass, ip, port);
    }
}
