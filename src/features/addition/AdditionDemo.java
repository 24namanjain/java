package features.addition;

import core.DemoRunner;
import core.FeatureDemo;
import core.JavaLogger;
import core.exception.FeatureException;

public class AdditionDemo implements FeatureDemo {

    static void main() {
        DemoRunner.run(new AdditionDemo());
    }

    @Override
    public void run() throws FeatureException {
        JavaLogger.INSTANCE.info(add(5, 5) + "");
    }

    public int add(int a, int b) {
        return a + b;
    }
}
