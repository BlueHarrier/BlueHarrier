/* Module class, with the information regarding the module.
* @author Daniel "BlueHarrier" Píriz
* @since 19/01/2023
* @version 1.0.0
*/

public class ModuloCollect{
	// Object variables
	public String name;			// Name of the module
	public byte avg = 0;		// Total average of the marks of the students
	public String ansiColor;	// Color of the representation

	/* Basic module constructor.
	* @param String Name of the module
	*/
	public ModuloCollect(String name, String ansiColor){
		this.name = name;
		this.ansiColor = ansiColor;
	}
}