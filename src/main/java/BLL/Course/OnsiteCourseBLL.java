package BLL.Course;

import BLL.Person.StudentGradeBLL;
import DAL.Course.Course;
import DAL.Course.CourseDAL;
import DAL.Course.OnsiteCourse;
import DAL.Course.OnsiteCourseDAL;
import DAL.StudentGrade.StudentGrade;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class OnsiteCourseBLL {
   
    private final OnsiteCourseDAL onsiteCourseDAL=new OnsiteCourseDAL();
    private final StudentGradeBLL studentGradeBLL=new StudentGradeBLL();
    private final CourseBLL courseBLL=new CourseBLL();
    private final CourseDAL courseDAL=new CourseDAL();
    public ArrayList readOnsiteCourse(){
        return onsiteCourseDAL.readOnsiteCourse();
        }
    public boolean addOnsiteCourseBLL(int id, String Location, String Day, String Time,String Title, int Credits, int Department){
        Course course=new Course();
        course.setCourseID(id);
        course.setCredit(Credits);
        course.setDepartmentID(Department);
        course.setTitle(Title);
        OnsiteCourse onsite=new OnsiteCourse();
        onsite.setCourseID(id);
        onsite.setLocation(Location);
        onsite.setDays(Day);
        onsite.setTime(Time);
        
        if(courseDAL.addCourse(course)>0&& onsiteCourseDAL.addOnsiteCourse(onsite)>0){
            return true;
        }
        else return false;
    }
    public boolean editOnsiteCourseBLL(int id, String Location, String Day, String Time, String Title, int credit,int Department){
    Course course=new Course();
    course.setCourseID(id);
    course.setTitle(Title);
    course.setCredit(credit);
    course.setDepartmentID(Department);
    
    OnsiteCourse onsite=new OnsiteCourse();
    onsite.setCourseID(id);
    onsite.setLocation(Location);
    onsite.setDays(Day);
    onsite.setTime(Time);
    
 
    if(courseDAL.updateCourse(course)>0&& onsiteCourseDAL.editOnsiteCourse(onsite)>0){
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
      if(courseBLL.deletecoursonsite(courseId)&&onsiteCourseDAL.DeleteOnsiteCourse(courseId)){
          return true;
      }
      return false;
    }
    public boolean isOnsiteCourse(int id){
        return onsiteCourseDAL.isOnsiteCourse(id);
    }
    public OnsiteCourse getOnsiteCourseByID(int id){
        return onsiteCourseDAL.getOnsiteCourseByID(id);
    }
    public ArrayList checkAddTimeOfOnsiteCourse(OnsiteCourse onsiteCourse){
        ArrayList<OnsiteCourse>ListonsiteCourse=onsiteCourseDAL.readOnsiteCourse();
        ArrayList <OnsiteCourse> onsiteList=new ArrayList<>();
        for(int i=0;i<ListonsiteCourse.size();i++){
            if(ListonsiteCourse.get(i).getLocation().equals(onsiteCourse.getLocation())){
                if(containAny(ListonsiteCourse.get(i).getDays(),onsiteCourse.getDays())){
                    onsiteList.add(ListonsiteCourse.get(i));
                }
            }
        }
        if(onsiteList.size()>0){
            return onsiteList;
        }
        else{
            return null;
        }
    }
    public String getDay(JCheckBox Mo,JCheckBox Tu, JCheckBox wed, JCheckBox Thus,JCheckBox Fri, JCheckBox Sat){
        String day="";
        if(Mo.isSelected()){
            day+="M";
        }
        if(Tu.isSelected()){
            day+="T";
        }
        if(wed.isSelected()){
            day+="W";
        }
        if(Thus.isSelected()){
            day+="H";
        }
        if(Fri.isSelected()){
            day+="F";
        }
        if(Sat.isSelected()){
            day+="S";
        }
        return day;
    }
    public int getHour(String time){
        int index=time.indexOf(":");
       int hour=Integer.parseInt(time.substring(0, index));
       return hour;
               }
    public String checkTimeInValid( OnsiteCourse onsiteCourse){
        
     if(checkAddTimeOfOnsiteCourse(onsiteCourse)!=null){
        
         ArrayList<OnsiteCourse> getListOnsite=checkAddTimeOfOnsiteCourse(onsiteCourse);
         for(int i=0;i<getListOnsite.size();i++){
             if(getListOnsite.get(i).getCourseID()==onsiteCourse.getCourseID() && getListOnsite.get(i).getLocation().equals(onsiteCourse.getLocation())){
                 getListOnsite.remove(getListOnsite.get(i));
                
         }
         }
         if(getListOnsite.size()==1){
              int hour1=getHour(getListOnsite.get(0).getTime());
         int hour2=getHour(onsiteCourse.getTime());
         if((hour1>=7&&hour1<=12)&&(hour2>=7&&hour2<=12)){
             return "Duplicate schedule, enter afternoon shift please";
         }
         if((hour1>=13&&hour1<=17)&&(hour2>=13&&hour2<=17)){
             return "Duplicate schedule, enter morning shift please" ;
         }
         }
         else if(getListOnsite.size()>1) {
             
        return "Location full of shift, Please enter orther Location";

     }
     }
     return null;
    
    }
    public int countLocation(String location){
        return onsiteCourseDAL.CountLocation(location);
    }
 public void loadDaytoCombo(ArrayList<String> listday,JCheckBox Mo,JCheckBox Tu, JCheckBox wed, JCheckBox Thus,JCheckBox Fri, JCheckBox Sat){
    for(int i=0;i<listday.size();i++){
        switch ( listday.get(i)){
            case "M":{
                    Mo.setSelected(true);
                    break;
                }
            case "T":{
                Tu.setSelected(true);
                break;
            }
            case "W":{
                wed.setSelected(true);
                break;
            }
            case "H":{
                Thus.setSelected(true);
                break;
            }
            case "F":{
                Fri.setSelected(true);
                break;
            }
            case "S":{
                Sat.setSelected(true);
                break;
            }
        }
               
    }
 }
 public ArrayList cutDay(String day){
     ArrayList<String> listDay=new ArrayList<>();
        char [] charlist=day.toCharArray();
     for(char c:charlist){
         listDay.add(String.valueOf(c));
     }
     return listDay;
 }
 public boolean containAny(String str1,String str2){
     ArrayList <String> list=cutDay(str2);
     for(String c:list){
         if(str1.indexOf(c)!=-1){
             return true;
         }
     }
     return false;
 }
 public int Count(OnsiteCourse onsite){
     ArrayList <OnsiteCourse> listonsite=onsiteCourseDAL.readOnsiteCourse();
     int count=0;
     System.out.print(listonsite.size());
     for (int i=0;i<listonsite.size();i++){
         if(listonsite.get(i).getLocation().equals(onsite.getLocation())){
             if(containAny(listonsite.get(i).getDays(), onsite.getDays())){
                 if(checkTimeInValid(onsite)!=null){
                     count++;
                 }
             }
         }
 }
     return count;
 }
 
         
}
