import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculadoraTest{
    
    @Test
    public void testSuma(){
        int resultado = Calculadora.suma(2, 3);
        int esperado = 5;
        assertEquals(esperado, resultado);
    }

    @Test
    public void testResta(){
        int resultado = Calculadora.resta(3, 1);
        int esperado = 2;
        assertEquals(esperado, resultado);
    }

    @Test
    public void testMultiplicacion(){
        int resultado = Calculadora.multiplicacion(2, 4);
        int esperado = 8;
        assertEquals(esperado, resultado);
    }

    @Test
    public void testDivision(){
        int resultado = Calculadora.division(4, 2);
        int esperado = 2;
        assertEquals(esperado, resultado);
    }
}