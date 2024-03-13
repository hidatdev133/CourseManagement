package DAL.CourseInstructor;

import java.util.Vector;

public class CourseInstructor {
    private int CourseID;
    private int PersonID;
    private String title;
    private String teacherName;
    private String Days,Time;

    public String getLocations() {
        return Locations;
    }

    public void setLocations(String Locations) {
        this.Locations = Locations;
    }
    private String Locations;
    
    public String getDays() {
        return Days;
    }

    public void setDays(String Days) {
        this.Days = Days;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }
   

    public CourseInstructor(int CourseID, int PersonID) {
        this.CourseID = CourseID;
        this.PersonID = PersonID;
    }

<<<<<<< Updated upstream
=======
    public CourseInstructor(int CourseID, String title, int PersonID, String teacherName) {
        this.CourseID = CourseID;
        this.PersonID = PersonID;
        this.title = title;
        this.teacherName = teacherName;
    }   
    
    public CourseInstructor(int CourseID, String title, int PersonID, String teacherName, String Days, String Time, String Locations) {
        this.CourseID = CourseID;
        this.PersonID = PersonID;
        this.title = title;
        this.teacherName = teacherName;
        this.Days = Days;
        this.Time =  Time;
        this.Locations = Locations;
    }

>>>>>>> Stashed changes
    public CourseInstructor() {
    }

    public int getCourseID() {
        return CourseID;
    }

    public void setCourseID(int CourseID) {
        this.CourseID = CourseID;
    }

    public int getPersonID() {
        return PersonID;
    }

    public void setPersonID(int PersonID) {
        this.PersonID = PersonID;
    }
<<<<<<< Updated upstream
     public String getALL() {
        return (PersonID+" "+ CourseID+" ");
    }

    public Vector<?> toArray() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

=======

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
>>>>>>> Stashed changes
}
