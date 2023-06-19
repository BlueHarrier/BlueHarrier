
public class Arrays{
	static String[] estudiantes = {"Roberto", "José", "Manolo", "Ububwewewe", "Benito"};
	static int [] notas = {0, 5, 4, 200000, 8};
	
	public static void main (String[] args){
		LeerEntrada in = new LeerEntrada();
		do{
			System.out.print("Inserte nombre de estudiante: ");
			String str = in.leerString();
			int est = -1;
			for (int i = 0; i < estudiantes.length; i++){
				if (estudiantes[i].equals(str)){
					est = i;
					break;
				}
			}
			
			if (est != -1){
				System.out.print("Nota del estudiante ");
				System.out.print(notas[est]);
			}
			else{
				System.out.print("Estudiante no encontrado");
			}
		}while(in.continuar());
	}
}