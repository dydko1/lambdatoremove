package funcprogrammingmiro;

import java.util.List;

public interface InstructorFactory {
    public abstract Instructor getInstructor(String name, int YearsOnExperience, String title,
                                             String gender, boolean onlineCourse, List<String> courses);
}
