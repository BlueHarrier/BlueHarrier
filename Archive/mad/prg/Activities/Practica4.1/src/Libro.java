/* This book class contains all relevant book information for its usage.
* @author Daniel "BlueHarrier" Píriz
* @version 1.0.0
* @since 03/11/22
*/

public class Libro{
	
	// Book's title
	String title;
	
	// Book's author
	String author;
	
	// Total number of copies available
	int copies;
	
	// Ammount of rented copies of the book
	int rentedCopies = 0;
	
	/* The default constructor will use generic names for the title and the author, and will set the number of copies to 5. Not recomended.
	*/
	public Libro(){
		this("Lorem Ipsum", "John Doe", 5);
	}
	
	/* Custom book constructor.
	* @param String Title of the book
	* @param String Author of the book
	* @param int Total number of copies available
	*/
	public Libro(String tit, String aut, int cop){
		setTitle(tit);
		setAuthor(aut);
		setCopies(cop);
	}
	
	/* Simplified custom book constructor.
	* @param String Title of the book
	* @param int Total number of copies available
	*/
	public Libro(String tit, int cop){
		this(tit, "Unknown", cop);
	}
	
	/* Title setter.
	* @param String New title
	*/
	public void setTitle(String tit){
		title = tit;
	}
	
	/* Title getter.
	* @return String Title of the book
	*/
	public String getTitle(){
		return title;
	}
	
	/* Author setter.
	* @param String New author
	*/
	public void setAuthor(String aut){
		author = aut;
	}
	
	/* Author getter.
	* @return String Name of the author
	*/
	public String getAuthor(){
		return author;
	}
	
	/* Total copies setter, will give a console error if the number of copies is less than the rented copies.
	* @param int New number of copies
	* @return boolean True if valid number, false if invalid
	*/
	public boolean setCopies(int cop){
		if (cop >= rentedCopies && cop >= 0){
			copies = cop;
			return true;
		}
		else return false;
	}
	
	/* Total copies getter.
	* @return int Total number of copies of the book
	*/
	public int getCopies(){
		return copies;
	}
	
	/* Rented copies setter.
	* @param int New number of rented copies
	* @return boolean True if valid number, false if invalid
	*/
	public boolean setRentedCopies(int rCop){
		if (rCop <= copies && rCop >= 0){
			rentedCopies = rCop;
			return true;
		}
		else return false;
	}
	
	/* Rented copies getter.
	* @return int Number of rented copies of the book
	*/
	public int getRentedCopies(){
		return rentedCopies;
	}
	
	/* Rent another copy of the book.
	* @return boolean True if there were enough copies to rent, false if there weren't enough
	*/
	public boolean rentCopy(){
		if (copies > rentedCopies){
			rentedCopies++;
			return true;
		}
		else return false;
	}
	
	/* Decreases the rented copies counter.
	* @return boolean True if the copy was returned successfuly, false if no more copies are left to return
	*/
	public boolean returnCopy(){
		if (rentedCopies > 0){
			rentedCopies--;
			return true;
		}
		else return false;
	}
	
	/* Returns the book's attributes in a human speach string.
	* @return String Title, author, copies and number of copies available
	*/
	@Override
	public String toString(){
		// Pick up data
		String tit = getTitle();
		String aut = getAuthor();
		int cop = getCopies();
		int rCop = getRentedCopies();
		
		// Return built string
		return "\"" + tit + "\", written by " + aut + ", has " + Integer.toString(cop) + " copies, " + Integer.toString(cop - rCop) + " of which are available";
	}
}