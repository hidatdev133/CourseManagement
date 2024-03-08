package DAL.Course;
import java.sql.ResultSet;
import java.util.ArrayList;
import ConnectDB.ConnectDB;
public class DepartmentDAL extends  ConnectDB{
    
     public ArrayList readDepartment(){
        ArrayList<Department>departmentList=new ArrayList();
        try{
            String sql="select * from department";
            ResultSet rs = this.doReadQuery(sql); 
            while(rs.next()){
                Department department =new Department();
               department.setDepartmentID(rs.getInt(1));
              department.setName(rs.getString(2));
              department.setBudget(rs.getDouble(3));
              department.setStartDate(rs.getString(4));
              department.setAdministrator(rs.getInt(5));
             
              departmentList.add(department);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return departmentList;
        
    }
     
     public Department findDepartmentIDByAllInfor(Department de){
        try{
            String sql="SELECT * FROM Department WHERE Name = '" + de.Name + "' AND Budget = " + de.Budget + " AND StartDate = '" + de.StartDate + "'";
            ResultSet rs = this.doReadQuery(sql); 
            while(rs.next()){
                de.setDepartmentID(rs.getInt("DepartmentID"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return de;
        
    }
     
     public Department findDepartmentByID(int id){
         Department de = new Department();
         try{
            String sql="SELECT * FROM Department WHERE DepartmentID = " + id;
            ResultSet rs = this.doReadQuery(sql); 
            while(rs.next()){
                de.setDepartmentID(rs.getInt("DepartmentID"));
                de.setAdministrator(rs.getInt("Administrator"));
                de.setBudget(rs.getDouble("Budget"));
                de.setName(rs.getString("Name"));
                de.setStartDate(rs.getString("StartDate"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return de;
     }
     
     public String getAdministrator(int id){
         String name = "";
         try {
             String sql = "SELECT Person.FirstName , Person.LastName FROM Person , Department WHERE Department.Administrator = Person.PersonID AND Department.Administrator = " + id;
             ResultSet rs = this.doReadQuery(sql);
             while(rs.next()){
                 String firstName =rs.getString("FirstName");
                 String lastName = rs.getString("LastName");
                 name = firstName.concat(" "+ lastName);
             }
             
         } catch (Exception e) {
             System.out.println(e);
         }
         return name ;
     }
}
