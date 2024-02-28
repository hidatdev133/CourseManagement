package BLL.Course;

import BLL.Person.StudentGradeBLL;
import DAL.Course.OnsiteCourse;
import DAL.Course.OnsiteCourseDAL;
import DAL.StudentGrade.StudentGrade;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class OnsiteCourseBLL {
   
    private final OnsiteCourseDAL onsiteCourseDAL=new OnsiteCourseDAL();
    private final StudentGradeBLL studentGradeBLL=new StudentGradeBLL();
    public ArrayList readOnsiteCourse(){
        return onsiteCourseDAL.readOnsiteCourse();
        }
    public boolean addOnsiteCourseBLL(int id, String Location, String Day, String Time){
        OnsiteCourse onsite=new OnsiteCourse();
        onsite.setCourseID(id);
        onsite.setLocation(Location);
        onsite.setDays(Day);
        onsite.setTime(Time);
        if(onsiteCourseDAL.addOnsiteCourse(onsite)>0){
            return true;
        }
        else return false;
    }
    public boolean editOnsiteCourseBLL(int id, String Location, String Day, String Time){
        
    OnsiteCourse onsite=new OnsiteCourse();
    onsite.setCourseID(id);
    onsite.setLocation(Location);
    onsite.setDays(Day);
    onsite.setTime(Time);
    if(onsiteCourseDAL.editOnsiteCourse(onsite)>0){
        return true;
    }
    else return false;
    }
    public boolean checkCourseID(int courseID){
        List<String> studentList=studentGradeBLL.readStudent();
        for(String student:studentList){
            if(student.equals(courseID))
                return false;
        }
        return true;
    }
    public ArrayList listOnsiteSearchBLL(String hint){
        return onsiteCourseDAL.searchOnsiteCourseID(hint);
    }
    public boolean courseIDcheckDelete(int idcheck){
       if(onsiteCourseDAL.readCourseIDStudentGrade().contains(idcheck)){
           return false;
       }
      else  return true;
    }
    public boolean deleteonsiteCourse(int courseId){
        return onsiteCourseDAL.DeleteOnsiteCourse(courseId);
    }
    public void reset(JTextField jtxt1,JTextField jtxt2,JTextField jtxt3,JComboBox jcb,JTextField jtxt5, JTextField jtxt6,JTextField jtxt7){
        
       jtxt1.setText("");
       jtxt2.setText("");
       jtxt3.setText("");
       jcb.setSelectedIndex(-1);
       jtxt5.setText("");
       jtxt6.setText("");
       jtxt7.setText("");
    }
}
