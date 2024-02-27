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
}
