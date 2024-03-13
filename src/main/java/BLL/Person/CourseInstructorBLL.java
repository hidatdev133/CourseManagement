package BLL.Person;

<<<<<<< Updated upstream
import BLL.Course.CourseBLL;
import DAL.Course.Course;
import DAL.CourseInstructor.CourseInstructor;
import java.util.ArrayList;
import DAL.CourseInstructor.CourseInstructorDAL;
import DAL.Teacher.Teacher;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.regex.Pattern.matches;

public class CourseInstructorBLL {

    public CourseInstructorDAL cid = new CourseInstructorDAL();
    public TeacherBLL tbll = new TeacherBLL();
    public List<CourseInstructor> list;
    //fix
    public CourseBLL cbll = new CourseBLL();
    public String[] Titles;
    public String[] teacherNames;

    public CourseInstructorBLL() {
//        try {
//            this.list = cid.readCourseInstructor();
//        } catch (SQLException ex) {
//            Logger.getLogger(CourseIntructorBLL.class.getName()).log(Level.SEVERE, null, ex);
    }

//    public List loadCourseInstructor() throws SQLException {
//        list = cid.readCourseInstructor();
//        return list;
//    }
//
//    public List findCourseInstructor(String condition) throws SQLException {
//        ArrayList<CourseInstructor> list = (ArrayList<CourseInstructor>) cid.readCourseInstructor();
//        ArrayList<CourseInstructor> listSearchs = new ArrayList<CourseInstructor>();
//        condition = condition.trim().replaceAll("  +", " ").toLowerCase();
//        String oldCondition = condition;
//        String[] conditions = condition.split(" ");
//
//        for (int i = 0; i < list.size(); i++) {
//            String regex = list.get(i).getALL() + teacherNames[i] + " " + Titles[i];
//            for (int j = 0; j < conditions.length; j++) {
//                String oldChirlCondition = conditions[j];
//                conditions[j] = "(.*)" + conditions[j] + "(.*)";
//                if (regex.toLowerCase().matches(conditions[j])) {
////                    System.out.println(list.get(i).getPersonID()+" -> ID" + list.get(i).getCourseID());
//                    listSearchs.add(list.get(i));
//                    break;
//                }
//                conditions[j] = oldChirlCondition;
//            }
//
//        }
//        if (listSearchs.size() == 0) {
//            return listSearchs;
//        }
////        System.out.println(listSearchs.size());
//        return listSearchs;
//    }
    public List<CourseInstructor> readCourseInstructors() {
        return cid.readCourseInstructor();
    }

    public List<Teacher> loadTeacherName() throws SQLException {
        ArrayList list = (ArrayList) cid.readCourseInstructor();
        return list;
    }

    public String[] loadTitle(List<CourseInstructor> listCourseInstructor) throws SQLException {
        Titles = new String[listCourseInstructor.size()];

        List<Course> list = cbll.LoadCourses(1);
        for (int i = 0; i < listCourseInstructor.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).getCourseID() == listCourseInstructor.get(i).getCourseID()) {
                    Titles[i] = list.get(j).getTitle();
                }
            }
        }
        return Titles;
    }

    public int addCourseInstructor(CourseInstructor c) throws SQLException {
        return cid.insertCourseInstructor(c);
    }

    public boolean updateCourseInstructor(CourseInstructor c) {
        return cid.updateCourseInstructor(c);
    }

    public boolean deleteCourseInstructor(int courseID) {
        return cid.deleteCourseInstructor(courseID);

    }

    public List getPersonIDFromCourseInstructor(String query) throws SQLException {
        return cid.getPersonIDFromCourseInstructor(query);
    }

=======
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
   
>>>>>>> Stashed changes
}
