import java.util.List;

/**
 *  Interface DAO genérica de abstracción de la tecnología de presistencia
 *
 * @author Luis Ferreira
 * @since 24 abr 2023
 */
public interface DAO<T> {

    /**
     * Obtiene el elemento indicado por su id
     * @param id de tipo long
     * @return Objeto de la clase T
     */
    public T getById(long id);

    /**
     * Obtiene una lista con TODOS elementos de T
     * @return List<T>
     */
    public List<T> getAll();

    /**
     * Inserta un nuevo elemento T
     * @param e de tipo T
     * @return (tipo long) id del elemento insertado o -1 si se produjo algún error.
     */
    public long add(T e);

    /**
     * Inserta una coleción completa de T
     * @param elementos (List<T>)
     * @return List<long> con una lista de todos los id's o -1 si se produjo error al insertar elementos. Si no hubo
     * error, pero no se insertó ninguno se devuelve una List de tamaño 0.
     */
    public List<Long> addList(List<T> list);

    /**
     * Elimina el elemnto de identificador id
     * @param id elemento a eliminar
     * @return Retorna el id del elemento eliminado, 0 si no existe y -1 si hubo error.
     */
    public long del(long id);

    /**
     * Modifica el elemento e de identificador id. Si no existe debe crearse.
     * @param id long que identifica al elemnto a modificar.
     * @param e -> Elemento de tipo T para modificar el que está almacenado.
     * @return Retornará 0 si se realizó correctamente, -1 si hubo un error y 1 si no existía previamente.
     */
    public int update(long id, T e);


}
