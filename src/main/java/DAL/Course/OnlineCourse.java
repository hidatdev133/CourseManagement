package DAL.Course;

public class OnlineCourse extends Course{
    private String URL;
    private String DepartmentName;

    public OnlineCourse(String URL, String DepartmentName, int CourseID, int Credit, int DepartmentID, String title) {
        super(CourseID, Credit, DepartmentID, title);
        this.URL = URL;
        this.DepartmentName = DepartmentName;
    }

    public OnlineCourse() {
    }
    

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String DepartmentName) {
        this.DepartmentName = DepartmentName;
    }
    

    
}
