/**
 * @author Sean Harrington
 * unless specified otherwise
 */


package AdvancedJavaPackage;

/**
 * This interface allows for the implementation of a Univariate Function.
 */
public interface UnivariateFunction {
    /**
     * This method allows for the creation of a Univariate Function: "f"
     * @param x used for the calculation of the Univariate Function
     * @return a double value after it is calculated
     */

    double f(double x);
}
