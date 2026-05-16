package learning.features.addition;

import learning.core.JavaLogger;

public class AdditionTest {

    static void main() {
        testAddition();
        JavaLogger.INSTANCE.info("All tests passed!");
    }

    private static void testAddition() {
        AdditionDemo demo = new AdditionDemo();

        // Test positive numbers
        int result1 = demo.add(5, 5);
        if (result1 != 10) {
            throw new AssertionError("Test failed: expected 10, but got " + result1);
        }

        // Test with negative numbers
        int result2 = demo.add(-2, 5);
        if (result2 != 3) {
            throw new AssertionError("Test failed: expected 3, but got " + result2);
        }
    }
}
