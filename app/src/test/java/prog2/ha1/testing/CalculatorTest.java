package prog2.ha1.testing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Retro calculator")
class CalculatorTest {

    @Test
    @DisplayName("should display correct number after pressing digit keys")
    void testDigitInput() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(4);
        calc.pressDigitKey(2);

        String expected = "42";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after adding two positive numbers")
    void testPositiveAddition() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressEqualsKey();

        String expected = "4";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException")
    void testIllegalArgumentException(){
        Calculator calc = new Calculator();

        assertThrows(IllegalArgumentException.class,()->calc.pressDigitKey(14));
    }

    @Test
    @DisplayName("should display correct result after doing multiple operations")
    void testMultipleOperations(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(5);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(5);
        calc.pressBinaryOperationKey("-");
        assertEquals("10", calc.readScreen());
        calc.pressDigitKey(7);
        calc.pressEqualsKey();
        assertEquals("3", calc.readScreen());
    }

    @Test
    @DisplayName("should display percentage value of pressed digit")
    void testPercentageKey(){
        Calculator calc = new Calculator();
        calc.pressDigitKey(1);
        calc.pressDigitKey(0);
        calc.pressUnaryOperationKey("%");
        assertEquals("0.1", calc.readScreen());
    }

    @Test
    @DisplayName("Should continue binary Operation, after pressing UnaryOperationKey")
    void testBinaryAfterUnary(){
        Calculator calc = new Calculator();
        calc.pressDigitKey(5);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(1);
        calc.pressDigitKey(0);
        calc.pressUnaryOperationKey("%");
        calc.pressEqualsKey();
        assertEquals("5.1", calc.readScreen());
    }
}

