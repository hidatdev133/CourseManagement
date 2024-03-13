package BLL.Person;

import DAL.Teacher.TeacherDAL;
import DAL.Teacher.Teacher;
import DAL.Teacher.TeacherDAL;
import java.util.ArrayList;
import java.util.List;

public class TeacherBLL {
    private TeacherDAL teacherDAL;

    public TeacherBLL() {
        this.teacherDAL = new TeacherDAL();
    }
    
    public List<Teacher> readTeacher() {
        return teacherDAL.readTeacher();
    }
    
    public int insertTeacherBLL(Teacher teacher) {
        return teacherDAL.insertTeacherDAL(teacher);
    }
    
    public boolean deleteTeacherBLL(int teacherID) {
        return teacherDAL.deleteTeacherDAL(teacherID);
    }
    
    public boolean updateTeacherBLL(Teacher teacher) {
        return teacherDAL.updateTeacherDAL(teacher);
    }
    
    public List<Teacher> searchTeacherBLL(String query) {
        return teacherDAL.searchTeacherDAL(query);
    }
    
    public static ArrayList<String> readDSID(){
        TeacherDAL std = new TeacherDAL();
        ArrayList<String> list = std.readDSID();
        return list;
    }
    
    public static ArrayList<Integer> readDSIDbyOrdered(){
        TeacherDAL std = new TeacherDAL();
        ArrayList<Integer> list = std.readDSIDbyOrdered();
        return list;
    }
}
