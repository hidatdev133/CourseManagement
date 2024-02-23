package DAL.Teacher;

import java.sql.Date;

public class Teacher {
    private int TeacherID;
    private String LastName, FirstName;
    private Date HireDate;

    public Teacher() {
    }

    public Teacher(int TeacherID, String LastName, String FirstName, Date HireDate) {
        this.TeacherID = TeacherID;
        this.LastName = LastName;
        this.FirstName = FirstName;
        this.HireDate = HireDate;
    }

    public Teacher(String LastName, String FirstName, Date HireDate) {
        this.LastName = LastName;
        this.FirstName = FirstName;
        this.HireDate = HireDate;
    }

    public int getTeacherID() {
        return TeacherID;
    }

    public void setTeacherID(int InstructorID) {
        this.TeacherID = InstructorID;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public Date getHireDate() {
        return HireDate;
    }

    public void setHireDate(Date HireDate) {
        this.HireDate = HireDate;
    }

    
}
