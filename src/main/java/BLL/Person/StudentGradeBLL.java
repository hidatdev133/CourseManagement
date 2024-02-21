package BLL.Person;

import DAL.Course.CourseDAL;
import DAL.Student.StudentDAL;
import DAL.StudentGrade.StudentGrade;
import DAL.StudentGrade.StudentGradeDAL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<List<Object>> searchStudentGrade(String searchQuery) {
        return studentGradeDAL.searchStudentGrade(searchQuery);
    }

}
