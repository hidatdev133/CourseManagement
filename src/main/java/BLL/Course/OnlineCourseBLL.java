package BLL.Course;

import DAL.Course.OnlineCourse;
import DAL.Course.OnlineCourseDAL;
import java.util.ArrayList;


public class OnlineCourseBLL {
    
    OnlineCourseDAL courseDAL = new OnlineCourseDAL();
    
    public ArrayList<OnlineCourse> listOfOnlineCourse(){
        return courseDAL.listOfOnlineCourses();
    }
    
    public ArrayList<OnlineCourse> searchAllOnlCourses(String text){
        ArrayList<OnlineCourse> searchList = new ArrayList<>();
        ArrayList<OnlineCourse> listCourses = courseDAL.listOfOnlineCourses();
        for(OnlineCourse item : listCourses){
            if(item.getTitle().toLowerCase().contains(text.toLowerCase()) || String.valueOf(item.getCourseID()).contains(text) || item.getURL().toLowerCase().contains(text.toLowerCase())){
                searchList.add(item);
            }
        }
        return searchList;
    }
    

    public OnlineCourse findOnlCourseByID(int id){
        return courseDAL.findOnlCourseByID(id);
    }
    
    public String addOnlineCourse(OnlineCourse onl){
        boolean result = courseDAL.addOnlineCourse(onl );
        if(result)
            return "The course is added successfully!";
        return "The course is added failed!";
    }
    
    public String editOnlCourse(OnlineCourse onl){
        boolean result = courseDAL.editOnlineCourse(onl);
        if(result)
            return "Edit successfully!";
        return "Edit failed!";
    }
    
    public String deleteOnlCourse(int id){
        boolean result = courseDAL.deleteOnlineCourse(id);
        if(result)
            return "Delete successfully!";
        return "Delete failed!";
    }
    
    public boolean isOnlineCourse(int id){
        return courseDAL.isOnlineCourse(id);
    }
}
