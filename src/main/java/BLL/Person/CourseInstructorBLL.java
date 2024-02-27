package BLL.Person;

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

    private CourseInstructorDAL cid = new CourseInstructorDAL();
    private TeacherBLL tbll = new TeacherBLL();
    private List<CourseInstructor> list;
    //fix
    private CourseBLL cbll = new CourseBLL();
    private String[] Titles;
    private String[] teacherNames;

    public CourseInstructorBLL() {
//        try {
//            this.list = cid.readCourseInstructor();
//        } catch (SQLException ex) {
//            Logger.getLogger(CourseIntructorBLL.class.getName()).log(Level.SEVERE, null, ex);
    }

    public List loadCourseInstructor() throws SQLException {
        list = cid.readCourseInstructor();
        return list;
    }

    public List findCourseInstructor(String condition) throws SQLException {
        ArrayList<CourseInstructor> list = (ArrayList<CourseInstructor>) cid.readCourseInstructor();
        ArrayList<CourseInstructor> listSearchs = new ArrayList<CourseInstructor>();
        condition = condition.trim().replaceAll("  +", " ").toLowerCase();
        String oldCondition = condition;
        String[] conditions = condition.split(" ");

        for (int i = 0; i < list.size(); i++) {
            String regex = list.get(i).getALL() + teacherNames[i] + " " + Titles[i];
            for (int j = 0; j < conditions.length; j++) {
                String oldChirlCondition = conditions[j];
                conditions[j] = "(.*)" + conditions[j] + "(.*)";
                if (regex.toLowerCase().matches(conditions[j])) {
//                    System.out.println(list.get(i).getPersonID()+" -> ID" + list.get(i).getCourseID());
                    listSearchs.add(list.get(i));
                    break;
                }
                conditions[j] = oldChirlCondition;
            }

        }
        if (listSearchs.size() == 0) {
            return listSearchs;
        }
//        System.out.println(listSearchs.size());
        return listSearchs;
    }

    public String[] loadTeacherName(List<CourseInstructor> listCourseInstructor) throws SQLException {
        teacherNames = new String[listCourseInstructor.size()];

        List<Teacher> list = tbll.LoadTeachers();
        for (int i = 0; i < listCourseInstructor.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).getPersonID() == listCourseInstructor.get(i).getPersonID()) {
                    teacherNames[i] = list.get(j).getFirstName() + " " + list.get(j).getLastName();
                }
            }
        }
        return teacherNames;
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
        // check duplicate
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPersonID() == c.getPersonID() && list.get(i).getCourseID() == c.getCourseID()) {
                return -2;
            }
        }
        int result = cid.insertCourseInstructor(c);
        return result;
    }

    public int updateCourseInstructor(CourseInstructor c, CourseInstructor old) throws SQLException {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPersonID() == c.getPersonID() && list.get(i).getCourseID() == c.getCourseID()) {
                return -2;
            }
        }
        int result = cid.updateCourseInstructor(c, old);
        return result;
    }

    public int deleteCourseInstructor(CourseInstructor c) throws SQLException {
        int result = cid.deleteCourseInstructor(c);
        return result;
    }


    public List getCourseIDFromCourseInstructor(int courseID) throws SQLException {
        List<CourseInstructor> listTemp;
        listTemp = cid.getCourseIDFromCourseInstructor(courseID);
        return listTemp;
    }


    
     public List getPersonIDFromCourseInstructor(int personID) throws SQLException {
         List<CourseInstructor> tempt;
         tempt = cid.getPersonIDFromCourseInstructor(personID);
         return tempt;
     }

}
