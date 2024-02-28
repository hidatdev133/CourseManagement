package DAL.Course;

public class OnsiteCourse {
    int CourseID;
    String Location, Days, Time;
    String Title;
    int Credits, DepartmentID;

    public OnsiteCourse() {
    }

    public OnsiteCourse(int CourseID, String Location, String Days, String Time, String Title, int Credits, int DepartmentID) {
        this.CourseID = CourseID;
        this.Location = Location;
        this.Days = Days;
        this.Time = Time;
        this.Title = Title;
        this.Credits = Credits;
        this.DepartmentID = DepartmentID;
    }

    public int getCourseID() {
        return CourseID;
    }

    public void setCourseID(int CourseID) {
        this.CourseID = CourseID;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

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

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public int getCredits() {
        return Credits;
    }

    public void setCredits(int Credits) {
        this.Credits = Credits;
    }

    public int getDepartmentID() {
        return DepartmentID;
    }

    public void setDepartmentID(int DepartmentID) {
        this.DepartmentID = DepartmentID;
    }
    
       @Override
    public String toString() {
        return CourseID+"" ;
    }
}
