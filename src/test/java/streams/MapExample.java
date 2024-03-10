package streams;

import funcprogrammingmiro.Instructor;
import funcprogrammingmiro.Instructors;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.stream.Collectors;

public class MapExample {
    @Test
    public void mapExample() {
        Set<String> instructors = new Instructors()
                .getALL().stream()
                .map(Instructor::getName)
                .map(String::toUpperCase)
                .collect(Collectors.toSet());
        System.out.println(instructors);
    }
}
