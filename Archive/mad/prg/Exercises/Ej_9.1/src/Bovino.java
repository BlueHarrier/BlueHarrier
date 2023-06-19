public class Bovino extends Animal implements Presa{
    
    protected int hornsSize;
    protected int agility;

    public Bovino(String name, int size, int hornsSize, int agility){
        super(name, size);
        this.hornsSize = hornsSize;
        this.agility = agility;
    }

    public void observar(String animal){
        System.out.println("Un bovino llamado " + this.name + " ha avistado a " + animal);
    }

    public void huir(String animal){
        System.out.println("Un bovino llamado " + this.name + " ha huido de " + animal);
    }
}
