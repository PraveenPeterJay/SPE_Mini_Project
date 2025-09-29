package org.calculator;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ScientificCalculator calculator = new ScientificCalculator();
        boolean running = true;

        while (running) {
            System.out.println("\nScientific Calculator Menu");
            System.out.println("1. Square Root (√x)");
            System.out.println("2. Factorial (x!)");
            System.out.println("3. Natural Logarithm (ln(x))");
            System.out.println("4. Power Function (x^b)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number from the menu.");
                scanner.nextLine();
                continue;
            }

            try {
                System.out.println();
                switch (choice) {
                    case 1:
                        System.out.print("Enter a number for square root: ");
                        double sqrtX = scanner.nextDouble();
                        System.out.println("Result: " + calculator.squareRoot(sqrtX));
                        break;
                    case 2:
                        System.out.print("Enter a non-negative integer for factorial: ");
                        int factX = scanner.nextInt();
                        System.out.println("Result: " + calculator.factorial(factX));
                        break;
                    case 3:
                        System.out.print("Enter a positive number for natural logarithm: ");
                        double logX = scanner.nextDouble();
                        System.out.println("Result: " + calculator.naturalLog(logX));
                        break;
                    case 4:
                        System.out.print("Enter a base: ");
                        double baseX = scanner.nextDouble();
                        System.out.print("Enter an exponent: ");
                        double exponentB = scanner.nextDouble();
                        System.out.println("Result: " + calculator.power(baseX, exponentB));
                        break;
                    case 5:
                        running = false;
                        System.out.println("Thank you for using my calculator!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please select an option between 1 and 5.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input Error: Please enter a valid number for the operation.");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println("Calculation Error: " + e.getMessage());
                if (scanner.hasNextLine()) {
                    scanner.nextLine();
                }
            }
        }
        scanner.close();
    }
}
