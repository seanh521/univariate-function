/**
 * @author Sean Harrington
 * unless specified otherwise
 */
package AdvancedJavaPackage;

import java.util.Scanner;

/**
 * An abstract class that implements the interface UnivariateFunction.
 * The class creates functions that help calculates the root.
 */

abstract class UnivariateFunctionRootSolver implements UnivariateFunction{

    public double epsilon = 1.0E-6;
    public int maxIterations = 10;
    Scanner kb = new Scanner(System.in);

    /**
     * Provides implemented function f from the interface UnivariateFunction to help solve the root
     * @param x used for the calculation of the Univariate Function
     * @return returns the sin function that is implemented
     */
    @Override
    public double f(double x){
        return x - 2.5 * Math.sin(x) * Math.sin(x);
    }

    /**
     * For solving methods on a graph
     * @param x0 first x coordinate
     * @param x1 second x coordinate
     * @return returns the value from the calculation that uses the parameters x0 and x1
     * @throws IllegalArgumentException checks for any arguments that would break the implemented function
     */
    abstract double solve(double x0, double x1) throws IllegalArgumentException;

    /**
     * Takes the max iterations that the user wants. Also allows the user to use a default max iteration which is 10.
     *
     * @return returns the default max iterations or the user's input
     * @throws IllegalArgumentException if the number is less than or equal to 0 throw the exception
     */
    int userProvideMaxIterations() throws IllegalArgumentException {
        System.out.println("Set max iterations to default: " + maxIterations + " (y/n)");
        String answer = kb.next();
        if(answer.equals("N") || answer.equals("n")){
            System.out.println("Please enter the amount of Iterations you want");
            maxIterations = kb.nextInt();
            if(maxIterations <= 0){
                throw new IllegalArgumentException("Max iterations greater than 0.");
            }

            return maxIterations;
        }else {
            return maxIterations;
        }
    }

    /**
     * This method takes the user Epsilon or sets to the default which is 1.0E-6
     *
     * @return return the deafault epsilon or the epsilon inputted
     * @throws IllegalArgumentException when the epsilon is less than or equal to 1.0E-2
     */

    public double userProvideEpsilon() throws IllegalArgumentException{
        System.out.println("Set epsilon to default: " + epsilon + " (y/n)");
        String answer = kb.next();
        if(answer.equals("N") || answer.equals("n")){
            System.out.println("Please enter the value of epsilon you want");
            epsilon = kb.nextDouble();
            if(epsilon <= 1.0E-2){
                throw new IllegalArgumentException("Epsilon must be greater than 1.0E-2.");
            }
            return epsilon;
        }else {
            return epsilon;
        }

    }
}
