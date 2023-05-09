package pao.lab9;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ArithmeticTestSuite.AdditionTest.class,
        ArithmeticTestSuite.SubtractionTest.class,
        ArithmeticTestSuite.MultiplicationTest.class,
        ArithmeticTestSuite.DivisionTest.class
})
public class ArithmeticTestSuite {

    public static class AdditionTest {

        private Arithmetic arithmetic;

        @Before
        public void setUp() {
            arithmetic = new Arithmetic();
        }

        @After
        public void tearDown() {
            arithmetic = null;
        }

        @Test
        public void testAddition() {
            int result = arithmetic.add(3, 5);
            Assert.assertEquals(8, result);
        }
    }

    public static class SubtractionTest {

        private Arithmetic arithmetic;

        @BeforeEach
        public void setUp() {
            arithmetic = new Arithmetic();
        }

        @AfterEach
        public void tearDown() {
            arithmetic = null;
        }

        @Test
        public void testSubtraction() {
            int result = arithmetic.subtract(7, 4);
            Assert.assertEquals(3, result);
        }
    }

    public static class MultiplicationTest {

        private Arithmetic arithmetic;

        @Before
        public void setUp() {
            arithmetic = new Arithmetic();
        }

        @After
        public void tearDown() {
            arithmetic = null;
        }

        @Test
        public void testMultiplication() {
            int result = arithmetic.multiply(2, 6);
            Assert.assertEquals(12, result);
        }
    }

    public static class DivisionTest {

        private Arithmetic arithmetic;

        @BeforeEach
        public void setUp() {
            arithmetic = new Arithmetic();
        }

        @AfterEach
        public void tearDown() {
            arithmetic = null;
        }

        @Test
        public void testDivision() {
            double result = arithmetic.divide(10, 2);
            Assert.assertEquals(5.0, result, 0.001);
        }
    }
}
