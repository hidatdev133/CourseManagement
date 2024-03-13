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
                course.setCredit(rs.getInt("Credits"));
                course.setDepartmentID(rs.getInt("DepartmentID"));
                list.add(course);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
    public OnlineCourse findOnlCourseByID(int id){
        OnlineCourse onlCourse = null;
        try {
            String sql = "SELECT * FROM Course , OnlineCourse WHERE Course.CourseID = OnlineCourse.CourseID AND Course.CourseID = " + id ;
            ResultSet rs = this.doReadQuery(sql);
            while(rs.next()){
                onlCourse = new OnlineCourse();
                onlCourse.setCourseID(id);
                onlCourse.setCredit(rs.getInt("Credits"));
                onlCourse.setDepartmentID(rs.getInt("DepartmentID"));
                onlCourse.setTitle(rs.getString("Title"));
                onlCourse.setURL(rs.getString("url"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return onlCourse;
    }

    public boolean addOnlineCourse(OnlineCourse onl){
        boolean result = false ;
        try {
            String max_id = "SELECT MAX(CourseID)  FROM Course";
            ResultSet rs = this.doReadQuery(max_id);
            if(rs.next()){
                int course_id = rs.getInt(1) + 1;
                 String sql = "INSERT INTO `Course` (`CourseID`, `Title`, `Credits`, `DepartmentID`) VALUES (" + course_id + ", '" + onl.getTitle() + "', " + onl.getCredit() + ", " + onl.getDepartmentID() + ");\n";
                 String sql2 = "INSERT INTO  `OnlineCourse` (`CourseID`, `url`) VALUES (" + course_id + " , '"+ onl.getURL() + "')";
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
    
    public boolean editOnlineCourse(OnlineCourse onl){
        boolean result = false ;
        try {
            String sql = "UPDATE Course SET Title = '" + onl.getTitle() + "' , Credits = " + onl.getCredit() +" , DepartmentID = " + onl.getDepartmentID() + "  WHERE CourseID = " + onl.getCourseID();
            String sql1 = "UPDATE OnlineCourse SET url = '" + onl.getURL() + "' WHERE CourseID = " + onl.getCourseID() ;
            Statement stmt = this.getConnection().createStatement();
            if(stmt.executeUpdate(sql) >= 1 && stmt.executeUpdate(sql1) >= 1 ){
                result = true ;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return  result;
    }
    
    public boolean deleteOnlineCourse(int id){
        boolean result = false ;
        try {
            String sql = "DELETE FROM onlinecourse WHERE courseID =   " + id;
            String sql1 = "DELETE FROM course WHERE courseID =   " + id;
            Statement stmt = this.getConnection().createStatement();
            if(stmt.executeUpdate(sql) >= 1 ){
                if(stmt.executeUpdate(sql1) >= 1){
                    result = true ;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return  result;
    }
    
    public boolean isOnlineCourse(int id){
        boolean result = false ;
        try {
            String sql = "SELECT * FROM Course , OnlineCourse WHERE Course.CourseID = OnlineCourse.CourseID AND Course.CourseID =" + id ;
            ResultSet rs = this.doReadQuery(sql);
            if(rs.next()){
                result = true ;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return result ;
    }
   
}
