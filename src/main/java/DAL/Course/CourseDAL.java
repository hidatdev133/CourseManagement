package DAL.Course;

import java.sql.ResultSet;
import java.util.ArrayList;
import ConnectDB.ConnectDB;
import java.sql.SQLException;


public class CourseDAL extends ConnectDB {
    public ArrayList<String> readDSID(){
        ArrayList<String> list = new ArrayList<>();
        try {
            String query = "SELECT CourseID FROM course";
            ResultSet rs = this.doReadQuery(query);
            if(rs !=null){
                while(rs.next()){
                    String data = rs.getString("CourseID");
                    list.add(data);
                }
            }
            return list;
        } catch (Exception e) {
        }
        return list;
    }
    
    public ArrayList<Course> readCourse() throws SQLException {

        String query = "SELECT * FROM course ";
        ResultSet rs = CourseDAL.doReadQuery(query);
        ArrayList list = new ArrayList();

        if (rs != null) {
            int i = 1;
            while (rs.next()) {
                Course c = new Course();
                c.setCourseID(rs.getInt("CourseID"));
                c.setCredit(rs.getInt("Credits"));
                c.setDepartmentID(rs.getInt("DepartmentID"));
                c.setTitle(rs.getString("Title"));
                list.add(c);
            }
        }
        return list;
    }
}
