package BLL.Course;

import DAL.Course.CourseDAL;
import java.util.ArrayList;

public class CourseBLL {

    public ArrayList<String> readDSID() {
        CourseDAL std = new CourseDAL();
        ArrayList<String> list = std.readDSID();
        return list;
    }
}
