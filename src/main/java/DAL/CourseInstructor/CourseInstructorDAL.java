package DAL.CourseInstructor;

import ConnectDB.ConnectDB;
import com.mysql.cj.protocol.Resultset;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CourseInstructorDAL extends ConnectDB {

    CourseInstructor c = new CourseInstructor();


    public List<CourseInstructor> readCourseInstructor() {
        List<CourseInstructor> readCourseList = new ArrayList<>();

        String query = "SELECT * FROM course as ce, courseinstructor as c, person as p where c.personID "
                + "= p.personID and c.courseid = ce.courseid";
        ResultSet rs = CourseInstructorDAL.doReadQuery(query);

        if (rs != null) {
            int i = 1;
            try {
                while (rs.next()) {
                    CourseInstructor c = new CourseInstructor();
                    c.setPersonID(rs.getInt("PersonID"));
                    c.setCourseID(rs.getInt("CourseID"));
                    readCourseList.add(c);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CourseInstructorDAL.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return readCourseList;
    }

    /**
     *
     * @return @throws SQLException
     */
    public int insertCourseInstructor(CourseInstructor c) {
        try {
            String query = "INSERT courseinstructor(CourseID,PersonID) VALUE(?,?)";
            PreparedStatement p = CourseInstructorDAL.getConnection().prepareStatement(query);
            p.setInt(1, c.getCourseID());
            p.setInt(2, c.getPersonID());
            p.executeUpdate();

            int generakey = 0;
            try (ResultSet generatedKeys = p.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    generakey = generatedKeys.getInt(1);
                }
            }
            return generakey;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        return 0;
    }

    public boolean updateCourseInstructor(CourseInstructor newCourseInstructor) {
        try {
            String query = "UPDATE courseinstructor set CourseID = ?, PersonID = ? where CourseID = ?, PersonID = ?";
            PreparedStatement p = CourseInstructorDAL.getConnection().prepareStatement(query);
            p.setInt(1, newCourseInstructor.getCourseID());
            p.setInt(2, newCourseInstructor.getPersonID());
            p.executeUpdate();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    public boolean deleteCourseInstructor(int CourseID){
        try {
            String query = "DELETE courseinstructor WHERE CourseID=?, PersonID=?";
            PreparedStatement p = CourseInstructorDAL.getConnection().prepareStatement(query);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
        return false;
    }

    public List findCourseInstructor(String sql) throws SQLException {
        String query = "SELECT * FROM course as ce, courseinstructor as c, person as p where c.PersonID ="
                + " p.PersonID and c.CourseID = ce.CourseID";
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

    public List getPersonIDFromCourseInstructor(String personID) throws SQLException {

        String query = "SELECT PersonID FROM courseinstructor WHERE PersonID = ? ";

        PreparedStatement p = CourseInstructorDAL.getConnection().prepareStatement(query);
        p.setString(1, personID);

        ResultSet rs = p.executeQuery();
        List list = new ArrayList();

        if (rs != null) {

            while (rs.next()) {
                CourseInstructor s = new CourseInstructor();
                s.setPersonID(rs.getInt("PersonID"));

                list.add(s);
            }
        }
        return list;

    }

}
