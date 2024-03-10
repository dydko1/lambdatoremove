package streams;

import funcprogrammingmiro.Instructor;
import funcprogrammingmiro.Instructors;

public class StreamMapFilterReduce {
    public static void main(String[] args) {

        int result = new Instructors().getALL().stream()
                .filter(Instructor::isOnlineCourse)
                .map(Instructor::getYearsOfExperience)
                .reduce(0, (a, b) -> a + b);
        System.out.println(result);
    }
}
