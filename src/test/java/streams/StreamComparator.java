package streams;

import funcprogrammingmiro.Instructor;
import funcprogrammingmiro.Instructors;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamComparator {
    @Test
    public void streamComparator() {
        List<Instructor> list = new Instructors().getALL().stream()
                .sorted(Comparator.comparing(Instructor::getName))
                .collect(Collectors.toList());

        list.forEach(System.out::println);
    }
}
