/* Netflix ripoff testing class.
* @author Daniel "BlueHarrier" Píriz
* @version 1.0.1
* @since 7/11/2022
*/

public class ExT4{
	/* Performs a complete test of the classes 'Serie' and 'Posicion'.
	* @param String[] Application parameters
	*/
	public static void main (String args[]){
		// 1st series
		Posicion pos1 = new Posicion(3, 2, 15);
		Serie serieTheWire = new Serie("The Wire", 5, 10, pos1);
		
		// 2nd series (manual setup)
		Posicion pos2 = new Posicion();
		pos2.setSeason(4);
		pos2.setChapter(6);
		pos2.setPosition(27);
		Serie serieITCrew = new Serie("IT Crew", 4, 6, pos2);
		
		// Output results
		System.out.println(serieTheWire.toString());
		System.out.println(serieITCrew.toString());
	}
}