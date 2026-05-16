package learning.features.addition;

import learning.core.FeatureDemo;
import learning.core.JavaLogger;
import learning.core.exception.FeatureException;

public class AdditionDemo implements FeatureDemo {

    @Override
    public void run() throws FeatureException, InterruptedException {
        JavaLogger.INSTANCE.info(add(5, 5) + "");
    }

    public int add(int a, int b) {
        return a + b;
    }
}
