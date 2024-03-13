package BLL.Person;

import DAL.CourseInstructor.CourseInstructorDAL;

public class CourseInstructorBLL {
    CourseInstructorDAL courseInstructorDAL = new CourseInstructorDAL();
    
    public boolean isCourseInstructed(int id){
        return courseInstructorDAL.isCourseInstructed(id);
    }
    
    public String getNameTeacherOfCourse(int id){
        return courseInstructorDAL.getNameTeacherOfCourse(id);
    }
}
