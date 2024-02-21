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

    public List<List<Object>> readStudent() {
        List<List<Object>> studentGradeList = new ArrayList<>();
        try {
            String sql = "SELECT sg.EnrollmentID, sg.CourseID, sg.StudentID, sg.Grade, p.Lastname, p.Firstname, c.Title "
                    + "FROM studentgrade sg "
                    + "INNER JOIN course c ON sg.CourseID = c.CourseID "
                    + "INNER JOIN person p ON sg.StudentID = p.PersonID "
                    + "ORDER BY sg.EnrollmentID ASC";
            ResultSet rs = this.doReadQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    List<Object> studentGradeInfo = new ArrayList<>();

                    studentGradeInfo.add(rs.getInt("EnrollmentID"));
                    studentGradeInfo.add(rs.getInt("CourseID"));
                    studentGradeInfo.add(rs.getInt("StudentID"));
                    studentGradeInfo.add(rs.getFloat("Grade"));
                    studentGradeInfo.add(rs.getString("Lastname") + " " + rs.getString("Firstname"));
                    studentGradeInfo.add(rs.getString("Title"));

                    studentGradeList.add(studentGradeInfo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentGradeList;
    }

    public int InsertStudentGradeDAL(int CourseID, int StudenID, float Grade) {
        try {
            String sql = "INSERT INTO studentgrade(`CourseID`, `StudentID`, `Grade`) VALUES (?, ? ,?)";
            PreparedStatement pre = this.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pre.setInt(1, CourseID);
            pre.setInt(2, StudenID);
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
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
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

    public List<List<Object>> searchStudentGrade(String searchQuery) {
        List<List<Object>> studentGradeList = new ArrayList<>();
        try {
            String sql = "SELECT sg.EnrollmentID, sg.CourseID, sg.StudentID, sg.Grade, p.Lastname, p.Firstname, c.Title "
                    + "FROM studentgrade sg "
                    + "INNER JOIN course c ON sg.CourseID = c.CourseID "
                    + "INNER JOIN person p ON sg.StudentID = p.PersonID "
                    + "WHERE sg.Grade = ? OR sg.StudentID = ? OR sg.CourseID = ?";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setFloat(1, Float.parseFloat(searchQuery)); // Đối với Grade
            statement.setInt(2, Integer.parseInt(searchQuery)); // Đối với StudentID
            statement.setInt(3, Integer.parseInt(searchQuery)); // Đối với CourseID

            ResultSet rs = statement.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    List<Object> studentGradeInfo = new ArrayList<>();
                    studentGradeInfo.add(rs.getInt("EnrollmentID"));
                    studentGradeInfo.add(rs.getInt("CourseID"));
                    studentGradeInfo.add(rs.getInt("StudentID"));
                    studentGradeInfo.add(rs.getFloat("Grade"));
                    studentGradeInfo.add(rs.getString("Lastname") + " " + rs.getString("Firstname"));
                    studentGradeInfo.add(rs.getString("Title"));
                    studentGradeList.add(studentGradeInfo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentGradeList;
    }
}
