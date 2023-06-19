import java.util.List;
import java.util.Iterator;

public class ListTesting {
    public static void main(String args[]){
        // Crear la lista
        List<Integer> newList = List.of(1, 2, 3, 4, 5, 6, 7);

        // Ejercicio 1
        System.out.println("Ejercicio 1");
        {
            Iterator iterator = newList.iterator();
            while (iterator.hasNext()){
                System.out.println(iterator.next());
            }
        }

        // Ejercicio 2
        System.out.println("Ejercicio 2");
        for (int n : newList){
            System.out.println(n);
        }

        // Ejercicio 3
        System.out.println("Ejercicio 3");
        newList.forEach(i -> System.out.println(i));

        // Ejercicio 4
        System.out.println("Ejercicio 4");
        newList.forEach(System.out::println);
    }
}
