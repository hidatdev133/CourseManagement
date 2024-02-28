package DAL.CourseInstructor;

import ConnectDB.ConnectDB;
import com.mysql.cj.protocol.Resultset;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseInstructorDAL extends ConnectDB{

    public CourseInstructorDAL() {
        super();
        connectDB();
    }
    
    public List readCourseInstructor() throws SQLException {
        String query = "SELECT * FROM course as ce, courseinstructor as c, person as p where c.personID = p.personID and c.courseid = ce.courseid";
        ResultSet rs = CourseInstructorDAL.doReadQuery(query);
        ArrayList list = new ArrayList();

        if (rs != null) {
            int i = 1;
            while (rs.next()) {
                CourseInstructor c = new CourseInstructor();
                c.setPersonID(rs.getInt("PersonID"));
                c.setCourseID(rs.getInt("CourseID"));
                list.add(c);
            }
        }
        return list;
    }
    
    /**
     *
     * @return
     * @throws SQLException
     */
    public int insertCourseInstructor(CourseInstructor c) throws SQLException {
        String query = "INSERT courseinstructor(courseid,pesonid) VALUE(?,?)";
        PreparedStatement p = CourseInstructorDAL.getConnection().prepareStatement(query);
        p.setString(1, c.getCourseID() + " ");
        p.setString(2, c.getPersonID() + " ");
        int result = p.executeUpdate();
        return result;
    }
    
     public int updateCourseInstructor(CourseInstructor c) throws SQLException {
        String query = "UPDATE courseinstructor set courseid = ?, personid = ? where courseid = ?, personid = ?";
        PreparedStatement p = CourseInstructorDAL.getConnection().prepareStatement(query);
        p.setString(1, c.getCourseID() + " ");
        p.setString(2, c.getPersonID() + " ");
        int result = p.executeUpdate();
        return result;
    }
     
     public int deleteCourseInstructor(CourseInstructor c) throws SQLException {
        int result = -1;
        String query = "DELETE courseinstructor WHERE courseid=?, personid=?";
        PreparedStatement p = CourseInstructorDAL.getConnection().prepareStatement(query);
        p.setString(1, c.getCourseID() + " ");
        p.setString(2, c.getPersonID() + " ");
        
        result = p.executeUpdate();
        return result;
    }
    
    public boolean isCourseInstructed(int id){
        boolean result = false ;
        try {
            String sql ="SELECT * FROM courseinstructor WHERE courseid = " + id ;
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
