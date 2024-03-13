package BLL.Person;

import DAL.Course.CourseDAL;
import DAL.CourseInstructor.CourseInstructor;
import DAL.Student.StudentDAL;
import DAL.StudentGrade.StudentGrade;
import DAL.StudentGrade.StudentGradeDAL;
import java.math.BigDecimal;
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
        return studentGradeDAL.readStudentGrade();
    }

    public int insertStudentGrade(int courseID, int studentID, float grade) {
        return studentGradeDAL.InsertStudentGradeDAL(courseID, studentID, grade);
    }

    public boolean editStudentGrade(int enrollmentID, int courseID, int studentID, BigDecimal grade) {
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

    public String getTitle(int courseID) {
        return studentGradeDAL.getTitle(courseID);
    }

    public String getStudentName(int studentID) {
        return studentGradeDAL.getStudentName(studentID);
    }

    //Them
    public List readSG() {
        return studentGradeDAL.readSG();
    }

    public List searchStudentGradeByGradeRange(float minGrade, float maxGrade) {
        return studentGradeDAL.searchStudentGradeByGradeRange(minGrade, maxGrade);
    }
    //----------------------------------------

    public int getCredits(int courseID) {
        return studentGradeDAL.getCredits(courseID);
    }

    public int getDepartmentID(int courseID) {
        return studentGradeDAL.getDepartmentID(courseID);
    }

    public boolean isOnlineCourse(int courseID) {
        return studentGradeDAL.isOnlineCourse(courseID);
    }

    public boolean isOnsiteCourse(int courseID) {
        return studentGradeDAL.isOnsiteCourse(courseID);
    }

    public String getLocation(int courseID) {
        return studentGradeDAL.getLocation(courseID);
    }

    public String getDays(int courseID) {
        return studentGradeDAL.getDays(courseID);
    }

    public String getTime(int courseID) {
        return studentGradeDAL.getTime(courseID);
    }

    public String getUrl(int courseID) {
        return studentGradeDAL.getUrl(courseID);
    }
}
