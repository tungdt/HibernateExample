/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai.test.service;


/**
 *
 * @author tungdt
 */
import com.mastertheboss.domain.Department;
import java.util.List;
import com.mastertheboss.domain.Employee;
import com.mastertheboss.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
public class EmployeeService {
    
    private final Session session;
    private DeparmentService deparmentService;
    
    public EmployeeService(){
        session = HibernateUtil.getSessionFactory().openSession();
        deparmentService = new DeparmentService();
    }
    
    
        
    public void initData(){
        session.beginTransaction();
 
        Department department = new Department("java");
        session.save(department);
 
        session.save(new Employee("Jakab Gipsz",department));
        session.save(new Employee("Captain Nemo",department));
      
        session.getTransaction().commit();
    }
    public boolean addNew(Long departmentId, String name){
        try{
            session.beginTransaction();

            Department department = deparmentService.getById(departmentId);

            session.save(new Employee(name,department));


            session.getTransaction().commit();
            return true;
        }catch(Exception ex){
            
        }
        return false;
    }
    
    public List<Employee> getAll(){
        try{
            Query q = session.createQuery("From Employee ");

            List<Employee> resultList = q.list();
            return resultList;
        
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    
        
    public List<Employee> search(String employeeName, String departmentName){
        StringBuilder query = new StringBuilder("FROM Employee e WHERE 1=1 ");
        if(!employeeName.isEmpty()){
            query.append("AND e.name like '%").append(employeeName).append("%'");
        }
        
        if(!departmentName.isEmpty()){
            query.append("AND e.department.name like '%").append(departmentName).append("%'");
        }
        try{
            Query q = session.createQuery(query.toString());

            List<Employee> resultList = q.list();
            return resultList;
        
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
