package DAL.Course;

public class Department {
    int DepartmentID;
    String Name;
    Double Budget;
    String StartDate;
    int Administrator;

    public Department() {
    }

    public Department(int DepartmentID, String Name, Double Budget, String StartDate, int Administrator) {
        this.DepartmentID = DepartmentID;
        this.Name = Name;
        this.Budget = Budget;
        this.StartDate = StartDate;
        this.Administrator = Administrator;
    }

    public int getDepartmentID() {
        return DepartmentID;
    }

    public void setDepartmentID(int DepartmentID) {
        this.DepartmentID = DepartmentID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public Double getBudget() {
        return Budget;
    }

    public void setBudget(Double Budget) {
        this.Budget = Budget;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String StartDate) {
        this.StartDate = StartDate;
    }

    public int getAdministrator() {
        return Administrator;
    }

    public void setAdministrator(int Administrator) {
        this.Administrator = Administrator;
    }

    @Override
    public String toString() {
        return  DepartmentID+"" ;
    }
    
            
}
