/* Netflix ripoff position state.
* @author Daniel "BlueHarrier" Piriz
* @version 1.0.0
* @since 7/11/2022
*/

public class Posicion{
	// General position state variables (all private as they must be accessed through setters and getters)
	private int season;		// Current season of the viewer
	private int chapter;	// Current chapter of the viewer
	private int position;	// Timestamp in minutes of the viewer
	
	/* Default constructor, will call the full one with default parameters.
	*/
	public Posicion(){
		this(1, 1, 0);
	}
	
	/* Full constructor, will receive all parameters.
	* @param int Current season of the viewer (greater than 0)
	* @param int Current chapter of the viewer (greater than 0)
	* @param int Timestamp in minutes of the viewer (at least 0)
	*/
	public Posicion(int sea, int chap, int pos){
		this.season = sea > 0 ? sea : 1;
		this.chapter = chap > 0 ? chap : 1;
		this.position = pos >= 0 ? pos : 0;
	}
	
	/* Season setter. Must be greater than 0.
	* @param int New season
	*/
	public void setSeason(int sea){
		if (sea > 0) this.season = sea;
	}
	/* Season getter.
	* @return int The season where the viewer is at
	*/
	public int getSeason(){
		return this.season;
	}
	
	/* Chapter setter. Must be greater than 0.
	* @param int New chapter
	*/
	public void setChapter(int chap){
		if (chapter > 0) this.chapter = chap;
	}
	/* Chapter getter.
	* @return int The chapter where the viewer is at
	*/
	public int getChapter(){
		return this.chapter;
	}
	
	/* Timestamp setter. Must be at least 0.
	* @param int New time position
	*/
	public void setPosition(int pos){
		if (pos >= 0) this.position = pos;
	}
	/* Timestamp getter.
	* @return int The minute where the viewer is at
	*/
	public int getPosition(){
		return this.position;
	}
	
	/* Returns a string form of the position's parameters.
	* @return String The string form of the position's parameters
	*/
	@Override
	public String toString(){
		// Build the string
		String str = "season " + Integer.toString(this.season);
		str += ", chapter " + Integer.toString(this.chapter);
		str += ", currently on minute " + Integer.toString(this.position);
		
		// Returns
		// "season <season>, chapter <chapter>, currently on minute <position>"
		return str;
	}
}