public class Gacela extends Bovino {
    
    protected GazellaPattern furPattern;
    protected int hornsCurve;

    enum GazellaPattern{
        flat,
        black,
        mixed
    }

    public Gacela(String name, GazellaPattern furPattern, int hornsCurve){
        super(name, 75, 30, 75);
        this.furPattern = furPattern;
        this.hornsCurve = hornsCurve;
    }

    @Override
    public void observar(String animal){
        System.out.println("La gacela " + this.name + " ha avistado a " + animal);
    }

    @Override
    public void huir(String animal){
        System.out.println("La gacela " + this.name + " ha huido de " + animal);
    }
}
