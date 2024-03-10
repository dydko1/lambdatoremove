package funcprogrammingmiro;

import org.testng.annotations.Test;

import java.util.function.Function;
import java.util.function.Predicate;

public class MethodReferenceExample {
    @Test
    public void predicate1() {
        Predicate<Instructor> p1 = i -> i.isOnlineCourse();
        Predicate<Instructor> p2 = Instructor::isOnlineCourse;

        Function<Integer, Double> sqrt1 = n -> Math.sqrt(n);
        Function<Integer, Double> sqrt2 = Math::sqrt;

        Function<String, String> lowerCase1 = s -> s.toLowerCase();
        Function<String, String> lowerCase2 = String::toLowerCase;
    }
}
