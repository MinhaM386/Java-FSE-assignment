package FactoryMethodPatternExample.DS;
import java.util.Scanner;

public class FinancialForecasting {

    // Recursive method to calculate future value
    public static double futureValue(double presentValue, double growthRate, int years) {

        // Base case
        if (years == 0) {
            return presentValue;
        }

        // Recursive case
        return futureValue(presentValue, growthRate, years - 1) * (1 + growthRate / 100);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Present Value: ");
        double presentValue = sc.nextDouble();

        System.out.print("Enter Annual Growth Rate (%): ");
        double growthRate = sc.nextDouble();

        System.out.print("Enter Number of Years: ");
        int years = sc.nextInt();

        long startTime = System.nanoTime();

        double future = futureValue(presentValue, growthRate, years);

        long endTime = System.nanoTime();

        System.out.printf("\nFuture Value after %d years = %.2f\n", years, future);

        System.out.println("Execution Time: " + (endTime - startTime) + " ns");

        sc.close();
    }
}
