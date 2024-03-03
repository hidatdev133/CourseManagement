package BLL.Course;

import DAL.Course.Department;
import DAL.Course.DepartmentDAL;
import java.util.ArrayList;

public class DepartmentBLL {
      private final DepartmentDAL department=new DepartmentDAL();
    public ArrayList readListDepartment(){
        return department.readDepartment();
    }
    public int indexOfIDdepartment(int i){
        ArrayList <Department> list=department.readDepartment();
        for(Department depart:list){
            if(depart.getDepartmentID()==i){
                return list.indexOf(depart);
            }
        }
        return -1;
    }

    
    public ArrayList<Department> searchDepartmentsByName(String name){
        ArrayList<Department> searchList = new ArrayList<>();
        ArrayList<Department> listOfDepartments = department.readDepartment();
        for(Department item : listOfDepartments){
            if(name.equals(item.getName())){
                searchList.add(item);
            }
        }
        return searchList;
    }
    
    public Department findDepartmentIDByAllInfor(Department dpm){
        return department.findDepartmentIDByAllInfor(dpm);
    }

    
    public Department findDepartmentByID(int id){
        return department.findDepartmentByID(id);
    }
    
    public String getAdministratorName(int id){
        return department.getAdministrator(id);
    }
}
