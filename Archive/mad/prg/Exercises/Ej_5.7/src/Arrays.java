
public class Arrays{
	static String[][] estudiantes = {{"Roberto", "0"}, {"José", "5"}, {"Manolo", "4"}, {"Ububwewewe", "200000"}, {"Benito", "8"}};
	
	public static void main (String[] args){
		LeerEntrada in = new LeerEntrada();
		do{
			System.out.print("Inserte nombre de estudiante: ");
			String str = in.leerString();
			int est = -1;
			for (int i = 0; i < estudiantes.length; i++){
				if (estudiantes[i][0].equals(str)){
					est = i;
					break;
				}
			}
			
			if (est != -1){
				System.out.print("Nota del estudiante " + estudiantes[est][1]);
			}
			else{
				System.out.print("Estudiante no encontrado");
			}
		}while(in.continuar());
	}
}