package DAL.Course;


public class Course {
    private int CourseID,Credit,DepartmentID;
    private String title;
  
    public Course(int CourseID, int Credit, int DepartmentID, String title) {
        this.CourseID = CourseID;
        this.Credit = Credit;
        this.DepartmentID = DepartmentID;
        this.title = title;
    }
    public Course() {
    }
    public int getCourseID() {
        return CourseID;
    }

    public void setCourseID(int CourseID) {
        this.CourseID = CourseID;
    }

    public int getCredit() {
        return Credit;
    }

    public void setCredit(int Credit) {
        this.Credit = Credit;
    }

    public int getDepartmentID() {
        return DepartmentID;
    }

    public void setDepartmentID(int DepartmentID) {
        this.DepartmentID = DepartmentID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public String toString() {
        return CourseID+"" ;
    }
        
}
