package DAL.Course;
import ConnectDB.*;
import DAL.StudentGrade.StudentGrade;
import com.mysql.cj.xdevapi.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class OnsiteCourseDAL extends ConnectDB{
  public ArrayList readOnsiteCourse(){
      ArrayList<OnsiteCourse>onsiteCourseList=new ArrayList<>();
      try{
           String sql="SELECT course.CourseID,course.Title"
                   + ",course.Credits,course.DepartmentID,onsitecourse.Location,"
                   + "onsitecourse.Days,onsitecourse.Time\n" +
                    "FROM onsitecourse,course\n" +
                    "WHERE onsitecourse.CourseID=course.CourseID";
           ResultSet rs=this.doReadQuery(sql);
           while(rs.next()){
              OnsiteCourse onsiteCourse=new OnsiteCourse();
              onsiteCourse.setCourseID(rs.getInt("CourseID"));
              onsiteCourse.setTitle(rs.getString("Title"));
              onsiteCourse.setCredits(rs.getInt("Credits"));
              onsiteCourse.setDepartmentID(rs.getInt("DepartmentID"));
              onsiteCourse.setLocation(rs.getString("Location"));
              onsiteCourse.setDays(rs.getString("Days"));
              onsiteCourse.setTime(rs.getString("Time"));
              onsiteCourseList.add(onsiteCourse);
           }
      }catch(Exception e){
          e.printStackTrace();
      }
      return onsiteCourseList;
  }
  public int addOnsiteCourse(OnsiteCourse onsite){
      try{
          String sql="insert into onsitecourse values(?,?,?,?)";
          Connection con=ConnectDB.getConnection();
          PreparedStatement pre=con.prepareStatement(sql);
          pre.setInt(1, onsite.getCourseID());
          pre.setString(2, onsite.getLocation());
          pre.setString(3,onsite.getDays());
          pre.setString(4,onsite.getTime());
          return pre.executeUpdate();

                  
      }catch(Exception e){
          e.printStackTrace();
      }
      return -1;
  }
  public int editOnsiteCourse(OnsiteCourse onsite){
      try{
          Connection con=ConnectDB.getConnection();
          String sql="Update onsitecourse set Location=?,Days=?,Time=? where CourseID=?";
          PreparedStatement pre=con.prepareStatement(sql);
         
          pre.setString(1,onsite.getLocation());
          pre.setString(2,onsite.getDays());
          pre.setString(3,onsite.getTime());
          pre.setInt(4, onsite.getCourseID());
         
          return pre.executeUpdate();
      }catch(Exception e){
          e.printStackTrace();
      }
      return -1;
  }
  public boolean DeleteOnsiteCourse(int courseID){
      try{
          Connection con=ConnectDB.getConnection();
            String sql = "DELETE FROM onsitecourse WHERE `CourseID` = '" + courseID + "'";
          PreparedStatement pre=con.prepareStatement(sql);
          return pre.executeUpdate()>0;
      }catch(Exception e){
          e.printStackTrace();
      }
      return false;
  }
 public ArrayList searchOnsiteCourseID(String hint ){
     ArrayList<OnsiteCourse>onsiteCourseListSearch=new ArrayList<>();
     try{
         Connection con=ConnectDB.getConnection();
         String sql="SELECT *\n" +
                "FROM course INNER JOIN onsitecourse On course.CourseID=onsitecourse.CourseID\n" +
                "WHERE onsitecourse.CourseID LIKE '%"+hint+"%' OR onsitecourse.Location LIKE'%"+hint+"%'"
                 + "OR onsitecourse.Days LIKE '%"+hint+"%' OR onsitecourse.Time LIKE '%"+hint+"%' "
                 + "OR course.Title LIKE '%"+hint+"%' OR course.Credits LIKE '%"+hint+"%' "
                 + "OR course.DepartmentID LIKE '%"+hint+"%'";   
        PreparedStatement pre=con.prepareCall(sql);
        ResultSet rs=pre.executeQuery();
         while(rs.next()){
             OnsiteCourse onsite=new OnsiteCourse();
             onsite.setCourseID(rs.getInt("CourseID"));
             onsite.setTitle(rs.getString("Title"));
             onsite.setCredits(rs.getInt("Credits"));
             onsite.setDepartmentID(rs.getInt("DepartmentID"));
             onsite.setLocation(rs.getString("Location"));
             onsite.setDays(rs.getString("Days"));
             onsite.setTime(rs.getString("Time"));
             onsiteCourseListSearch.add(onsite);
         }
 }catch(Exception e){
     e.printStackTrace();
 }
    return onsiteCourseListSearch;
 }
 public ArrayList readCourseIDStudentGrade(){
     ArrayList <Integer> listcourseidStudent=new ArrayList();
     try{
         String sql="select CourseID from studentgrade";
         ResultSet rs=this.doReadQuery(sql);
         while(rs.next()){
             StudentGrade studentgrade=new StudentGrade();
             studentgrade.setCourseID(rs.getInt("CourseID"));
            listcourseidStudent.add(studentgrade.getCourseID());
         }
     }catch(Exception e){
         e.printStackTrace();
     }
     return listcourseidStudent;
 }
 public boolean isOnsiteCourse(int id){
     try{
         String sql="SELECT * from course, onsitecourse WHERE course.CourseID=onsitecourse.CourseID and course.CourseID="+id;
         ResultSet rs=this.doReadQuery(sql);
        while(rs.next()){
             return true;
         }
     }catch(Exception e){
         e.printStackTrace();
     }
     return false;
 }
 public OnsiteCourse getOnsiteCourseByID(int id){ 
     OnsiteCourse onsite=new OnsiteCourse();
     try{
         String sql="select * from course, onsitecourse where course.CourseID=onsitecourse.CourseID and onsitecourse.CourseID="+id;
         ResultSet rs=this.doReadQuery(sql);
         while(rs.next()){
             onsite.setCourseID(rs.getInt("CourseID"));
             onsite.setTitle(rs.getString("title"));
             onsite.setCredits(rs.getInt("Credits"));
             onsite.setDepartmentID(rs.getInt("DepartmentID"));
             onsite.setLocation(rs.getString("Location"));
             onsite.setDays(rs.getString("Days"));
             onsite.setTime(rs.getString("Time"));
         }
         }
         catch(Exception e){
                 e.printStackTrace();
                 }
     return onsite;
 }
  public int CountLocation(String location){
        try{
            String sql="select count(onsitecourse.CourseID) from onsitecourse where onsitecourse.Location= '"+location+"'";
            ResultSet rs=this.doReadQuery(sql);
            while(rs.next()){
                return rs.getInt(1);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    
}
