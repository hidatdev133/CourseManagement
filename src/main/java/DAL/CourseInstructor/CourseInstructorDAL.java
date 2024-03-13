package DAL.CourseInstructor;

import ConnectDB.ConnectDB;
import static ConnectDB.ConnectDB.connectDB;
import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CourseInstructorDAL extends ConnectDB {

    public CourseInstructorDAL() {
        super();
        connectDB();
    }
    
   public ArrayList<String> listcourseID(){
    ArrayList<String> list = new ArrayList<>();
    HashSet<String> uniqueValues = new HashSet<>();
    try {
        String query = "SELECT CourseID FROM course";
        ResultSet rs = this.doReadQuery(query);
        if(rs != null){
            while(rs.next()){
                String data = rs.getString("CourseID");
                // Kiểm tra xem giá trị đã tồn tại trong Set chưa
                if (!uniqueValues.contains(data)) {
                    // Nếu chưa tồn tại, thêm vào danh sách và Set
                    list.add(data);
                    uniqueValues.add(data);
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list;
}
    
   
    public boolean addCourseInstructor(CourseInstructor courseinstructor) {
        boolean success = false;
        String query = "INSERT INTO courseinstructor (CourseID, PersonID) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, courseinstructor.getCourseID());
            preparedStatement.setInt(2, courseinstructor.getPersonID());
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                success = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return success;
    }
    
    public List<CourseInstructor> readCourseInstructor(){
        String query = "SELECT ci.CourseID, c.Title, ci.PersonID, CONCAT(p.LastName, ' ', p.FirstName) AS TeacherName "
                + "FROM courseinstructor ci "
                + "INNER JOIN course c ON ci.CourseID = c.CourseID "
                + "INNER JOIN person p ON ci.PersonID = p.PersonID "
                + "WHERE p.HireDate IS NOT NULL";

        ResultSet rs = CourseInstructorDAL.doReadQuery(query);
        ArrayList<CourseInstructor> list = new ArrayList<>();

        if (rs != null) {
            try {
                while (rs.next()) {
                    CourseInstructor c = new CourseInstructor();
                    c.setCourseID(rs.getInt("CourseID"));
                    c.setTitle(rs.getString("Title"));
                    c.setPersonID(rs.getInt("PersonID"));
                    c.setTeacherName(rs.getString("TeacherName"));
                    list.add(c);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CourseInstructorDAL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

        public CourseInstructor readCourseInstructorByID(int courseID, int personID) {
            String query = "SELECT\n" +
    "    COALESCE(oc.Days, ' ') AS Days,\n" +
    "    COALESCE(oc.Time, ' ') AS Time,\n" +
    "    COALESCE(oc.Location, ' ') AS Location,\n" +
    "    c.Title,\n" +
    "    CONCAT(p.Firstname, ' ', p.Lastname) AS TeacherName \n" +
    "FROM\n" +
    "    courseinstructor ci\n" +
    "INNER JOIN course c ON ci.CourseID = c.CourseID \n" +
    "INNER JOIN person p ON ci.PersonID = p.PersonID \n" +
    "LEFT JOIN onsitecourse oc ON c.CourseID = oc.CourseID \n" +
    "WHERE\n" +
    "    ci.CourseID = ? AND ci.PersonID = ?";

            CourseInstructor courseInstructor = null;

            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                preparedStatement.setInt(1, courseID);
                preparedStatement.setInt(2, personID);
                ResultSet rs = preparedStatement.executeQuery();

                if (rs.next()) {
                    courseInstructor = new CourseInstructor();
                    courseInstructor.setCourseID(courseID);
                    courseInstructor.setPersonID(personID);
                    courseInstructor.setTitle(rs.getString("Title"));
                    courseInstructor.setDays(rs.getString("Days"));
                    courseInstructor.setTime(rs.getString("Time"));
                    courseInstructor.setLocations(rs.getString("Location"));
                    courseInstructor.setTeacherName(rs.getString("TeacherName"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(CourseInstructorDAL.class.getName()).log(Level.SEVERE, null, ex);
            }

            return courseInstructor;
        }


    

    public boolean isCourseInstructed(int id) {
        boolean result = false;
        try {
            String sql = "SELECT * FROM courseinstructor WHERE courseid = " + id;
            ResultSet rs = this.doReadQuery(sql);
            if (rs.next()) {
                result = true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }

    public List<String> getPersonIDsByCourseID(String courseID) {
        List<String> personIDs = new ArrayList<>();
        String query = "SELECT PersonID FROM courseinstructor WHERE CourseID = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setString(1, courseID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String personID = resultSet.getString("PersonID");
                    personIDs.add(personID);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return personIDs;
    }

    public boolean editCourseInstructorByCourseID(String courseID, String oldPersonID, String newPersonID) {
    boolean success = false;
    String deleteQuery = "DELETE FROM courseinstructor WHERE CourseID = ? AND PersonID = ?";
    String insertQuery = "INSERT INTO courseinstructor (CourseID, PersonID) VALUES (?, ?)";
    
    try {
        // Xóa dòng hiện tại với courseID đã chọn
        try (PreparedStatement deleteStatement = con.prepareStatement(deleteQuery)) {
            deleteStatement.setString(1, courseID);
            deleteStatement.setString(2, oldPersonID);
            deleteStatement.executeUpdate();
        }

        // Thêm dòng mới với courseID đã chọn và newPersonID từ combobox khác
        try (PreparedStatement insertStatement = con.prepareStatement(insertQuery)) {
            insertStatement.setString(1, courseID);
            insertStatement.setString(2, newPersonID);
            int rowsAffected = insertStatement.executeUpdate();
            if (rowsAffected > 0) {
                success = true;
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    
    return success;
}
    
   public static List<CourseInstructor> searchCourseByCourseID(String cbSearch, String ID) {
    String sql = "SELECT * FROM courseinstructor WHERE " + cbSearch + " LIKE ?";
    List<CourseInstructor> courseInstructors = new ArrayList<>();

    try (Connection conn = ConnectDB.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setString(1, "%" + ID + "%");

        try (ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                int courseID = rs.getInt("CourseID");
                int personID = rs.getInt("PersonID");

                CourseInstructor courseInstructor = new CourseInstructor(courseID, personID);
                courseInstructors.add(courseInstructor);
            }
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    return courseInstructors;
}
   
   public boolean deleteCourseInstructor(int courseID, int personID) {
        String sql = "DELETE FROM courseinstructor WHERE CourseID = ? AND PersonID = ?";

        try (Connection conn = ConnectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, courseID);
            pstmt.setInt(2, personID);

            pstmt.executeUpdate();
             return true;
        } catch (SQLException e) {
            System.out.println("Error deleting CourseInstructor: " + e.getMessage());
        }
        return false;
    }

   
    public int getTotalCourses(int personID) {
    String sql = "SELECT COUNT(CourseID) AS TotalCourses " +
                 "FROM courseinstructor " +
                 "WHERE PersonID = ?";

    int totalCourses = 1;

    // Sử dụng try-with-resources để đảm bảo tài nguyên được đóng đúng cách
    try (Connection conn = ConnectDB.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setInt(1, personID); // Thiết lập giá trị của personID

        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                totalCourses = rs.getInt("TotalCourses");
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return totalCourses;
}

   

//    public List<String> getCourseDsByPersonID(String personID) {
//        List<String> courseIDs = new ArrayList<>();
//        String query = "SELECT CourseID FROM courseinstructor WHERE PersonID = ?";
//        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
//            preparedStatement.setString(1, personID);
//            try (ResultSet resultSet = preparedStatement.executeQuery()) {
//                while (resultSet.next()) {
//                    String courseID = resultSet.getString("CourseID");
//                    courseIDs.add(courseID);
//                }
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return courseIDs;
//    }
//    
//     // Phương thức để kiểm tra xem courseID cần thêm có xung đột với các courseID đã có không
//    public boolean checkCourseConflict(String personID, String courseIDToCheck) {
//        List<String> existingCourseIDs = getCourseDsByPersonID(personID);
//        for (String existingCourseID : existingCourseIDs) {
//            if (compareCourses(existingCourseID, courseIDToCheck)) {
//                return true;
//            }
//        }
//        return false;
//    }
//    
//    private boolean compareCourses(String courseID1, String courseID2) {
//        String query = "SELECT Days, Time FROM onsitecourse WHERE CourseID = ?";
//        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
//            // Lấy danh sách các ngày học và thời gian của courseID1
//            preparedStatement.setString(1, courseID1);
//            ResultSet resultSet1 = preparedStatement.executeQuery();
//            resultSet1.next(); // Di chuyển con trỏ đến hàng đầu tiên
//            String days1 = resultSet1.getString("Days");
//            String time1 = resultSet1.getString("Time");
//
//            // Lấy danh sách các ngày học và thời gian của courseID2
//            preparedStatement.setString(1, courseID2);
//            ResultSet resultSet2 = preparedStatement.executeQuery();
//            resultSet2.next(); // Di chuyển con trỏ đến hàng đầu tiên
//            String days2 = resultSet2.getString("Days");
//            String time2 = resultSet2.getString("Time");
//
//            // Kiểm tra xem ngày học có giống nhau không
//            boolean daysMatch = false;
//            for (int i = 0; i < days1.length(); i++) {
//                for (int j = 0; j < days2.length(); j++) {
//                    if (days1.charAt(i) == days2.charAt(j)) {
//                        daysMatch = true;
//                        break;
//                    }
//                }
//                if (daysMatch)
//                    break;
//            }
//
//            // Nếu ngày học giống nhau, kiểm tra thời gian
//            if (daysMatch && time1.equals(time2)) {
//                return true; // Có xung đột về thời gian
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return false; // Không có xung đột
//    }
    
}

    