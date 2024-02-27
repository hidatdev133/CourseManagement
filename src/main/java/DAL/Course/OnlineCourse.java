package DAL.Course;

public class OnlineCourse {
    
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
