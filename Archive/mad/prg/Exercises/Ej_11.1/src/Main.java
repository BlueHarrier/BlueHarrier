import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args){
		String sql = "SELECT * FROM alumnos";
		ArrayList<Alumno> alumnos = new ArrayList<>();

		try (
			Connection conn = DriverManager.getConnection(SQLCredentials.createUri());
			Statement state = conn.createStatement();
			ResultSet result = state.executeQuery(sql);
		){
			while (result.next()){
				long id = result.getLong("id");
				String nombre = result.getString("nombre");
				String dni = result.getString("dni");
				String email = result.getString("email");
				String primerApe = result.getString("primerApe");
				String segundoApe = result.getString("segundoApe");
				Alumno nuevoAlumno = new Alumno(id, nombre, dni, email, primerApe, segundoApe);
				System.out.println(nuevoAlumno.toString());
				alumnos.add(nuevoAlumno);
			}
		}
		catch (Exception e) { e.printStackTrace(); }
	}
}
