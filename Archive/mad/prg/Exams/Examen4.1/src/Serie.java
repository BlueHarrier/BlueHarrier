/* Netflix ripoff series.
* @author Daniel "BlueHarrier" Piriz
* @version 1.0.1
* @since 7/11/2022
*/

public class Serie{
	// General series variables (public as they have no setters / getters)
	public String name;		// Name of the series
	public int seasons;		// Seasons of the series
	public int chapters;	// Chapters of each season
	public Posicion state;	// Position state of the viewer
	
	/* Full series constructor.
	* @param String Name of the series
	* @param int Seasons of the series
	* @param int Chapters of each season
	* @param Posicion Position state of the viewer
	*/
	public Serie(String nm, int seas, int chaps, Posicion st){
		this.name = nm;
		this.seasons = seas;
		this.chapters = chaps;
		this.state = st;
	}
	
	/* Returns the string form of the series parameters.
	* @return String The string form of the series parameters.
	*/
	@Override
	public String toString(){
		// Build the string
		String str = "\"" + this.name + "\"";
		str += " has " + Integer.toString(seasons) + " seasons";
		str += ", with " + Integer.toString(chapters) + " chapters each.";
		str += "\nCurrent state of the series: " + state.toString() + ".";
		
		// Returns
		// "'<name>' has <seasons> seasons, with <chapters> chapters each."
		// "Current state of the series: <state string form>."
		return str;
	}
}