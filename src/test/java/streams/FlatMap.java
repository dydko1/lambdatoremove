package streams;

import funcprogrammingmiro.Instructor;
import funcprogrammingmiro.Instructors;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FlatMap {

    @Test
    public void flatMap() {
        Set<String> instructorCourses = new Instructors().getALL().stream()
                .map(Instructor::getCourses)
                .flatMap(List::stream)
                .collect(Collectors.toSet());
        System.out.println(instructorCourses);
    }
}
