/* Conserva los datos de cada libro
* @author Daniel "BlueHarrier" Píriz
* @version 1.0.0
* @since 24/11/2022
*/

public class Libro{
	// Número total de libros generados
	public static int totalLibros;
	
	// Atributos básicos de un libro
	public int codigo;
	public String titulo;
	public String autor;
	private boolean prestado = false;
	
	/* Constructor básico de la clase
	* @param String titulo del libro
	* @param String autor del libro
	*/
	public Libro(String titulo, String autor){
		this.titulo = titulo;
		this.autor = autor;
		codigo = totalLibros;
		totalLibros++;
	}
	
	/* Marca que el libro se ha prestado
	*/
	public void marcarPrestado(){
		prestado = true;
	}
	
	/* Marca que el libro se ha devuelto
	*/
	public void desmarcarPrestado(){
		prestado = false;
	}
	
	/* Devuelve si un libro está prestado
	* @return boolean libro prestado
	*/
	public boolean getPrestado(){
		return prestado;
	}
}