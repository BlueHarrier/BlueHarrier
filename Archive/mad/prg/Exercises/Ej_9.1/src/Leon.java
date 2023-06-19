public class Leon extends Felino{
    
    protected LionPattern furPattern;
    protected int maneSize;

    enum LionPattern{
        flat,
        strips,
    }

    public Leon(String name, LionPattern furPattern, int maneSize){
        super(name, 120, 100, 38);
        this.furPattern = furPattern;
        this.maneSize = maneSize;
    }

    @Override
    public void cazar(String animal){
        System.out.println("El león " + this.name + " ha cazado a " + animal + ".");
    }

    @Override
    public void perseguir(String animal){
        System.out.println("El león " + this.name + " persigue a " + animal + ".");
    }
}
