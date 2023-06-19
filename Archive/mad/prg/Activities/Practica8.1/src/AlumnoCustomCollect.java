import java.util.HashMap;

/* Student class, manages data about the modules and marks per module.
* @author Daniel "BlueHarrier" Píriz
* @since 19/01/2023
* @version 1.0.0
*/

public class AlumnoCustomCollect{
	// Object variables
	public String name;						// Student name
	private HashMap<String, Integer> marks;	// Student marks
	
	/* Standard student constructor.
	* @param String Name of the student
	*/
	public AlumnoCustomCollect(String name){
		this.name = name;
		this.marks = new HashMap<String, Integer>();
	}
	
	/* Module name setter.
	* @param String[] Names of all the modules to set up
	*/
	public void setModules(String[] moduleNames){
		for (String module : moduleNames){
			this.marks.put(module, 0);
		}
	}

	/* Module mark setter.
	* @param String Name of the module
	* @param int Mark to write
	*/
	public void setMark(String moduleName, int mark){
		if (this.marks.get(moduleName) != null){
			this.marks.put(moduleName, mark);
		}
	}
	
	/* Module mark getter.
	* @param String name of the module to  check.
	*/
	public int getMark(String moduleName){
		Integer mark = marks.get(moduleName);
		return (mark != null) ? mark : -1;
	}
	
	/* Calculates the average of all the marks of the student.
	* @return int The average of the marks of the student
	*/
	public int calculateAverage(){
		int avg = 0;
		for (int mark : this.marks.values()){
			avg += mark;
		}
		return (int) (avg / this.marks.size());
	}
}