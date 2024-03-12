package DAL.StudentGrade;

public class StudentGrade {

    private int EnrollmentID, CourseID, StudentID;
    private float Grade;
    private String CourseName;
    private String StudentName;
    private String Days, Time;
    private String location;
    private String url, Credits, DepartmendID;
    

    public StudentGrade() {
    }

    public StudentGrade(int EnrollmentID, int CourseID, int StudentID, float Grade, String CourseName, String StudentName, String Days, String Time, String location, String url, String Credits, String DepartmendID) {
        this.EnrollmentID = EnrollmentID;
        this.CourseID = CourseID;
        this.StudentID = StudentID;
        this.Grade = Grade;
        this.CourseName = CourseName;
        this.StudentName = StudentName;
        this.Days = Days;
        this.Time = Time;
        this.location = location;
        this.url = url;
        this.Credits = Credits;
        this.DepartmendID = DepartmendID;
    }

    public int getEnrollmentID() {
        return EnrollmentID;
    }

    public void setEnrollmentID(int EnrollmentID) {
        this.EnrollmentID = EnrollmentID;
    }

    public int getCourseID() {
        return CourseID;
    }

    public void setCourseID(int CourseID) {
        this.CourseID = CourseID;
    }

    public int getStudentID() {
        return StudentID;
    }

    public void setStudentID(int StudentID) {
        this.StudentID = StudentID;
    }

    public float getGrade() {
        return Grade;
    }

    public void setGrade(float Grade) {
        this.Grade = Grade;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String CourseName) {
        this.CourseName = CourseName;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String StudentName) {
        this.StudentName = StudentName;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCredits() {
        return Credits;
    }

    public void setCredits(String Credits) {
        this.Credits = Credits;
    }

    public String getDepartmendID() {
        return DepartmendID;
    }

    public void setDepartmendID(String DepartmendID) {
        this.DepartmendID = DepartmendID;
    }
    

}
