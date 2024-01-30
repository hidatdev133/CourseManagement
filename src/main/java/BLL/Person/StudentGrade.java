package BLL.Person;

import DAL.StudentGrade.StudentGradeDAL;
import java.sql.SQLException;
import java.util.List;

public class StudentGrade {

    private StudentGradeDAL studentGradeDAL;

    public StudentGrade() {
        this.studentGradeDAL = new StudentGradeDAL();
    }

    public List readStudentGrade() {
        return studentGradeDAL.readStudentGrade();
    }

    public List findStudentByGrade(float grade) {
        return studentGradeDAL.findStudentByGrade(grade);
    }

    public int insertStudentGrade(int courseID, int studentID, float grade) {
        return studentGradeDAL.insertStudentGrade(courseID, studentID, grade);
    }

    public boolean deleteStudentGrade(int enrollmentID) {
        return studentGradeDAL.deleteStudentGrade(enrollmentID);
    }

    public boolean editStudentGrade(int enrollmentID, int courseID, int studentID, float grade) {
        return studentGradeDAL.editStudentGrade(enrollmentID, courseID, studentID, grade);
    }

    public List getCourseIDFromStudentGrade(int courseID) throws SQLException {
        return studentGradeDAL.getCourseIDFromStudentGrade(courseID);
    }

    public List getStudentIDFromStudentGrade(int studentID) throws SQLException {
        return studentGradeDAL.getStudentIDFromStudentGrade(studentID);
    }
}
