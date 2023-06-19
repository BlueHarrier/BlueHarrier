public class Felino extends Animal implements Depredador{
    
    protected int roarReach;
    protected int clawSize;

    public Felino(String name, int size, int roarReach, int clawSize){
        super(name, size);
        this.roarReach = roarReach;
        this.clawSize = clawSize;
    }

    public void cazar(String animal){
        System.out.println("Un felino llamado " + this.name + " ha cazado a " + animal + ".");
    }

    public void perseguir(String animal){
        System.out.println("Un felino llamado " + this.name + " persigue a " + animal + ".");
    }
}
