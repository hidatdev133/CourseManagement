package DAL.StudentGrade;

import ConnectDB.ConnectDB;
import DAL.Student.Student;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class StudentGradeDAL extends ConnectDB {

    public List<List<Object>> readStudentGrade() {
        List<List<Object>> studentGradeList = new ArrayList<>();
        try {
            String sql = "SELECT sg.EnrollmentID, sg.CourseID, sg.StudentID, "
                    + "CASE WHEN sg.Grade IS NULL THEN '' ELSE sg.Grade END AS Grade, "
                    + "p.Lastname, p.Firstname, c.Title "
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
                    studentGradeInfo.add(rs.getString("Lastname") + " " + rs.getString("Firstname"));

                    studentGradeInfo.add(rs.getString("Title"));
// Check if grade is 0.0, then add empty string, otherwise add grade value
                    String grade = rs.getFloat("Grade") == 0.0 ? "" : String.valueOf(rs.getFloat("Grade"));
                    studentGradeInfo.add(grade);
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

    public boolean editStudentGrade(int EnrollmentID, int CourseID, int StudentID, BigDecimal Grade) {
        try {
            // Sử dụng câu truy vấn SQL để cập nhật dữ liệu trong bảng cơ sở dữ liệu
            String query = "UPDATE studentgrade SET `CourseID`=?, `StudentID`=?, `Grade`=? WHERE `EnrollmentID`=?";
            PreparedStatement statement = this.getConnection().prepareStatement(query);
            statement.setInt(1, CourseID);
            statement.setInt(2, StudentID);
            statement.setBigDecimal(3, Grade);
            statement.setInt(4, EnrollmentID);

            // Thực thi truy vấn và kiểm tra xem có bao nhiêu dòng đã được cập nhật
            int rowsUpdated = statement.executeUpdate();

            // Nếu có ít nhất một dòng đã được cập nhật, trả về true
            if (rowsUpdated > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace(); // In ra lỗi nếu có bất kỳ lỗi nào xảy ra
        }
        return false; // Trả về false nếu có lỗi xảy ra
    }

    public List<List<Object>> searchStudentGradeByCourseID(String courseID) {
        List<List<Object>> searchResult = new ArrayList<>();
        try {
            // Kiểm tra xem chuỗi đầu vào có hợp lệ không
            if (courseID.matches("\\d+")) { // Kiểm tra xem chuỗi chỉ chứa các ký tự số hay không
                String query = "SELECT sg.EnrollmentID, sg.CourseID, sg.StudentID, "
                        + "CASE WHEN sg.Grade IS NULL THEN '' ELSE sg.Grade END AS Grade, "
                        + "p.Lastname, p.Firstname, c.Title "
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
                    studentGradeInfo.add(rs.getString("Lastname") + " " + rs.getString("Firstname"));
                    studentGradeInfo.add(rs.getString("Title"));
                    studentGradeInfo.add(rs.getString("Grade")); // Đã thêm điều kiện CASE trong truy vấn SQL

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
                String query = "SELECT sg.EnrollmentID, sg.CourseID, sg.StudentID, "
                        + "CASE WHEN sg.Grade IS NULL THEN '' ELSE sg.Grade END AS Grade, "
                        + "p.Lastname, p.Firstname, c.Title "
                        + "FROM studentgrade sg "
                        + "INNER JOIN course c ON sg.CourseID = c.CourseID "
                        + "INNER JOIN person p ON sg.StudentID = p.PersonID "
                        + "WHERE sg.StudentID LIKE ?";
                PreparedStatement statement = getConnection().prepareStatement(query);
                statement.setString(1, "%" + studentID + "%"); // Sử dụng LIKE để tìm kiếm các StudentID chứa chuỗi đầu vào

                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    List<Object> studentGradeInfo = new ArrayList<>();

                    studentGradeInfo.add(rs.getInt("EnrollmentID"));
                    studentGradeInfo.add(rs.getInt("CourseID"));
                    studentGradeInfo.add(rs.getInt("StudentID"));
                    studentGradeInfo.add(rs.getString("Lastname") + " " + rs.getString("Firstname"));
                    studentGradeInfo.add(rs.getString("Title"));
                    studentGradeInfo.add(rs.getString("Grade")); // Đã thêm điều kiện CASE trong truy vấn SQL

                    searchResult.add(studentGradeInfo);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid input: Please enter a valid Student ID");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        return searchResult;
    }

    public List<List<Object>> searchStudentGradeByGrade(float grade) {
        List<List<Object>> searchResult = new ArrayList<>();
        try {
            String sql = "SELECT sg.EnrollmentID, sg.CourseID, sg.StudentID, "
                    + "CASE WHEN sg.Grade IS NULL THEN '' ELSE sg.Grade END AS Grade, "
                    + "p.Lastname, p.Firstname, c.Title "
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
                studentGradeInfo.add(rs.getString("Lastname") + " " + rs.getString("Firstname"));
                studentGradeInfo.add(rs.getString("Title"));
                studentGradeInfo.add(rs.getFloat("Grade"));

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
            String query = "SELECT sg.EnrollmentID,  sg.CourseID, sg.StudentID, sg.Grade, p.Lastname, p.Firstname, c.Title "
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
                studentGradeInfo.add(rs.getString("Lastname") + " " + rs.getString("Firstname"));
                studentGradeInfo.add(rs.getString("Title"));
                studentGradeInfo.add(rs.getFloat("Grade"));

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
            String query = "SELECT sg.EnrollmentID, sg.CourseID, sg.StudentID, "
                    + "CASE WHEN sg.Grade IS NULL THEN '' ELSE sg.Grade END AS Grade, "
                    + "p.Lastname, p.Firstname, c.Title "
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
                studentGradeInfo.add(rs.getString("Lastname") + " " + rs.getString("Firstname"));
                studentGradeInfo.add(rs.getString("Title"));
                studentGradeInfo.add(rs.getString("Grade")); // Đã thêm điều kiện CASE trong truy vấn SQL

                searchResult.add(studentGradeInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return searchResult;
    }

    public int getAmountStudentByIDCourse(int id){
        try{
            String sql="SELECT COUNT(studentgrade.StudentID) FROM studentgrade  WHERE studentgrade.CourseID="+id;
            ResultSet rs=this.doReadQuery(sql);
            while(rs.next()){
              return rs.getInt(1);
            }
        }catch(Exception e){
            e.printStackTrace();
    }
        return 0;
    }


    public int getMaxEnrollmentID() {
        try {
            String sql = "SELECT MAX(EnrollmentID) AS MaxEnrollmentID FROM studentgrade";
            PreparedStatement pre = this.getConnection().prepareStatement(sql);
            ResultSet rs = pre.executeQuery();

            if (rs.next()) {
                return rs.getInt("MaxEnrollmentID");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        return 0;
    }

    // Hàm lấy tên sinh viên dựa trên StudentID
    public String getStudentName(int studentID) {
        try {
            String sql = "SELECT CONCAT(Lastname, ' ', Firstname) AS StudentName FROM person WHERE PersonID = ?";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setInt(1, studentID);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getString("StudentName");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Trả về null nếu không tìm thấy sinh viên
    }

    // Hàm lấy tên khóa học dựa trên CourseID
    public String getTitle(int courseID) {
        try {
            String sql = "SELECT Title FROM course WHERE CourseID = ?";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setInt(1, courseID);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getString("Title");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Trả về null nếu không tìm thấy khóa học
    }

    public boolean isCourseIDExists(int courseID) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Tạo câu truy vấn SQL để kiểm tra sự tồn tại của courseID trong bảng Course
            String sql = "SELECT COUNT(*) FROM Course WHERE CourseID = ?";
            preparedStatement = getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, courseID);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý lỗi nếu có
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                // Xử lý lỗi nếu có
            }
        }
        return false;
    }

    public boolean isStudentIDExists(int studentID) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Tạo câu truy vấn SQL để kiểm tra sự tồn tại của courseID trong bảng Course
            String sql = "SELECT COUNT(*) FROM Course WHERE StudentID = ?";
            preparedStatement = getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, studentID);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý lỗi nếu có
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                // Xử lý lỗi nếu có
            }
        }
        return false;
    }

    //Them
    public List<StudentGrade> readSG() {
        List<StudentGrade> studentGradeList = new ArrayList<>();
        try {
            String sql = "SELECT sg.EnrollmentID, sg.CourseID, sg.StudentID, "
                    + "CASE WHEN sg.Grade IS NULL THEN '' ELSE sg.Grade END AS Grade, "
                    + "p.Lastname, p.Firstname, c.Title "
                    + "FROM studentgrade sg "
                    + "INNER JOIN course c ON sg.CourseID = c.CourseID "
                    + "INNER JOIN person p ON sg.StudentID = p.PersonID "
                    + "ORDER BY sg.EnrollmentID ASC";
            ResultSet rs = this.doReadQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    StudentGrade studentGrade = new StudentGrade();
                    studentGrade.setEnrollmentID(rs.getInt("EnrollmentID"));
                    studentGrade.setCourseID(rs.getInt("CourseID"));
                    studentGrade.setStudentID(rs.getInt("StudentID"));

                    // Check if grade is 0.0, then add empty string, otherwise add grade value
                    String gradeValue = rs.getString("Grade");
                    String grade = (gradeValue == "") ? "0.0" : String.valueOf(gradeValue);

                    studentGrade.setGrade(Float.parseFloat(grade));

                    studentGradeList.add(studentGrade);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentGradeList;
    }

    public List<List<Object>> searchStudentGradeByGradeRange(float minGrade, float maxGrade) {
        List<List<Object>> searchResult = new ArrayList<>();
        try {
            String sql = "SELECT sg.EnrollmentID, sg.CourseID, sg.StudentID, "
                    + "CASE WHEN sg.Grade IS NULL THEN '' ELSE sg.Grade END AS Grade, "
                    + "p.Lastname, p.Firstname, c.Title "
                    + "FROM studentgrade sg "
                    + "INNER JOIN course c ON sg.CourseID = c.CourseID "
                    + "INNER JOIN person p ON sg.StudentID = p.PersonID "
                    + "WHERE sg.Grade >= ? AND sg.Grade <= ? "
                    + "ORDER BY sg.EnrollmentID ASC";

            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setFloat(1, minGrade);
            statement.setFloat(2, maxGrade);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                List<Object> studentGradeInfo = new ArrayList<>();
                studentGradeInfo.add(rs.getInt("EnrollmentID"));
                studentGradeInfo.add(rs.getInt("CourseID"));
                studentGradeInfo.add(rs.getInt("StudentID"));
                studentGradeInfo.add(rs.getString("Lastname") + " " + rs.getString("Firstname"));
                studentGradeInfo.add(rs.getString("Title"));

                // Check if grade is 0.0, then add empty string, otherwise add grade value
                String grade = rs.getFloat("Grade") == 0.0 ? "" : String.valueOf(rs.getFloat("Grade"));
                studentGradeInfo.add(grade);

                searchResult.add(studentGradeInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return searchResult;
    }

    //------------------------------------------------------------------
    public StudentGrade readStudenGradeByIDs(int courseID, int studentID) {
        String sql = "SELECT\n"
                + "    sg.CourseID,\n"
                + "    sg.StudentID,\n"
                + "    sg.Grade,\n"
                + "    c.Title,\n"
                + "    c.Credits,\n"
                + "    c.DepartmentID,\n"
                + "    oc.url,\n"
                + "    oc.Location,\n"
                + "    oc.Days,\n"
                + "    oc.Time\n"
                + "FROM\n"
                + "    StudentGrade sg\n"
                + "INNER JOIN Course c ON sg.CourseID = c.CourseID\n"
                + "LEFT JOIN OnlineCourse oc ON sg.CourseID = oc.CourseID\n"
                + "LEFT JOIN OnsiteCourse os ON sg.CourseID = os.CourseID\n"
                + "WHERE\n"
                + "    sg.CourseID = ? AND sg.StudentID = ?;";
        StudentGrade studentGrade = null;

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, courseID);
            preparedStatement.setInt(2, studentID);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                studentGrade = new StudentGrade();
                studentGrade.setCourseID(courseID);
                studentGrade.setStudentID(studentID);
                studentGrade.setCourseName(rs.getString("Title"));
                studentGrade.setGrade(rs.getFloat("Grade"));
                studentGrade.setTime(rs.getString("Time"));
                studentGrade.setDays(rs.getString("Days"));
                studentGrade.setLocation(rs.getString("Location"));
                studentGrade.setStudentName(rs.getString("TeacherName"));
                studentGrade.setUrl(rs.getString("Url"));
                studentGrade.setCredits(rs.getString("Credits"));
                studentGrade.setDepartmendID(rs.getString("DepartmentID"));
                

            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentGradeDAL.class.getName()).log(Level.SEVERE, null, ex);
        }

        return studentGrade;
    }

}
