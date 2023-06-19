import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Implementación DAO para clase Alumnos en MySQL / MariaDB
 * @since 11/05/2023
 * @author Daniel "BlueHarrier" Píriz
 * @version 1.0.0
 */

public class DaoImpMariaDB implements DAO<Alumno> {

	private Connection SQLConnection;

	/**
	 * Constructor de conexión utilizando parámetros por separado
	 * @param String Nomnre de usuario
	 * @param String Contraseña
	 * @param String Nombre de la base de datos
	 * @param String Dirección IP
	 * @param String Puerto
	 * @param String Argumentos de conexión
	 * @throws SQLException
	 */
	public DaoImpMariaDB(String user, String pass, String database, String ip, String port, String args) throws SQLException{
		this(
			"jdbc:mariadb://" +
			user + ":" + pass + "@" +
			ip + ":" +
			port + "/" +
			database + 
			"?" + args
		);
	}

	/**
	 * Constructor de conexión usando URI.
	 * @param String Uri
	 * @throws SQLException
	 */
	public DaoImpMariaDB(String uri) throws SQLException{
		SQLConnection = DriverManager.getConnection(uri);
	}

    /**
     * Obtiene el elemento indicado por su id
     * @param id de tipo long
     * @return Objeto de la clase Alumno
     */
    @Override
    public Alumno getById(long id) {
		String sql = "SELECT nombre, email, dni, fNacimiento FROM alumnos WHERE id = ?;";
		try{
			PreparedStatement statement = SQLConnection.prepareStatement(sql);
			statement.setLong(1, id);
			ResultSet result = statement.executeQuery();
			if (!result.next()) return null;
			String name = result.getString("nombre");
			String eMail = result.getString("email");
			String DNI = result.getString("dni");
			String birthDate = result.getString("fNacimiento");
			return new Alumno(id, name, eMail, DNI, birthDate);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }

    /**
     * Obtiene una lista con TODOS elementos de Alumno
     * @return List<Alumno>
     */
    @Override
    public List<Alumno> getAll() {
		String sql = "SELECT id, nombre, email, dni, fNacimiento FROM alumnos;";
		try{
			PreparedStatement statement = SQLConnection.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			ArrayList<Alumno> students = new ArrayList<>();
			while (result.next()) {
                long id  = result.getLong("id");
				String name = result.getString("nombre");
				String eMail = result.getString("email");
				String DNI = result.getString("dni");
				String birthDate = result.getString("fNacimiento");
				Alumno student = new Alumno(id, name, eMail, DNI, birthDate);
				students.add(student);
			}
			return students;
		}
		catch (Exception e) {
			return null;
		}
    }

    /**
     * Inserta un nuevo elemento Alumno
     * @param e de tipo Alumno
     * @return (tipo long) id del elemento insertado o -1 si se produjo algún error.
     */
    @Override
    public long add(Alumno student) {
        if (student == null) return -1l;
        StringBuilder sql = new StringBuilder("INSERT INTO alumnos (nombre, email, dni, fNacimiento) VALUES ");
		sql.append(student.toString() + ";");
		try{
			PreparedStatement statement = SQLConnection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			statement.executeUpdate();
			ResultSet result = statement.getGeneratedKeys();
			result.next();
			long nextId = result.getLong(1);
			return nextId;
		} catch (Exception exception) {
			return -1l;
		}
    }

    /**
     * Inserta una coleción completa de Alumno
     * @param elementos (List<Alumno>)
     * @return List<long> con una lista de todos los id's o -1 si se produjo error al insertar elementos. Si no hubo
     * error, pero no se insertó ninguno se devuelve una List de tamaño 0.
     */
    @Override
    public List<Long> addList(List<Alumno> list) {
        if (list == null || list.isEmpty()) return new ArrayList<>();
        StringBuilder sql = new StringBuilder("INSERT INTO alumnos (nombre, email, dni, fNacimiento) VALUES ");
		for (Alumno student : list){
			sql.append(student.toString() + ",");
		}
		String sqlString = sql.substring(0, sql.length() - 1) + ';';
		ArrayList<Long> nextIds = new ArrayList<>();
		try{
			PreparedStatement statement = SQLConnection.prepareStatement(sqlString, Statement.RETURN_GENERATED_KEYS);
			statement.executeUpdate();
			ResultSet result = statement.getGeneratedKeys();
			while (result.next()){
				nextIds.add(result.getLong(1));
			}
		} catch (Exception exception) {
			// No hace nada
			exception.printStackTrace();
		}
		return nextIds;
    }

    /**
     * Elimina el elemnto de identificador id
     * @param id elemento a eliminar
     * @return Retorna el id del elemento eliminado, 0 si no existe y -1 si hubo error.
     */
    @Override
    public long del(long id) {
        String sql = "DELETE FROM alumnos WHERE id = ?;";
		try{
			PreparedStatement statement = SQLConnection.prepareStatement(sql);
			statement.setLong(1, id);
			statement.executeUpdate();
			return id;
		} catch (Exception exception) {
			exception.printStackTrace();
			return -1l;
		}
    }

    /**
     * Modifica el elemento e de identificador id. Si no existe debe crearse.
     * @param id long que identifica al elemnto a modificar.
     * @param e -> Elemento de tipo Alumno para modificar el que está almacenado.
     * @return Retornará 0 si se realizó correctamente, -1 si hubo un error y 1 si no existía previamente.
     */
    @Override
    public int update(long id, Alumno student) {
		Alumno existence = getById(id);
		if (existence == null){
			add(student);
			return 1;
		}
		
        String sql = "UPDATE alumnos SET ("+
			"nombre = " + student.nombre + ", " +
			"email = " + student.eMail + ", " +
			"dni = " + student.DNI + ", " +
			"fNacimiento = " + student.nacimiento +
		") WHERE id = ?;";
		try{
			PreparedStatement statement = SQLConnection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setLong(1, id);
			statement.executeUpdate();
			return 0;
		} catch (Exception exception) {
			return -1;
		}
    }
}
