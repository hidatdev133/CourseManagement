package DAL.StudentGrade;


import ConnectDB.ConnectDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class StudentGradeDAL extends ConnectDB {

    public List readStudent() {
        List list = new ArrayList();
        try {
            String sql = "SELECT studentgrade*. , Lastname , Firstname , Title FROM `course`, `person`, `studentgrade` "
                    + "WHERE studentgrade.CourseID = course.CourseID AND StudentID = PersonID ORDER By EnrollmentID ASC";
            ResultSet rs = this.doReadQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    List list2 = new ArrayList();
                    StudentGrade stg = new StudentGrade();

                    stg.setEnrollmentID(rs.getInt("EnrollmentID"));
                    stg.setCourseID(rs.getInt("CourseID"));
                    stg.setStudentID(rs.getInt("StudentID"));
                    stg.setGrade(rs.getFloat("Grade"));

                    String fullname = rs.getString("Lastname") + " " + rs.getString("Firstname");
                    String title = rs.getString("Title");

                    list2.add(stg);
                    list2.add(fullname);
                    list2.add(title);
                    list.add(list2);
                }
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
        return list;
    }

    public List findStudentByGrade(float Grade) {
        List list = new ArrayList();
        try {
            String sql = "SELECT studentgrade.* , Lastname, Firstname FROM `course`, `person`, `studentgrade`"
                    + "WHERE studentgrade.CourseID = course.CourseID AND StudentID = PersonID AND Grade = '" + Grade + "' ORDER By EnrollmentID ASC";
            ResultSet rs = this.doReadQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    List list2 = new ArrayList();
                    StudentGrade stg = new StudentGrade();

                    stg.setEnrollmentID(rs.getInt("EnrollmentID"));
                    stg.setCourseID(rs.getInt("CourseID"));
                    stg.setStudentID(rs.getInt("StudentID"));
                    stg.setGrade(rs.getFloat("Grade"));

                    String fullname = rs.getString("Lastname") + " " + rs.getString("Firstname");
                    String title = rs.getString("Title");

                    list2.add(stg);
                    list2.add(fullname);
                    list2.add(title);
                    list.add(list2);
                }
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
        return list;
    }

    public int InsertStudentGradeDAL(int CourseID, int studenID, float Grade) {
        try {
            String sql = "INSERT INTO studentgrade(`CourseID`, `StudentID`, `Grade`) VALUES (?, ? ,?)";
            PreparedStatement pre = this.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pre.setInt(1, CourseID);
            pre.setInt(2, studenID);
            pre.setFloat(3, Grade);
            pre.executeUpdate();

            int generakey = 0;
            try (ResultSet generatedKeys = pre.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    generakey = generatedKeys.getInt(1);
                }
            }
            return generakey;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
        return 0;
    }

    public boolean deleteStudentgradeDAL(int EnrollmentID) {
        try {
            String sql = "DELETE FROM studentgrade WHERE `EnrollMentID` = '" + EnrollmentID + "'";
            PreparedStatement stament = this.getConnection().prepareStatement(sql);
            stament.executeUpdate();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
        return false;
    }

    public boolean editStudentGrade(int EnrollmentID, int CourseID, int StudentID, float Grade) {
        try {
            String query = "UPDATE studentgrade SET `CourseID`=?,`StudentID`=?,`Grade`=? WHERE `EnrollmentID` = '" + EnrollmentID + "'";
            PreparedStatement stament = this.getConnection().prepareStatement(query);
            stament.setInt(1, CourseID);
            stament.setInt(2, StudentID);
            stament.setFloat(3, Grade);
            stament.executeUpdate();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    public List getCourseIDFromStudentGrade(int courseID) throws SQLException {

        String query = "SELECT CourseID FROM studentgrade WHERE CourseID = ?";

        PreparedStatement p = this.getConnection().prepareStatement(query);
        p.setInt(1, courseID);
        ResultSet rs = p.executeQuery();
        List list = new ArrayList();

        if (rs != null) {

            while (rs.next()) {
                StudentGrade s = new StudentGrade();
                s.setCourseID(rs.getInt("CourseID"));
                list.add(s);
            }
        }
        return list;

    }

    public List getStudentIDFromStudentGrade(int studentID) throws SQLException {

        String query = "SELECT StudentID FROM studentgrade WHERE StudentID = ? ";

        PreparedStatement p = this.getConnection().prepareStatement(query);
        p.setInt(1, studentID);
        ResultSet rs = p.executeQuery();
        List list = new ArrayList();

        if (rs != null) {

            while (rs.next()) {

                StudentGrade s = new StudentGrade();
                s.setStudentID(rs.getInt("StudentID"));
                list.add(s);
            }
        }
        return list;

    }
}
