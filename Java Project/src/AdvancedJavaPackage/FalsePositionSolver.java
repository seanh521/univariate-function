/**
 * @author Sean Harrington
 * unless specified otherwise
 */

package AdvancedJavaPackage;

import java.util.Scanner;

/**
 * A public class that implements extends the abstract class UnivariateFunctionRootSolver.
 * Solves for the False Position
 */
public class FalsePositionSolver extends UnivariateFunctionRootSolver {

    /**
     * For solving for the false position
     * Overrides the function solve in UnivariateFunctionRootSolver
     * @author this function was written by UCC lecturer John O'Mullinane
     * @param x0 first x coordinate
     * @param x1 second x coordinate
     * @return returns the value from the calculation that uses the parameters x0 and x1
     * @throws IllegalArgumentException checks for any arguments that would break the implemented function
     */
    @Override
    public double solve(double x0, double x1) throws IllegalArgumentException {
        if (f(x0) * f(x1) > 0) {
            throw new IllegalArgumentException("f(" + x0 + ") * x f(" + x1 + ") must be < 0");
        }

        double root = 0.0;
        int numberOfIterations = 0;
        boolean rootNotFound = true;

        do {
            numberOfIterations += 1;
            root = (x0 * f(x1) - x1 * f(x0)) / (f(x1) - f(x0));
            rootNotFound = (Math.abs(root - x1) > epsilon) && (Math.abs(root - x0) > epsilon);
            if (rootNotFound) {
                if (f(root) * f(x0) < 0) {
                    x1 = root;
                } else {
                    x0 = root;
                }
            }

            if(numberOfIterations == maxIterations){
                System.out.println("Root not found");
                break;
            }
        } while (rootNotFound && (numberOfIterations < maxIterations));
        System.out.println("The root was found in " + numberOfIterations + " iterations");

        assert (Math.abs(f(root)) < epsilon) : "Insufficient accuracy";

        return root;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.println("Please enter two x values. (Please press enter after the first value)");
        double x0 = kb.nextDouble();
        double x1 = kb.nextDouble();
        FalsePositionSolver fps = new FalsePositionSolver();
        fps.userProvideMaxIterations();
        fps.userProvideEpsilon();
        double root = fps.solve(x0, x1);
        System.out.println("root = " + root);
    }
}