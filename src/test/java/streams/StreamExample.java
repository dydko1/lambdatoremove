package streams;

import funcprogrammingmiro.Instructors;
import funcprogrammingmiro.Instructor;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamExample {
    @Test
    public void creatingMapOfCoursers() {
        Predicate<Instructor> p1 = i -> i.isOnlineCourse();
        Predicate<Instructor> p2 = i -> i.getYearsOfExperience() > 10;

        List<Instructor> list = new Instructors().getALL();

        Map<String, List<String>> map = list
                .stream()
                .filter(p1)
                .filter(p2)
                .peek(System.out::println)
                .collect(Collectors.toMap(Instructor::getName, Instructor::getCourse));
        System.out.println(map);
    }
}
