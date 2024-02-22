package BLL.Person;

import DAL.Student.Student;
import DAL.Student.StudentDAL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentBLL {
    public static List<Student> getAllStudents(){
        return StudentDAL.getAllStudents();
    }
    
    public static int getMaxpersonID(){
        return StudentDAL.getMaxpersonID();
    }

    public static boolean addStudent(Student newStudent) {
         return StudentDAL.addStudent(newStudent);
    }
     
    public static boolean deletePerson(int personId) {
        return StudentDAL.deletePerson(personId);
    }
    
    public static boolean editStudent(Student updatedStudent) {
        return StudentDAL.editStudent(updatedStudent);
    }
    
     public static List<Student> searchStudentByName(String name) {
        return StudentDAL.searchStudentByName(name);
    }
    
    public static ArrayList<String> readDSID(){
        StudentDAL std = new StudentDAL();
        ArrayList<String> list = std.readDSID();
        return list;
    }

}
