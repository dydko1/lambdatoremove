package funcprogrammingmiro;

import org.testng.annotations.Test;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample2 {
    @Test
    public void listOfInstructors() {
        List<Instructor> instructors = new Instructors().getALL();
        Consumer<Instructor> c1 = (instructor -> {
            System.out.println("*********************");
            System.out.println(instructor);
            System.out.println("*********************");
        });
        instructors.forEach(c1);

        System.out.println("--------------");
        Consumer<Instructor> c2 = instructor -> {
            System.out.println(instructor.getName());
        };
        instructors.forEach(c2);

        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXX");
        Consumer<Instructor> c3 = instructor -> {
            System.out.println(instructor.getCourses());
            System.out.println(":::::::::::::::::::");
        };

        instructors.forEach(c2.andThen(c3).andThen(c1).andThen(c2));
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        instructors.forEach(instructor -> {
            if (instructor.getYearsOfExperience() > 10)
                c3.accept(instructor);
        });
    }
}
