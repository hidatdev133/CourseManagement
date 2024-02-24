package BLL.Person;

import DAL.Course.CourseDAL;
import DAL.Student.StudentDAL;
import DAL.StudentGrade.StudentGrade;
import DAL.StudentGrade.StudentGradeDAL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class StudentGradeBLL {

    private final StudentGradeDAL studentGradeDAL;

    public StudentGradeBLL() {
        this.studentGradeDAL = new StudentGradeDAL();
    }

    public List readStudent() {
        return studentGradeDAL.readStudent();
    }

    public int insertStudentGrade(int courseID, int studentID, float grade) {
        return studentGradeDAL.InsertStudentGradeDAL(courseID, studentID, grade);
    }

    public boolean deleteStudentGrade(int enrollmentID) {
        return studentGradeDAL.deleteStudentgradeDAL(enrollmentID);
    }

    public boolean editStudentGrade(int enrollmentID, int courseID, int studentID, float grade) {
        return studentGradeDAL.editStudentGrade(enrollmentID, courseID, studentID, grade);
    }

    public List<List<Object>> searchStudentGradeByCourseID(String searchQuery) {
        return studentGradeDAL.searchStudentGradeByCourseID(searchQuery);
    }

    public List<List<Object>> searchStudentGradeByStudentID(String searchQuery) {
        return studentGradeDAL.searchStudentGradeByStudentID(searchQuery);
    }

    public List<List<Object>> searchStudentGradeByGrade(float grade) {
        return studentGradeDAL.searchStudentGradeByGrade(grade);
    }

    public List<List<Object>> searchStudentGradeByStudentName(String name) {
        return studentGradeDAL.searchStudentGradeByStudentName(name);
    }
    
    public List<List<Object>> searchStudentGradeByCourseName(String name) {
        return studentGradeDAL.searchStudentGradeByCourseName(name);
    }
}
