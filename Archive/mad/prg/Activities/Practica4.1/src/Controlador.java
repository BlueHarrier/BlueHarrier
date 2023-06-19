/* This class contains a test for the book class.
* @author Daniel "BlueHarrier" Píriz
* @version 1.0.0
* @since 29/11/22
*/

public class Controlador{
	/* Main function, will test all the methods inside the book class.
	* @param String[] Parameters of the program
	*/
	public static void main(String[] args){
		// Generate default book with every constructor
		System.out.println("Testing constructors...");
		Libro book = new Libro();
		System.out.println("1st constructor: " + book.getTitle());
		book = new Libro("Harry Potter", 5);
		System.out.println("2nd constructor: " + book.getTitle());
		book = new Libro("La Vida Negociable", "Luis Landero", 10);
		System.out.println("3rd constructor: " + book.getTitle());
		System.out.println("Constructors successfully executed");
		
		// Confirm setters and getters
		System.out.println("\nTesting setters and getters...");
		book.setTitle("IT");
		System.out.println("Setted new book title: " + book.getTitle());
		book.setAuthor("Stephen King");
		System.out.println("Setted new book author: " + book.getAuthor());
		book.setCopies(5);
		System.out.println("Setted the number of copies to " + Integer.toString(book.getCopies()));
		book.setRentedCopies(4);
		System.out.println("Setted the number of rented copies to " + Integer.toString(book.getRentedCopies()));
		System.out.print("Attempting to set an invalid number of copies: ");
		boolean test = book.setCopies(3);
		if (test) System.out.println("FAIL");
		else System.out.println("OK");
		System.out.print("Attempting to set an invalid number of rented copies: ");
		test = book.setRentedCopies(6);
		if (test) System.out.println("FAIL");
		else System.out.println("OK");
		
		// Confirm rent and return methods
		System.out.println("\nTesting rent and return methods...");
		test = book.rentCopy();
		if (test) System.out.println("Book rented succesfully, number of rented copies: " + Integer.toString(book.getRentedCopies()));
		else System.out.println("Error, rentCopy() test failed");
		test = book.returnCopy();
		if (test) System.out.println("Book returned succesfully, number of rented copies: " + Integer.toString(book.getRentedCopies()));
		else System.out.println("Error, returnCopy() test failed");
		System.out.print("Attempting to rent above the limit: ");
		book.setRentedCopies(5);
		test = book.rentCopy();
		if (test) System.out.println("FAIL");
		else System.out.println("OK");
		System.out.print("Attempting to return an unexsiting book: ");
		book.setRentedCopies(0);
		book.returnCopy();
		if (test) System.out.println("FAIL");
		else System.out.println("OK");
		
		// Check toString method
		System.out.println("\nConverting to string...");
		System.out.println(book.toString());
		
		// Complete test
		System.out.println("\nTest complete");
	}
}