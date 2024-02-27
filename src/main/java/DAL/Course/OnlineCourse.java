package DAL.Course;

public class OnlineCourse extends Course{
    private String URL;
    private String DepartmentName;

    public OnlineCourse(String URL, String DepartmentName, int CourseID, int Credit, int DepartmentID, String title) {
        super(CourseID, Credit, DepartmentID, title);
        this.URL = URL;
        this.DepartmentName = DepartmentName;
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
    
    private int CourseID;
    private String url ;
    private String title ;

    public OnlineCourse(int CourseID, String url) {
        this.CourseID = CourseID;
        this.url = url;
    }

    public OnlineCourse() {
    }

    
    public int getCourseID() {
        return CourseID;
    }

    public void setCourseID(int CourseID) {
        this.CourseID = CourseID;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    
}
