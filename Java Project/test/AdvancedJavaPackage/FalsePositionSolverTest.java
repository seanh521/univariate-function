/**
 * @author Sean Harrington
 * unless specified otherwise
 */

package AdvancedJavaPackage;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FalsePositionSolverTest extends FalsePositionSolver{

    /**
     * Test for the solve function
     * @throws IllegalArgumentException checks for any arguments that would break the implemented function
     */
    @Test
    void testSolve() throws IllegalArgumentException{
        double result = solve(2.0, 5.0);
        assertTrue(result >= 2.0 && result <= 2.1);
    }

    /**
     * Test for the solve function
     * @throws IllegalArgumentException checks for any arguments that would break the implemented function
     */
    @Test
    void testFunctionf()throws IllegalArgumentException{
        double root = f(2.0);
        assertEquals(2.0 - 2.5 * Math.sin(2.0) * Math.sin(2.0), root);
    }

    /**
     * Test for the solve function
     * @throws IllegalArgumentException checks for any arguments that would break the implemented function
     */
    @Test
    void testException() throws IllegalArgumentException{
        try{
            solve(2.0, 2.0);
            fail("Expected exception");
        }catch(IllegalArgumentException e){
            System.out.println("Expected IllegalArgumentException: " + e.getMessage());
        }
    }
}