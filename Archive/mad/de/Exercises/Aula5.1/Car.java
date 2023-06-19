public class Car extends Vehicle {

    public static final int WHEELS = 4;
    public float wheelSteer = 0f;

    public float power;
    public int[] color;

    public Car (float power, int[] color){
        this.power = power;
        this.color = color;
    }
}
