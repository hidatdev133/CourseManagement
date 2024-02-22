package DAL.Student;

import ConnectDB.ConnectDB;
import DAL.StudentGrade.StudentGradeDAL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAL extends ConnectDB {
    public static List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM person WHERE EnrollmentDate IS NOT NULL";
        try (Connection conn = ConnectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                int personId = rs.getInt("PersonID");
                String lastName = rs.getString("Lastname");
                String firstName = rs.getString("Firstname");
                java.sql.Date enrollmentDate = rs.getDate("EnrollmentDate");
                students.add(new Student(personId, lastName, firstName, enrollmentDate));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
    }
    return students;
    }
    
    public static boolean addStudent(Student student) {
        String sql = "INSERT INTO Person (PersonID, Lastname, Firstname, EnrollmentDate) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, student.getPersonId());
            pstmt.setString(2, student.getLastName());
            pstmt.setString(3, student.getFirstName());
            pstmt.setDate(4, new java.sql.Date(student.getEnrollmentDate().getTime()));
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public static boolean deletePerson(int personId) {
        try (Connection conn = ConnectDB.getConnection()){
            String sql = "DELETE FROM Person WHERE PersonID = " + personId;
            Statement stmt = conn.createStatement();
            int rowsAffected = stmt.executeUpdate(sql);
            return rowsAffected > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public static boolean editStudent(Student student) {
        String sql = "UPDATE person SET LastName=?, FirstName=?, EnrollmentDate=? WHERE PersonID=?";

        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, student.getLastName());
            pstmt.setString(2, student.getFirstName());
            pstmt.setDate(3, student.getEnrollmentDate());
            pstmt.setInt(4, student.getPersonId());

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public static List<Student> searchStudentByName(String name) {
        String sql = "SELECT * FROM person WHERE Lastname LIKE ? OR Firstname LIKE ?";
        List<Student> students = new ArrayList<>();

        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

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

    
    
    
    public static int getMaxpersonID(){
        int maxPersonID = 0;
        String sql = "SELECT MAX(PersonID) AS MaxPersonID FROM person";
        try (Connection conn = ConnectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                maxPersonID = rs.getInt("MaxPersonID");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
    }
        return maxPersonID;
    }

  
    public ArrayList<String> readDSID() {

        ArrayList<String> list = new ArrayList<>();
        try {
            String query = "SELECT PersonID FROM person WHERE EnrollmentDate>0";
            ResultSet rs = this.doReadQuery(query);
            if (rs != null) {
                while (rs.next()) {
                    String data = rs.getString("PersonID");
                    list.add(data);
                }
            }
            return list;
        } catch (Exception e) {
        }
        return list;
    }
}
