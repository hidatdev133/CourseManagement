//package BLL.Person;
//
//
//import DAL.Course.CourseDAL;
//import DAL.Student.StudentDAL;
//import DAL.StudentGrade.StudentGrade;
//import DAL.StudentGrade.StudentGradeDAL;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class StudentGradeBLL {
//    public static ArrayList<StudentGrade> DSSDG ;
//    private StudentGradeDAL get;
//    public StudentGradeBLL(){
//        this.get = new StudentGradeDAL();
//    }
//    
//    public List docDSHD(){
//
//        List list = new ArrayList();
////        if(DSSDG==null){
//            StudentGradeDAL get=new StudentGradeDAL();
//            DSSDG = new ArrayList<>();
//            list = get.readStudent();
//            for(int i=0;i<list.size();i++){
//                List l2 = (List)list.get(i);
//                DSSDG.add((StudentGrade)l2.get(0));
//            }
////        }
//        return list;
//    }
//    public boolean deleteStudentGradeBLL(int EnrollMentID){
//        boolean check = get.deleteStudentgradeDAL(EnrollMentID);
//        return check;
//    }
//    public List insertStudentGradeBLL(String CouID , String StuID , String Grade){
//        List list = new ArrayList();
//        int courseid = Integer.parseInt(CouID);
//        int stdentid = Integer.parseInt(StuID);
//        float grade = Float.parseFloat(Grade);
//        
//        int Enrollmentid = get.InsertStudentGradeDAL(stdentid, courseid, grade);
//        if(Enrollmentid >= 0){
//            StudentDAL sdal = new StudentDAL();
//            CourseDAL c = new CourseDAL();
//            StudentGrade g = new StudentGrade();      
//            g.setEnrollmentID(Enrollmentid);
//            g.setCourseID(courseid);
//            g.setStudentID(stdentid);
//            g.setGrade(grade);
//            String name = sdal.readStudentNameByID(stdentid);
//            String title = c.readCourseTitleByID(courseid);
//            DSSDG.add(g);
//            
//            list.add(g);
//            list.add(name);
//            list.add(title);
//        }
//        return list;
//    }
//    
//    public List getStudentGrade(String Grade){
//        float grade = Float.parseFloat(Grade);
//        List list = new ArrayList();
//        StudentGradeDAL get=new StudentGradeDAL();
//        list = get.findStudentByGrade(grade);
//        return list;
//    }
//    public List EditStudentGrade(int enrollmentID , String courseid , String studentID , String grade){
//        List list = new ArrayList();
//        int courseID2 = Integer.parseInt(courseid);
//        int studentID2 = Integer.parseInt(studentID);
//        float grade2 = Float.parseFloat(grade);
//        
//        boolean check = get.editStudentGradeDAL(enrollmentID, courseID2, studentID2, grade2);
//        int i=0;
//        for(StudentGrade s : DSSDG){
//            if(s.getEnrollmentID() == enrollmentID){
//                StudentGrade s2 = new StudentGrade();
//                s2.setEnrollmentID(enrollmentID);
//                s2.setCourseID(courseID2);
//                s2.setStudentID(studentID2);
//                s2.setGrade(grade2);
//                DSSDG.set(i, s2);
//                list.add(DSSDG.get(i));
//                break;
//            }
//            i++;
//        }
//        StudentDAL sdal = new StudentDAL();
//        CourseDAL c = new CourseDAL();
//        String name = sdal.readStudentNameByID(studentID2);
//        String title = c.readCourseTitleByID(courseID2);
//        list.add(name);
//        list.add(title);
//        return list;
//    }
//    public List getCourseIDFromStudentGrade(int courseID) throws SQLException {
//        List<StudentGrade> listTemp;
//        listTemp = get.getCourseIDFromStudentGrade(courseID);
//        return listTemp;
//    }
//    public List getStudentIDFromStudentGrade(int studentID) throws SQLException {
//        List<StudentGrade> tempt;
//        tempt = get.getStudentIDFromStudentGrade(studentID);
//        return tempt;
//
//    }
//}
