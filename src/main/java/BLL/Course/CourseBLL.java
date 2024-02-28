package BLL.Course;

import DAL.Course.CourseDAL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseBLL {

    CourseDAL cdal;

    public CourseBLL() {
        cdal = new CourseDAL();
    }

    public ArrayList<String> readDSID() {
        CourseDAL std = new CourseDAL();
        ArrayList<String> list = std.readDSID();
        return list;
    }

    public List LoadCourses(int page) throws SQLException {
        ArrayList list = cdal.readCourse();
        return list;
    }
}
