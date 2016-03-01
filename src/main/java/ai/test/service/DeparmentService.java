/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai.test.service;

import com.mastertheboss.domain.Department;
import com.mastertheboss.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author tungdt
 */
public class DeparmentService {
    private final Session session;
    
    public DeparmentService(){
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    
    public List<Department> getAll(){
        try{
            Query q = session.createQuery("From Department ");

            List<Department> resultList = q.list();
            return resultList;
        
        }catch (Exception ex){
            ex.printStackTrace();
        }
        
        return null;
    }
    
    public Department getById(Long id){
        try{
            Query q = session.createQuery("From Department d WHERE d.id=" + id);

            List<Department> resultList = q.list();
            if(resultList!=null && resultList.size()>0)
                return resultList.get(0);
        
        }catch (Exception ex){
            ex.printStackTrace();
        }
        
        return null;
    }
}
