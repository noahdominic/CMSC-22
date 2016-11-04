package studentdb_serialization;

import java.io.Serializable;

/**
 * Created by Noah Dominic on 04/11/2016.
 */
public class Course implements Serializable {
    String courseCode;
    String courseDescription;

    public Course(String courseCode, String courseDescription) {
        this.courseCode = courseCode;
        this.courseDescription = courseDescription;
    }
}
