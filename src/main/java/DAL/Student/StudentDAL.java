package DAL.Student;

import ConnectDB.ConnectDB;
import DAL.StudentGrade.StudentGradeDAL;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAL extends ConnectDB {

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
