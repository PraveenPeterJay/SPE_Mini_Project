
import org.calculator.ScientificCalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private ScientificCalculator calculator;
    private final double DELTA = 0.0001;

    @BeforeEach
    void setup() {
        // Initializes a fresh Calculator instance before each test
        calculator = new ScientificCalculator();
    }

    // --- Square Root Tests (√x) ---

    @Test
    void testSquareRootPositive() {
        // Standard positive number
        assertEquals(5.0, calculator.squareRoot(25.0), DELTA);
    }

    @Test
    void testSquareRootZero() {
        // Edge case: zero
        assertEquals(0.0, calculator.squareRoot(0.0), DELTA);
    }

    @Test
    void testSquareRootNegative() {
        // Edge case: negative number (should throw exception)
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.squareRoot(-4.0);
        });
    }

    // --- Factorial Tests (!x) ---

    @Test
    void testFactorialPositive() {
        // Standard positive integer
        assertEquals(120, calculator.factorial(5)); // 5! = 120
    }

    @Test
    void testFactorialOne() {
        // Edge case: 1! = 1
        assertEquals(1, calculator.factorial(1));
    }

    @Test
    void testFactorialZero() {
        // Edge case: 0! = 1
        assertEquals(1, calculator.factorial(0));
    }

    @Test
    void testFactorialNegative() {
        // Edge case: negative number (should throw exception)
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.factorial(-1);
        });
    }

    @Test
    void testFactorialLimit() {
        // Test near the limit for long (assuming limit is 20 in implementation)
        assertEquals(2432902008176640000L, calculator.factorial(20)); // 20!
    }

    // --- Natural Logarithm Tests (ln(x)) ---

    @Test
    void testNaturalLogE() {
        // Standard case: ln(e) = 1
        assertEquals(1.0, calculator.naturalLog(Math.E), DELTA);
    }

    @Test
    void testNaturalLogOne() {
        // Edge case: ln(1) = 0
        assertEquals(0.0, calculator.naturalLog(1.0), DELTA);
    }

    @Test
    void testNaturalLogZero() {
        // Edge case: ln(0) (should throw exception)
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.naturalLog(0.0);
        });
    }

    @Test
    void testNaturalLogNegative() {
        // Edge case: negative input (should throw exception)
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.naturalLog(-2.0);
        });
    }

    // --- Power Function Tests (x^b) ---

    @Test
    void testPowerPositiveIntExponent() {
        // Standard case: 2^3 = 8
        assertEquals(8.0, calculator.power(2.0, 3.0), DELTA);
    }

    @Test
    void testPowerZeroExponent() {
        // Edge case: x^0 = 1
        assertEquals(1.0, calculator.power(100.0, 0.0), DELTA);
    }

    @Test
    void testPowerNegativeExponent() {
        // Edge case: 2^-1 = 0.5
        assertEquals(0.5, calculator.power(2.0, -1.0), DELTA);
    }

    @Test
    void testPowerNegativeBaseIntegerExponent() {
        // Edge case: (-2)^3 = -8
        assertEquals(-8.0, calculator.power(-2.0, 3.0), DELTA);
    }

    @Test
    void testPowerNegativeBaseNegativeExponent() {
        // Edge case: (-2)^(-1) = -0.5
        assertEquals(-0.5, calculator.power(-2.0, -1), DELTA);
    }

    @Test
    void testPowerZeroBasePositiveExponent() {
        // Edge case: 0^x = 0 (where x > 0)
        assertEquals(0.0, calculator.power(0.0, 5.0), DELTA);
    }

    @Test
    void testPowerZeroBaseZeroExponent() {
        // Edge case: 0^0 = 1 (standard convention in Math.pow)
        assertEquals(1.0, calculator.power(0.0, 0.0), DELTA);
    }

    @Test
    void testPowerFractionalExponent() {
        // Square root as power: 9^0.5 = 3
        assertEquals(3.0, calculator.power(9.0, 0.5), DELTA);
    }

}

