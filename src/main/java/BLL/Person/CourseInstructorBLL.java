package BLL.Person;

import DAL.Course.CourseDAL;
import DAL.CourseInstructor.CourseInstructor;
import DAL.CourseInstructor.CourseInstructorDAL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseInstructorBLL {

    CourseInstructorDAL courseInstructorDAL = new CourseInstructorDAL();

    public boolean isCourseInstructed(int id) {
        return courseInstructorDAL.isCourseInstructed(id);
    }
    
    public CourseInstructorBLL() {
        this.courseInstructorDAL = new CourseInstructorDAL();
    }

    public List readCourseInstructor() throws SQLException {
        return courseInstructorDAL.readCourseInstructor();
    }
    
    public CourseInstructor readCourseInstructorByIDs(int courseID, int personID){
        return courseInstructorDAL.readCourseInstructorByID(courseID,personID);
    }
    
     public boolean addCourseInstructor(CourseInstructor newcourseinstructor){
        return courseInstructorDAL.addCourseInstructor(newcourseinstructor);
    }
     
     public boolean deleteCourseInstructor(int courseID, int personID){
        return courseInstructorDAL.deleteCourseInstructor(courseID, personID);
    }

    public ArrayList<String> listcourseID() {
        CourseInstructorDAL std = new CourseInstructorDAL();
        ArrayList<String> list = std.listcourseID();
        return list;
    }
    
    public List<String> getPersonIDsByCourseID(String courseID) {
        return courseInstructorDAL.getPersonIDsByCourseID(courseID);
    }
    
    public boolean editCourseInstructor(String CourseID, String oldPersonID,  String newPersonID){
        return courseInstructorDAL.editCourseInstructorByCourseID(CourseID, oldPersonID, newPersonID);
    }
    
    public List<CourseInstructor> searchCourseByID(String cbSearch, String ID) {
        return courseInstructorDAL.searchCourseByCourseID(cbSearch, ID);
    }
     public int getAllcourseIDbypersonID(int personID) {
        return courseInstructorDAL.getTotalCourses(personID);
    }
   
}
