package DAL.Course;
import ConnectDB.ConnectDB;
import java.sql.ResultSet;
import java.util.ArrayList;

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
}
