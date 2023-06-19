public class Main {
	public static void main(String[] args){
		Box<Integer> intBox = new Box<>();
		intBox.set(20);
		Box<Float> floatBox = new Box<>();
		floatBox.set(100.2f);
		System.out.println(intBox.get());
		System.out.println(floatBox.get());
	}
}
