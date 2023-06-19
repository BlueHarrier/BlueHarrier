/* Gestiona internamente cada préstamo
* @author Daniel "BlueHarrier" Píriz
* @version 1.0.0
* @since 24/11/2022
*/

import java.time.LocalDate;
import java.time.Period;

public class Prestamo{
	// Atributos básicos
	public Lector lector;
	public Libro libro;
	public LocalDate fechaPrestamo;
	public LocalDate fechaDevolucion = null;
	
	/* Presta el libro a la persona indicada en la fecha concreta
	* @param Lector lector que ha cogido el libro
	* @param Libro libro que se desesa prestar
	* @param LocalDate fecha en la que se ha realizado el préstamo
	*/
	public void prestar(Lector lector, Libro libro, LocalDate fechaPrestamo){
		if (!libro.getPrestado()){
			this.lector = lector;
			this.libro = libro;
			this.fechaPrestamo = fechaPrestamo;
			libro.marcarPrestado();
		}
	}
	
	/* Devuelve el libro que se ha prestado, comprobando si el lector es moroso o no
	* @param LocalDate fecha de devolución del libro
	*/
	public void devolver(LocalDate fechaDevolucion){
		this.fechaDevolucion = fechaDevolucion;
		Period diffTiempo = Period.between(this.fechaPrestamo, this.fechaDevolucion);
		if (diffTiempo.getDays() > 15){
			lector.marcarMoroso();
		}
		libro.desmarcarPrestado();
	}
}