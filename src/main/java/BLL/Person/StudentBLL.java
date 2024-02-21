package BLL.Person;

import DAL.Student.StudentDAL;
import java.util.ArrayList;

public class StudentBLL {
    public ArrayList<String> readDSID(){
        StudentDAL std = new StudentDAL();
        ArrayList<String> list = std.readDSID();
        return list;
    }
}
