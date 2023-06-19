package BHPrintingTools;
import java.io.PrintWriter;
import java.util.HashMap;
import static java.nio.charset.StandardCharsets.UTF_8;

/* Ansi builder pack.
* @author Daniel "BlueHarrier" Píriz
* @since 30/11/2022
* @version 0.0.2
*/

public class AnsiBuilder<T>{
	// Version
	public static final String VERSION = "0.0.2";
	
	// ANSI colors
	public static final String BLACK = "\u001B[30m";	// Black
	public static final String WHITE = "\u001B[37m";	// White
	public static final String RED = "\u001B[31m";		// Red
	public static final String GREEN = "\u001B[32m";	// Green
	public static final String YELLOW = "\u001B[33m";	// Yellow
	public static final String BLUE = "\u001B[34m";		// Blue
	public static final String PURPLE = "\u001B[35m";	// Purple
	public static final String CYAN = "\u001B[36m";		// Cyan
	public static final String RESET = "\u001B[0m";		// Reset

	// Tile pipes enum
	public static enum tilePipe{
		horizontal,
		vertical,
		upLeftCorner,
		upRightCorner,
		downLeftCorner,
		downRightCorner,
		leftTJoint,
		upTJoint,
		rightTJoint,
		downTJoint,
		quadJoint
	}

	// Default pipe configurations
	public static final HashMap<tilePipe, Character> PIPE_CONFIG_BASIC = new HashMap<tilePipe, Character>();
	public static final HashMap<tilePipe, Character> PIPE_CONFIG_SINGLE = new HashMap<tilePipe, Character>();
	public static final HashMap<tilePipe, Character> PIPE_CONFIG_DOUBLE = new HashMap<tilePipe, Character>();

	/* Main function. Shows the version and the author.
	* @param String[] Arguments of the program
	*/
	public static void main(String[] args){
		PrintWriter out = new PrintWriter(System.out, true, UTF_8);
		out.println("|| Ansi builder pack by " + CYAN + "BlueHarrier" + RESET);
		out.println("|| Version " + PURPLE + VERSION + RESET);
	}

	// Object attributes
	private HashMap<tilePipe, Character> tileSet;

	// Double array
	private T[][] dataArray;

	/* Default constructor (double line pipes).
	 * @param T[][] Initial data to be stored inside the builder.
	 */
	public AnsiBuilder(T[][] inputData){
		this.dataArray = inputData;
		this.tileSet = (HashMap<tilePipe, Character>) PIPE_CONFIG_DOUBLE.clone();
	}

	/* Advanced constructor.
	 * @param T[][] Initial data to be stored inside the builder.
	 * @param HashMap<tilePipe, Character> Pipe character setting.
	 */
	public AnsiBuilder(T[][] inputData, HashMap<tilePipe, Character> pipeConfig){
		this.dataArray = inputData;
		this.tileSet = pipeConfig;
	}


	public void setPipeConfig(HashMap<tilePipe, Character> pipeConfig){
		this.tileSet = pipeConfig;
		for (tilePipe segment : PIPE_CONFIG_BASIC.keySet()){
			if (this.tileSet.get(segment) == null){
				
			}
		}
		
	}
}