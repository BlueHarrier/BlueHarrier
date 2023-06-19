import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		try (
			Connection conn = DriverManager.getConnection(SQLCredentials.createUri());
            Scanner in = new Scanner(System.in);
		){
            System.out.println("Introduzca el nombre a buscar");
            String nombre = in.nextLine();
            Alumno alumno = getAlumnoByName(conn, nombre);
            if (alumno != null) System.out.println(alumno.toString() + "\n");

            System.out.println("Introduzca la ID a buscar");
            int id = in.nextInt();
            alumno = getAlumnoById(conn, id);
            if (alumno != null) System.out.println(alumno.toString() + "\n");
		}
		catch (Exception e) { e.printStackTrace(); }
	}

    public static Alumno getAlumnoByName(Connection conn, String name){
        String sql = "SELECT * FROM alumnos WHERE nombre = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            ResultSet result = statement.executeQuery();
            if (!result.next()) return null;
            long id = result.getLong("id");
            String nombre = name;
            String dni = result.getString("dni");
            String email = result.getString("email");
            String primerApe = result.getString("primerApe");
            String segundoApe = result.getString("segundoApe");
            return new Alumno(id, nombre, dni, email, primerApe, segundoApe);
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }

    public static Alumno getAlumnoById(Connection conn, long id){
        String sql = "SELECT * FROM alumnos WHERE id = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet result = statement.executeQuery();
            if (!result.next()) return null;
            String nombre = result.getString("nombre");
            String dni = result.getString("dni");
            String email = result.getString("email");
            String primerApe = result.getString("primerApe");
            String segundoApe = result.getString("segundoApe");
            return new Alumno(id, nombre, dni, email, primerApe, segundoApe);
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }
}
