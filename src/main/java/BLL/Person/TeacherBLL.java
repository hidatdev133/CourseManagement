package BLL.Person;

import DAL.Teacher.Teacher;
import DAL.Teacher.TeacherDAL;
import java.util.ArrayList;
import java.util.List;

public class TeacherBLL {
    public TeacherDAL teacherDAL;

    public TeacherBLL() {
        teacherDAL = new TeacherDAL();
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

    public List<Teacher> LoadTeachers() {
        ArrayList list = (ArrayList) teacherDAL.readTeacher();
        return list; 
    }
}