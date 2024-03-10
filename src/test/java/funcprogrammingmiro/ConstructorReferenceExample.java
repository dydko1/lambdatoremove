package funcprogrammingmiro;

import org.testng.annotations.Test;

import java.util.Arrays;

public class ConstructorReferenceExample {
    @Test
    public void instructorFactory() {
        InstructorFactory instructorFactory = Instructor::new;
        Instructor instructor = instructorFactory.getInstructor("Miro", 19, "Sotware Developer",
                "M", true, Arrays.asList("Java Programing", "C++ programing", "Python programing"));
        System.out.println(instructor);
    }
}