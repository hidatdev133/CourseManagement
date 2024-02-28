package DAL.Course;

import ConnectDB.ConnectDB;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class OnlineCourseDAL extends ConnectDB {
    
    public ArrayList<OnlineCourse> listOfOnlineCourses(){
        ArrayList<OnlineCourse> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM onlinecourse , course WHERE onlinecourse.CourseID = course.CourseID";
            ResultSet rs = this.doReadQuery(sql);
            while(rs.next()){
                OnlineCourse course = new OnlineCourse();
                course.setCourseID(rs.getInt("CourseID"));
                course.setURL(rs.getString("url"));
                course.setTitle(rs.getString("Title"));
                list.add(course);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    

    public boolean addOnlineCourse(String title, int credits, int departmentID){
        boolean result = false ;
        try {
            String max_id = "SELECT MAX(CourseID)  FROM Course";
            ResultSet rs = this.doReadQuery(max_id);
            if(rs.next()){
                int course_id = rs.getInt(1) + 1;
                 String sql = "INSERT INTO `Course` (`CourseID`, `Title`, `Credits`, `DepartmentID`) VALUES (" + course_id + ", '" + title + "', " + credits + ", " + departmentID + ");\n";
                 String sql2 = "INSERT INTO  `OnlineCourse` (`CourseID`, `url`) VALUES (" + course_id + " , 'http://www.fineartschool.net/" + title +"_" + course_id + "')";
                Statement stmt = this.getConnection().createStatement();
                if(stmt.executeUpdate(sql) >= 1){
                    if(stmt.executeUpdate(sql2) >= 1)
                        result = true ;
                    
                }
            }
           
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
}
