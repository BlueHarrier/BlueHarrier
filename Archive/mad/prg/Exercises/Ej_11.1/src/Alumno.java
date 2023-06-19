public class Alumno{
	private long id;
	private String nombre;
	private String dni;
	private String email;
	private String primerApe;
	private String segundoApe;

	public Alumno(long id, String nombre, String dni, String email, String primerApe, String segundoApe){
		this.id = id;
		this.nombre = nombre;
		this.dni = dni;
		this.email = email;
		this.primerApe = primerApe;
		this.segundoApe = segundoApe;
	}

	public Alumno(long id, String nombre, String dni, String email, String primerApe){
		this(id, nombre, dni, email, primerApe, null);
	}

	@Override
	public String toString(){
		return id + ": " + nombre + " " + primerApe + (segundoApe != null ? " " + segundoApe : "") + " | " + dni + " | " + email;
	}
}