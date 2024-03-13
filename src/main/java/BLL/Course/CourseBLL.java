package BLL.Course;

import DAL.Course.Course;
import DAL.Course.CourseDAL;
import DAL.StudentGrade.StudentGradeDAL;
import java.util.ArrayList;

public class CourseBLL {
    private final CourseDAL courseDAL=new CourseDAL();
    private final StudentGradeDAL studentDAL=new StudentGradeDAL();
    public ArrayList<String> readDSID() {
        CourseDAL std = new CourseDAL();
        ArrayList<String> list = std.readDSID();
        return list;
    }
    public ArrayList readCourseBLL(){
        return courseDAL.readCourseDAL();
    }
    public boolean addCourseBLL(int id, String Title, int Credits, int Department){
        Course course=new Course();
        course.setCourseID(id);
        course.setTitle(Title);
        course.setCredit(Credits);
        course.setDepartmentID(Department);
        if(courseDAL.addCourse(course)>0){
            return true;
        }
       else return false;
    }
 
    public boolean editCourseBLL(int id, String Title, int credit,int Department){
        Course course=new Course();
        course.setCourseID(id);
        course.setTitle(Title);
        course.setCredit(credit);
        course.setDepartmentID(Department);
        if(courseDAL.updateCourse(course)>0){
            return true;
        }
        else return false;
    }
   public int getCourseID(){
        ArrayList<Course> listcourse=courseDAL.readCourseDAL();
        int max=listcourse.get(0).getCourseID();
        for(int i=0;i<listcourse.size();i++){
            if(listcourse.get(i).getCourseID()>max){
                max=listcourse.get(i).getCourseID();
            }
        }
        return max+1;
   }
    public boolean deletecoursonsite(int courseId){
        return courseDAL.DeleteCourse(courseId);
    }
    
    public ArrayList<Course> searchAllOnlCourses(String text){
        ArrayList<Course> searchList = new ArrayList<>();
        ArrayList<Course> listCourses = courseDAL.readCourseDAL();
        for(Course item : listCourses){
            if(item.getTitle().toLowerCase().contains(text.toLowerCase()) || String.valueOf(item.getCourseID()).contains(text) ){
                searchList.add(item);
            }
        }
        return searchList;
    }
    public int getAmountStudent(int id){
        return studentDAL.getAmountStudentByIDCourse(id);
    }
}
