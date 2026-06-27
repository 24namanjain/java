package learning.features.addition;

import learning.core.DemoRunner;
import learning.core.FeatureDemo;
import learning.core.JavaLogger;
import learning.core.exception.FeatureException;

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
