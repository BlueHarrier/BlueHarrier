/* Student class, manages data about the modules and marks per module.
* @author Daniel "BlueHarrier" Píriz
* @since 30/11/2022
* @version 2.0.0
*/

public class AlumnoCustom{
	// Object variables
	public String name;			// Student name
	private byte marks[];		// Student marks per module
	private int moduleIDs[];	// Student module IDs that the student signed up for
	
	/* Standard student constructor.
	* @param String Name of the student
	*/
	public AlumnoCustom(String name){
		this.name = name;
	}
	
	/* Student module setup method.
	* @param int[] Array with the IDs of the modules
	*/
	public void setModules(int[] moduleIDs){
		this.moduleIDs = moduleIDs;
		this.marks = new byte[moduleIDs.length];
		for (int i = 0; i < this.marks.length; i++){
			this.marks[i] = 0;
		}
	}
	
	/* Module mark setter.
	* @param int ID of the module to set the mark of
	* @param byte New mark of the specified module
	*/
	public void setMark(int moduleID, byte m){
		for (int i = 0; i < this.moduleIDs.length; i++){
			if (this.moduleIDs[i] == moduleID){
				this.marks[i] = m;
				return;
			}
		}
	}
	
	/* Module mark getter.
	* @param int ID of the module to check the mark of
	* @return byte The mark of the given module ID or -1 if the student didn't sign up for it
	*/
	public byte getMark(int moduleID){
		for (int i = 0; i < this.moduleIDs.length; i++){
			if (this.moduleIDs[i] == moduleID) return this.marks[i];
		}
		return -1;
	}
	
	/* Calculates the average of all the marks of the student.
	* @return byte The average of the marks of the student
	*/
	public byte calculateAverage(){
		int avg = 0;
		for (byte m : this.marks){
			avg += m;
		}
		return (byte) (avg / this.marks.length);
	}
}