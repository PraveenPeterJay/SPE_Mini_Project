package org.calculator;

public class ScientificCalculator {
    public double squareRoot(double x) throws IllegalArgumentException {
        if (x < 0) {
            throw new IllegalArgumentException("Square root is not defined for negative numbers.");
        }

        return Math.sqrt(x);
    }

    public long factorial(int x) throws IllegalArgumentException {
        if (x < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }
        if( x > 20) {
            throw new IllegalArgumentException("Factorial will be too large to be calculated accurately.");
        }

        long result = 1;
        for (int i = 2; i <= x; i++) {
            result *= i;
        }
        return result;
    }

    public double naturalLog(double x) throws IllegalArgumentException {
        if (x <= 0) {
            throw new IllegalArgumentException("Natural logarithm is not defined for non-positive numbers.");
        }
        return Math.log(x);
    }

    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }
}

