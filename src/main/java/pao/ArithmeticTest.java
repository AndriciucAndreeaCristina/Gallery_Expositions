package pao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArithmeticTest {

    @Test
    public void testAdd() {
        Arithmetic arithmetic = new Arithmetic();
        int result = arithmetic.add(2, 3);
        Assertions.assertEquals(5, result);
    }

    @Test
    public void testSubtract() {
        Arithmetic arithmetic = new Arithmetic();
        int result = arithmetic.subtract(5, 3);
        Assertions.assertEquals(2, result);
    }

    @Test
    public void testMultiply() {
        Arithmetic arithmetic = new Arithmetic();
        int result = arithmetic.multiply(2, 3);
        Assertions.assertEquals(6, result);
    }

    @Test
    public void testDivide() {
        Arithmetic arithmetic = new Arithmetic();
        double result = arithmetic.divide(6, 3);
        Assertions.assertEquals(2.0, result);
    }
}
