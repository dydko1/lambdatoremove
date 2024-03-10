package funcprogrammingmiro;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Instructor {
    private  String name;
    private int yearsOfExperience;
    private String title;
    private String gender;
    private boolean onlineCourse;
    private List<String> courses;
}
