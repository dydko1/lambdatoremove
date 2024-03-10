package streams;

import funcprogrammingmiro.Instructor;
import funcprogrammingmiro.Instructors;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class FilterExample {
    @Test
    public void filter() {

        List<Instructor> instructorList = new Instructors().getALL().stream()
                .filter(i -> i.getYearsOfExperience() > 10)
                .sorted(Comparator.comparing(Instructor::getName))
                .collect(Collectors.toList());
        instructorList.forEach(System.out::println);
    }
}
