package streams;

import funcprogrammingmiro.Instructor;
import funcprogrammingmiro.Instructors;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class StreamOperators {
    @Test
    public void streamOperators() {
        Long count = new Instructors().getALL().stream()
                .map(Instructor::getCourses)
                .flatMap(List::stream)
                .distinct()
                .count();
        System.out.println("eee=" + count);
        List<String> courses = new Instructors().getALL().stream()
                .map(Instructor::getCourses)
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(courses);
        //anyMatch
        boolean match = new Instructors().getALL().stream()
                .map(Instructor::getCourses)
                .flatMap(List::stream)
                .anyMatch(s -> s.contains("Java"));
        System.out.println(match);

    }
}
