import java.util.*;

public class Radares{
	static class Report{
		int length;
		int maxSpeed;
		int time;
		
		public String generate(){
			float kmLength = (float)length / 1000.0f;
			float hourTime = (float)time / 3600.0f;
			if (maxSpeed <= 0 || kmLength <= 0 || hourTime <= 0){
				return "ERROR";
			}
			int avarageSpeed = (int)(kmLength / hourTime);
			if (avarageSpeed < maxSpeed){
				return "OK";
			}else if (avarageSpeed < maxSpeed + maxSpeed / 5){
				return "MULTA";
			}else return "PUNTOS";
		}
		
		public boolean isNull(){
			return (length == 0 && maxSpeed == 0 && time == 0);
		}
	}
	
	static int getNumber(String str, byte pos){
		String tmp = "";
		byte count = 0;
		for (int i = 0; i < str.length(); i++){
			char c = str.charAt(i);
			if (c == ' '){
				if (count == pos){
					return Integer.parseInt(tmp);
				}
				else{
					count++;
					tmp = "";
				}
			}
			else tmp += c;
		}
		return Integer.parseInt(tmp);
	}
	
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		Report report = new Report();
		String[] results = {null};
		int n = 0;
		while (true){
			String input = scanner.nextLine();
			report.length = getNumber(input, (byte)0);
			report.maxSpeed = getNumber(input, (byte)1);
			report.time = getNumber(input, (byte)2);
			if (report.isNull()) break;
			else{
				n++;
				results = Arrays.copyOf(results, n);
				results[n - 1] = report.generate();
			}
		}
		for (int i = 0; i < n; i++){
			System.out.println(results[i]);
		}
	}
}

