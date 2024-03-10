package funcprogrammingmiro;

import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class ConvertToMethodReferencePredicateExample2 {
    @Test
    public void methodReference1() {
        Predicate<Instructor> p2 = new ConvertToMethodReferencePredicateExample2()::greaterThenTenYearsOfExperience;

        new Instructors().getALL().forEach(i -> p2.test(i));
    }

    private Boolean greaterThenTenYearsOfExperience(Instructor instructor) {
        if (instructor.getYearsOfExperience() > 10)
            return true;
        return false;
    }
}
