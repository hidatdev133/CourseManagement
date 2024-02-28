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
            if(item.getTitle().toLowerCase().contains(text.toLowerCase())){
                searchList.add(item);
            }
        }
        return searchList;
    }
    

    
    public String addOnlineCourse(String title , int credits , int departmentID){
        boolean result = courseDAL.addOnlineCourse(title, credits, departmentID);
        if(result)
            return "The course is added successfully!";
        return "The course is added failed!";
    }
}
