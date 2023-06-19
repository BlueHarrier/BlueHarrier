/* Efectúa un test completo de las clases Lector, Libro y Prestamo
* @author Daniel "BlueHarrier" Píriz
* @version 1.0.0
* @since 24/11/2022
*/

import java.time.LocalDate;

public class Main{
	/* Función principal de la clases
	* @param String[] argumentos del programa
	*/
	public static void main(String[] args){
		// Generar lectores y libros de acuerdo con el enunciado
		Lector lector1 = new Lector("Ana García");
		Lector lector2 = new Lector("Roberto Sánchez");
		Libro libro1 = new Libro("El camino", "Miguel Delibes");
		Libro libro2 = new Libro("Cien años de soledad", "Gabriel García Márquez");
		Libro libro3 = new Libro("Rayuela", "Julio Cortázar");
		
		System.out.println("Lectores y libros generados correctamente.");
		System.out.println("Ejemplo: " + lector2.nombre + " es el " + Integer.toString(lector2.numero + 1) + "º lector, y " + libro3.titulo + " ha sido escrito por " + libro3.autor + " y es el número " + Integer.toString(libro3.codigo + 1) + ".");
		
		// Generar los préstamos y asignar un lector y un libro a cada uno, con fechas arbitrarias
		Prestamo prestamo1 = new Prestamo();
		Prestamo prestamo2 = new Prestamo();
		Prestamo prestamo3 = new Prestamo();
		
		prestamo1.prestar(lector1, libro1, LocalDate.of(2023, 1, 1));
		prestamo2.prestar(lector1, libro2, LocalDate.of(2023, 1, 5));
		prestamo3.prestar(lector2, libro3, LocalDate.of(2023, 1, 2));
		
		System.out.println("Prestamos generados.");
		System.out.println("Ejemplo: " + prestamo1.lector.nombre + " ha tomado el libro " + prestamo1.libro.titulo + " en la fecha " + prestamo1.fechaPrestamo + ".");
		
		// Comprobar que es imposible prestar un libro que ya se ha prestado
		prestamo1.prestar(lector2, libro1, LocalDate.of(2023, 1, 3));
		if (prestamo1.lector != lector2){
			System.out.println("El libro no fue prestado de nuevo.");
		}
		else{
			System.out.println("El libro fue prestado de nuevo.");
		}
		
		// Comprobar si el lector ha resultado moroso tras un mes
		prestamo2.devolver(LocalDate.of(2023, 2, 1));
		if (prestamo2.lector.getMoroso()){
			System.out.println(prestamo2.lector.nombre + " es moroso.");
		}
		else{
			System.out.println(prestamo2.lector.nombre + " no es moroso.");
		}
	}
}