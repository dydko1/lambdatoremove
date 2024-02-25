package funcprogrammingmiro;

import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class ConsumerExample {
    @Test
    public void consumer() {
        Consumer<String> c = x -> System.out.println(x.length() + " the value of" + x);
        c.accept("test123");

        Consumer<Integer> d = x -> {
            System.out.println(x + "^2 is: " + x * x);
            System.out.println("x/x= " + x / x);
        };
        d.accept(10);
        BiFunction<Integer, Integer, Integer> sum = Integer::max;
        System.out.println(sum.apply(120, 10));
    }
}
