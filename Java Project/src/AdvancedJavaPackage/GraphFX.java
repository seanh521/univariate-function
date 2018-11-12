/**
 * @author Sean Harrington
 * unless specified otherwise
 */
package AdvancedJavaPackage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import java.util.Scanner;

/**
 * An abstract class that implements the interface UnivariateFunction.
 * The class creates functions that help calculates the root.
 */

public class GraphFX extends Application implements UnivariateFunction {
        double xMin;
        double xMax;

        Scanner kb = new Scanner(System.in);

        public static void main(String[] args) {

            launch(args);
        }

        /**
         * Gets the X negative range and the x positive range
         * Creates the stage for the graph being made
         * Creates the graph
         * @throws Exception checks for any arguments that would break the implemented function
         */
        @Override
        public void start(Stage stage) throws Exception {

            enterXNegativeRange();
            enterXPositiveRange();

            stage.setTitle("Univariate Function");
            final NumberAxis xAxis = new NumberAxis(xMin, xMax, 1);
            final NumberAxis yAxis = new NumberAxis(-10, 10, 1);
            final LineChart<Number, Number> lineChart =
                    new LineChart<Number, Number>(xAxis, yAxis);
            XYChart.Series series = new XYChart.Series();
            series.setName("x - 2.5 * Math.sin(x) * Math.sin(x)");

            while(xMin < xMax) {
                double y = f(xMin);

                series.getData().add(new XYChart.Data<>(xMin, y));
                xMin+=1;
            }

            Scene scene = new Scene(lineChart, 800, 600);
            lineChart.getData().add(series);

            stage.setScene(scene);
            stage.show();
        }

        @Override
        public double f(double x) {
            return x - 2.5 * Math.sin(x) * Math.sin(x);
        }

        /**
         * Private function that retrievs the x ngative range from user input
         * @return returns the x negative range from user input
         */
        private double enterXNegativeRange() {
            System.out.println("Please enter a minimum for x - must be less than 0");
            xMin = kb.nextDouble();
            if(xMin >= 0) {
                enterXNegativeRange();
            }
            return xMin;
        }

        /**
         * Private function that retrievs the x ngative range from user input
         * @return returns the x negative range from user input
         */
        private double enterXPositiveRange() {
            System.out.println("Please enter a maximum for x - must be greater than 0");
            xMax = kb.nextDouble();
            if(xMax <= 0) {
                enterXPositiveRange();
            }
            return xMax;
        }
    }

