package DAL.StudentGrade;

import ConnectDB.ConnectDB;
import DAL.Student.Student;
import java.sql.Connection;
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

    public List<List<Object>> searchStudentGradeByCourseID(String courseID) {
        List<List<Object>> searchResult = new ArrayList<>();
        try {
            // Kiểm tra xem chuỗi đầu vào có hợp lệ không
            if (courseID.matches("\\d+")) { // Kiểm tra xem chuỗi chỉ chứa các ký tự số hay không
                String query = "SELECT sg.EnrollmentID, sg.CourseID, sg.StudentID, sg.Grade, p.Lastname, p.Firstname, c.Title "
                        + "FROM studentgrade sg "
                        + "INNER JOIN course c ON sg.CourseID = c.CourseID "
                        + "INNER JOIN person p ON sg.StudentID = p.PersonID "
                        + "WHERE sg.CourseID LIKE ?";
                PreparedStatement statement = getConnection().prepareStatement(query);
                statement.setString(1, "%" + courseID + "%"); // Sử dụng LIKE để tìm kiếm các CourseID chứa chuỗi đầu vào
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    List<Object> studentGradeInfo = new ArrayList<>();
                    studentGradeInfo.add(rs.getInt("EnrollmentID"));
                    studentGradeInfo.add(rs.getInt("CourseID"));
                    studentGradeInfo.add(rs.getInt("StudentID"));
                    studentGradeInfo.add(rs.getFloat("Grade"));
                    studentGradeInfo.add(rs.getString("Lastname") + " " + rs.getString("Firstname"));
                    studentGradeInfo.add(rs.getString("Title"));
                    searchResult.add(studentGradeInfo);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid input: Please enter a valid Course ID");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        return searchResult;
    }

    public List<List<Object>> searchStudentGradeByStudentID(String studentID) {
        List<List<Object>> searchResult = new ArrayList<>();
        try {
            // Kiểm tra xem chuỗi đầu vào có hợp lệ không
            if (studentID.matches("\\d+")) { // Kiểm tra xem chuỗi chỉ chứa các ký tự số hay không
                String query = "SELECT sg.EnrollmentID, sg.CourseID, sg.StudentID, sg.Grade, p.Lastname, p.Firstname, c.Title "
                        + "FROM studentgrade sg "
                        + "INNER JOIN course c ON sg.CourseID = c.CourseID "
                        + "INNER JOIN person p ON sg.StudentID = p.PersonID "
                        + "WHERE sg.StudentID LIKE ?";
                PreparedStatement statement = getConnection().prepareStatement(query);
                statement.setString(1, "%" + studentID + "%"); // Sử dụng LIKE để tìm kiếm các CourseID chứa chuỗi đầu vào

                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    List<Object> studentGradeInfo = new ArrayList<>();
                    studentGradeInfo.add(rs.getInt("EnrollmentID"));
                    studentGradeInfo.add(rs.getInt("CourseID"));
                    studentGradeInfo.add(rs.getInt("StudentID"));
                    studentGradeInfo.add(rs.getFloat("Grade"));
                    studentGradeInfo.add(rs.getString("Lastname") + " " + rs.getString("Firstname"));
                    studentGradeInfo.add(rs.getString("Title"));
                    searchResult.add(studentGradeInfo);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid input: Please enter a valid Course ID");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        return searchResult;
    }

    public List<List<Object>> searchStudentGradeByGrade(float grade) {
        List<List<Object>> searchResult = new ArrayList<>();
        try {
            String sql = "SELECT sg.EnrollmentID, sg.CourseID, sg.StudentID, sg.Grade, p.Lastname, p.Firstname, c.Title "
                    + "FROM studentgrade sg "
                    + "INNER JOIN course c ON sg.CourseID = c.CourseID "
                    + "INNER JOIN person p ON sg.StudentID = p.PersonID "
                    + "WHERE sg.Grade >= ? AND sg.Grade < ?";  // Sử dụng phép so sánh với một khoảng giá trị của grade

            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setFloat(1, grade);
            statement.setFloat(2, grade + 1); // Tìm kiếm các bản ghi có giá trị grade từ grade đến dưới (grade + 1)

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                List<Object> studentGradeInfo = new ArrayList<>();
                studentGradeInfo.add(rs.getInt("EnrollmentID"));
                studentGradeInfo.add(rs.getInt("CourseID"));
                studentGradeInfo.add(rs.getInt("StudentID"));
                studentGradeInfo.add(rs.getFloat("Grade"));
                studentGradeInfo.add(rs.getString("Lastname") + " " + rs.getString("Firstname"));
                studentGradeInfo.add(rs.getString("Title"));
                searchResult.add(studentGradeInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return searchResult;
    }

    public static List<Student> searchStudentByStudentName(String name) {
        String sql = "SELECT * FROM person WHERE Lastname LIKE ? OR Firstname LIKE ?";
        List<Student> students = new ArrayList<>();

        try (Connection conn = ConnectDB.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "%" + name + "%");
            pstmt.setString(2, "%" + name + "%");

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int personId = rs.getInt("PersonID");
                    String lastName = rs.getString("LastName");
                    String firstName = rs.getString("FirstName");
                    java.sql.Date enrollmentDate = rs.getDate("EnrollmentDate");

                    Student student = new Student(personId, lastName, firstName, enrollmentDate);
                    students.add(student);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return students;
    }

    public static List<List<Object>> searchStudentGradeByStudentName(String name) {
        List<List<Object>> searchResult = new ArrayList<>();
        try {
            // Sử dụng LIKE để tìm kiếm theo tên sinh viên
            String query = "SELECT sg.EnrollmentID, sg.CourseID, sg.StudentID, sg.Grade, p.Lastname, p.Firstname, c.Title "
                    + "FROM studentgrade sg "
                    + "INNER JOIN course c ON sg.CourseID = c.CourseID "
                    + "INNER JOIN person p ON sg.StudentID = p.PersonID "
                    + "WHERE CONCAT(p.Lastname, ' ', p.Firstname) LIKE ?";
            PreparedStatement statement = getConnection().prepareStatement(query);
            statement.setString(1, "%" + name + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                List<Object> studentGradeInfo = new ArrayList<>();
                studentGradeInfo.add(rs.getInt("EnrollmentID"));
                studentGradeInfo.add(rs.getInt("CourseID"));
                studentGradeInfo.add(rs.getInt("StudentID"));
                studentGradeInfo.add(rs.getFloat("Grade"));
                studentGradeInfo.add(rs.getString("Lastname") + " " + rs.getString("Firstname"));
                studentGradeInfo.add(rs.getString("Title"));
                searchResult.add(studentGradeInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return searchResult;
    }

    public static List<List<Object>> searchStudentGradeByCourseName(String name) {
        List<List<Object>> searchResult = new ArrayList<>();
        try {
            // Sử dụng LIKE để tìm kiếm theo tên của khóa học
            String query = "SELECT sg.EnrollmentID, sg.CourseID, sg.StudentID, sg.Grade, p.Lastname, p.Firstname, c.Title "
                    + "FROM studentgrade sg "
                    + "INNER JOIN course c ON sg.CourseID = c.CourseID "
                    + "INNER JOIN person p ON sg.StudentID = p.PersonID "
                    + "WHERE c.Title LIKE ?";
            PreparedStatement statement = getConnection().prepareStatement(query);
            statement.setString(1, "%" + name + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                List<Object> studentGradeInfo = new ArrayList<>();
                studentGradeInfo.add(rs.getInt("EnrollmentID"));
                studentGradeInfo.add(rs.getInt("CourseID"));
                studentGradeInfo.add(rs.getInt("StudentID"));
                studentGradeInfo.add(rs.getFloat("Grade"));
                studentGradeInfo.add(rs.getString("Lastname") + " " + rs.getString("Firstname"));
                studentGradeInfo.add(rs.getString("Title"));
                searchResult.add(studentGradeInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return searchResult;
    }
}
