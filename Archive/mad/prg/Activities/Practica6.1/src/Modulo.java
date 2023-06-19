/* Module class, with the information regarding the module.
* @author Daniel "BlueHarrier" Píriz
* @since 30/11/2022
* @version 2.0.0
*/

public class Modulo{
	// Object variables
	public String name;		// Name of the module
	public byte avg = 0;	// Total average of the marks of the students
	public String ansiColor;

	/* Basic module constructor.
	* @param String Name of the module
	*/
	public Modulo(String name, String ansiColor){
		this.name = name;
		this.ansiColor = ansiColor;
	}
}