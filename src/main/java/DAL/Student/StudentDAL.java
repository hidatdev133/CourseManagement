package DAL.Student;
import ConnectDB.ConnectDB;
<<<<<<< Updated upstream
=======
import java.sql.Connection;
import java.sql.PreparedStatement;
>>>>>>> Stashed changes
import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentDAL extends ConnectDB {

<<<<<<< Updated upstream
=======
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

            pstmt.setString(1, name + "%");
            pstmt.setString(2, name + "%");

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

  
>>>>>>> Stashed changes
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
