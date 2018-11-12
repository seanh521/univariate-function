/**
 * @author Sean Harrington
 * unless specified otherwise
 */

package AdvancedJavaPackage;

/**
 * A public class that implements extends the abstract class UnivariateFunctionRootSolver.
 * Solves for the Secant
 */
public class SecantSolver extends UnivariateFunctionRootSolver {

    /**
     * For solving for the secant
     * Overrides the function solve from UnivariateFunctionRootSolver
     * @author this function was written by UCC lecturer John O'Mullinane
     * @param x0 first x coordinate
     * @param x1 second x coordinate
     * @return returns the value from the calculation that uses the parameters x0 and x1
     * @throws IllegalArgumentException checks for any arguments that would break the implemented function
     */
    @Override
    double solve(double x0, double x1) throws IllegalArgumentException{

        double c = (x0 + x1) / 2;
        int numberOfIterations = 0;

        do {

            c = (x0 * f(x1) - x1 * f(x0)) / (f(x1) - f(x0));
            x0 = x1;
            x1 = c;
            numberOfIterations += 1;
            if (numberOfIterations == maxIterations) {
                System.out.println("Root not found");
                break;
            }
        }
        while (Math.abs(f(c)) > epsilon);
        System.out.println("The root was found in " + numberOfIterations + " iterations");

        assert (Math.abs(f(c)) < epsilon) : "Insufficient accuracy";

        return c;
    }

    public static void main(String[] args) {
        SecantSolver ss = new SecantSolver();
        ss.userProvideMaxIterations();
        ss.userProvideEpsilon();
        double root = ss.solve(-4.0, 10.0);
        System.out.println("root = " + root);
    }
}





