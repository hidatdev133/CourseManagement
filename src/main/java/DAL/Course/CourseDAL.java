package DAL.Course;

import java.sql.ResultSet;
import java.util.ArrayList;
import ConnectDB.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;


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
    public ArrayList readCourseDAL(){
        ArrayList<Course> CourseList=new ArrayList<>();
        try{
            String sql="Select * from course ";
            ResultSet rs=this.doReadQuery(sql);
            while(rs.next()){
                Course course=new Course();
                course.setCourseID(rs.getInt("CourseID"));
                course.setTitle(rs.getString("Title"));
                course.setCredit(rs.getInt("Credits"));
                course.setDepartmentID(rs.getInt("DepartmentID"));
                CourseList.add(course);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return CourseList;
    }
    public int addCourse(Course course){
        try{
            Connection con=ConnectDB.getConnection();
            String sql="insert into course values(?,?,?,?)";
            PreparedStatement pre=con.prepareStatement(sql);
            pre.setInt(1, course.getCourseID());
            pre.setString(2, course.getTitle());
            pre.setInt(3, course.getCredit());
            pre.setInt(4, course.getDepartmentID());
            return pre.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return -1;
    }
    
  public int updateCourse(Course course){
      try{
          Connection con=ConnectDB.getConnection();
          String sql="Update course set Title=?,Credits=?,DepartmentID=? where CourseID=?";
          PreparedStatement pre=con.prepareStatement(sql);
        
          pre.setString(1,course.getTitle());
          pre.setInt(2, course.getCredit());
          pre.setInt(3, course.getDepartmentID());
            pre.setInt(4, course.getCourseID());
          return pre.executeUpdate();
      }catch(Exception e){
          e.printStackTrace();
      }
      return -1;
  }  
    public boolean DeleteCourse(int courseID){
      try{
          Connection con=ConnectDB.getConnection();
            String sql = "DELETE FROM course WHERE `CourseID` = '" + courseID + "'";
          PreparedStatement pre=con.prepareStatement(sql);
          return pre.executeUpdate()>0;
      }catch(Exception e){
          e.printStackTrace();
      }
      return false;
  }
  
}
