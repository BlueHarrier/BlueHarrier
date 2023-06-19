/* Conserva datos de lectores
* @author Daniel "BlueHarrier" Píriz
* @version 1.0.0
* @since 24/11/2022
*/

public class Lector{
	// Número total de lectores generados
	public static int totalLectores;
	
	// Atributos básicos de un lector
	public int numero;
	public String nombre;
	private boolean moroso = false;
	
	/* Constructor de la clase
	* @param String nombre
	*/
	public Lector(String nombre){
		this.nombre = nombre;
		numero = totalLectores;
		totalLectores++;
	}
	
	/* Marca al lector como moroso
	*/
	public void marcarMoroso(){
		moroso = true;
	}
	
	/* Devuelve si un lector es moroso
	* @return boolean devuelve si el lector es moroso
	*/
	public boolean getMoroso(){
		return moroso;
	}
}