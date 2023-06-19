import static org.junit.Assert.assertEquals;
import org.junit.Test;

/* Test class for transformation matrices
 * @author Daniel "BlueHarrier" Píriz
 * @version 1.0.0
 * @since 10/1/23
*/

public class MatricesDeTransformacionTest{

    /* Test for 2D inverted kinematics */
    @Test
    public void testCinematicaInversa2D(){
        // Setup cases and expected results
        final int[][] CASES = {{0, 0}, {0, 10}, {10, 0}, {10, 10}, {5, 7}};
        final float[][] EXPECTED = {{0f, 0f}, {0f, 10f}, {10f, 0f}, {10f, 10f}, {5f, 7f}};

        for (int i = 0; i < CASES.length; i++){
            // Pick the original result
            float result[] = MatricesDeTransformacion.cinematicaInversa2D(CASES[i][0], CASES[i][1]);

            // Assert
            assertEquals(result[0], EXPECTED[i][0], 0.1);
            assertEquals(result[1], EXPECTED[i][1], 0.1);
        }
    }
}