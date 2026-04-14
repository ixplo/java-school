package lambda;

import java.io.Serializable;
import java.util.function.Consumer;

public class ConsumerImpl implements Consumer<String>, Serializable {
    @Override
    public void accept(String s) {

    }

    @Override
    public Consumer<String> andThen(Consumer<? super String> after) {
        return null;
    }
}
