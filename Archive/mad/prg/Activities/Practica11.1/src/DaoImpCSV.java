import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * Implementación DAO para clase Alumno en archivos CSV.
 * @since 11/05/2023
 * @author Daniel "BlueHarrier" Píriz
 * @version 1.0.0
 */

public class DaoImpCSV implements DAO<Alumno> {

	private File usingFile;
	private HashMap<Long, Alumno> students;

	/**
	 * Constructor inicial de la implementación.
	 * @param File Archivo CSV para leer
	 */
	public DaoImpCSV (File file){
		this.students = new HashMap<>();
		this.usingFile = file;
		if (this.usingFile == null || !usingFile.exists()) return;
		try{
			List<String> lines = Files.readAllLines(this.usingFile.toPath());
			for(int i = 1; i < lines.size(); i++){
				StringTokenizer tokenizer = new StringTokenizer(lines.get(i), ",");
				if (tokenizer.countTokens() < 4) continue;
				String name = tokenizer.nextToken();
				String eMail = tokenizer.nextToken();
				String DNI = tokenizer.nextToken();
				String birthDate = tokenizer.nextToken();
				Alumno alumno = new Alumno(i, name, eMail, DNI, birthDate);
				this.students.put((long) i, alumno);
			}
		} catch(Exception e){ e.printStackTrace(); }
	}

    /**
     * Obtiene el elemento indicado por su id
     * @param id de tipo long
     * @return Objeto de la clase Alumno
     */
    @Override
    public Alumno getById(long id) {
		return this.students.get(id);
    }

    /**
     * Obtiene una lista con TODOS elementos de Alumno
     * @return List<Alumno>
     */
    @Override
    public List<Alumno> getAll() {
		ArrayList<Alumno> studentsList = new ArrayList<>();
		Set<Long> keys = this.students.keySet();
		for (long key : keys){
			Alumno student = this.students.get(key);
			studentsList.add(student);
		}
        return studentsList;
    }

    /**
     * Inserta un nuevo elemento Alumno
     * @param e de tipo Alumno
     * @return (tipo long) id del elemento insertado o -1 si se produjo algún error.
     */
    @Override
    public long add(Alumno e) {
        try{
			long newKey = findFreeKey();
			this.students.put(newKey, e);
			return newKey;
		}
		catch (Exception exception){
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
		try{
			List<Long> newKeys = findFreeKeySet(list.size());
			for (int i = 0; i < list.size(); i++){
				Alumno student = list.get(i);
				long key = newKeys.get(i);
				this.students.put(key, student);
			}
			return newKeys;
		}
		catch (Exception e){
			return null;
		}
    }

    /**
     * Elimina el elemnto de identificador id
     * @param id elemento a eliminar
     * @return Retorna el id del elemento eliminado, 0 si no existe y -1 si hubo error.
     */
    @Override
    public long del(long id) {
		try{
			Alumno student = this.students.get(id);
			if (student == null) return 0;
			this.students.remove(id);
			return id;
		}
		catch (Exception e){
			return -1;
		}
    }

    /**
     * Modifica el elemento e de identificador id. Si no existe debe crearse.
     * @param id long que identifica al elemnto a modificar.
     * @param e -> Elemento de tipo Alumno para modificar el que está almacenado.
     * @return Retornará 0 si se realizó correctamente, -1 si hubo un error y 1 si no existía previamente.
     */
    @Override
    public int update(long id, Alumno e) {
		try{
			Alumno student = this.students.put(id, e);
			return (student != null) ? 0 : 1;
		}
		catch (Exception exception){
			return -1;
		}

    }

	/**
	 * Encuentra una clave disponible para usar.
	 * @return long Clave disponible
	 */
	private long findFreeKey(){
		Set<Long> keys = this.students.keySet();
		long i = 1l;
		while (true){
			if (!keys.contains(i)) return i;
			i++;
		}
	}

	/**
	 * Encuentra un conjunto de clabes disponibles para usar.
	 * @param int Número de claves que se necesitan7
	 * @return List<Long> Lista con las claves solicitadas
	 */
	private List<Long> findFreeKeySet(int numberOfKeys){
		Set<Long> keys = this.students.keySet();
		ArrayList<Long> freeKeys = new ArrayList<>();
		long i = 1l;
		while (numberOfKeys > 0){
			if (!keys.contains(i)){
				freeKeys.add(i);
				numberOfKeys--;
			}
			i++;
		}
		return freeKeys;
	}
}
