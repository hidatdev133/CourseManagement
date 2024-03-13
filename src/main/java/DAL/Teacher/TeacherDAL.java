package DAL.Teacher;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import ConnectDB.ConnectDB;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDateTime;

public class TeacherDAL extends ConnectDB {
    public List<Teacher> readTeacher() {
        List<Teacher> teacherList = new ArrayList<>();
        
        try {
            String sql = "SELECT p.PersonID, p.FirstName, p.LastName, p.HireDate FROM person p";
            ResultSet rs = this.doReadQuery(sql);
            
            if (rs != null) {
                while (rs.next()) {                
                    Teacher t = new Teacher();
                    t.setTeacherID(rs.getInt("PersonId"));
                    t.setFirstName(rs.getString("FirstName"));
                    t.setLastName(rs.getString("LastName"));
                    t.setHireDate(rs.getDate("HireDate"));
                    
                    teacherList.add(t);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return teacherList;
    }
    
     public ArrayList<Integer> readDSIDbyOrdered() {

        ArrayList<Integer> list = new ArrayList<>();
        try {
            String query = "SELECT PersonID FROM person WHERE HireDate>0 ORDER BY PersonID ASC";
            ResultSet rs = this.doReadQuery(query);
            if (rs != null) {
                while (rs.next()) {
                    int data = rs.getInt("PersonID");
                    list.add(data);
                }
            }
            return list;
        } catch (Exception e) {
        }
        return list;
    }
    
    public int insertTeacherDAL(Teacher teacher) {
        int generatekey = 0;

        try {
            String sql = "INSERT INTO person(`LastName`, `FirstName`, `HireDate`) VALUES (?,?,?)";
            PreparedStatement stmt = this.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            stmt.setString(1, teacher.getLastName());
            stmt.setString(2, teacher.getFirstName());
            stmt.setDate(3, teacher.getHireDate());
            
            stmt.executeUpdate();
            
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    generatekey = generatedKeys.getInt(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return generatekey;
    }
    
    public boolean deleteTeacherDAL(int teacherID) {
        try {
            String sql = "DELETE FROM person WHERE `PersonId` = '" + teacherID + "'";
            PreparedStatement stmt = this.getConnection().prepareStatement(sql);
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean updateTeacherDAL(Teacher newTeacher) {
        try {
            System.out.println(newTeacher.getLastName());
            String sql = "UPDATE person SET `LastName`=?, `FirstName`=?, `HireDate`=? WHERE `PersonID` = '" + newTeacher.getTeacherID()+ "'";
            PreparedStatement stmt = this.getConnection().prepareStatement(sql);
            stmt.setString(1, newTeacher.getLastName());
            stmt.setString(2, newTeacher.getFirstName());
            stmt.setDate(3, newTeacher.getHireDate());
            
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public List<Teacher> searchTeacherDAL(String query) {
        List<Teacher> teacherList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM person p WHERE p.LastName LIKE ? OR p.FirstName LIKE ?";
            PreparedStatement stmt = this.getConnection().prepareStatement(sql);
            stmt.setString(1, "%" + query + "%");
            stmt.setString(2, "%" + query + "%");

            ResultSet rs = stmt.executeQuery();
            if (rs != null) {
                while (rs.next()) {                    
                    Teacher t = new Teacher();
                    
                    t.setTeacherID(rs.getInt("PersonID"));
                    t.setLastName(rs.getString("LastName"));
                    t.setFirstName(rs.getString("FirstName"));
                    t.setHireDate(rs.getDate("HireDate"));
                    
                    teacherList.add(t);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return teacherList;
    }
    
    public ArrayList<String> readDSID() {

        ArrayList<String> list = new ArrayList<>();
        try {
            String query = "SELECT PersonID FROM person WHERE HireDate>0";
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
