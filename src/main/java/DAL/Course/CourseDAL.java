package DAL.Course;

import java.sql.ResultSet;
import java.util.ArrayList;
import ConnectDB.ConnectDB;


public class CourseDAL extends ConnectDB {
    public ArrayList<String> readDSID(){
        ArrayList<String> list = new ArrayList<>();
        try {
            String query = "SELECT CourseID FROM course";
            ResultSet rs = this.doReadQuery(query);
            if(rs !=null){
                while(rs.next()){
                    String data = rs.getString("CourseID");
                    list.add(data);
                }
            }
            return list;
        } catch (Exception e) {
        }
        return list;
    }
}
