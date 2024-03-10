package streams;

import funcprogrammingmiro.Instructor;
import funcprogrammingmiro.Instructors;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamReduceExample {
    @Test
    public void reduce() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        int result = numbers.stream()
                .reduce(100, (a, b) -> a + b);
        System.out.println(result);
    }

    @Test
    public void reduce2() {
        Optional instructor = new Instructors().getALL()
                .stream()
                .reduce((s1, s2) -> {
                    if (s1.getYearsOfExperience() > 10)
                        return s1;
                    else
                        return s2;
                });

        if (instructor.isPresent()) {
            System.out.println(instructor.get());
        }
    }
}
