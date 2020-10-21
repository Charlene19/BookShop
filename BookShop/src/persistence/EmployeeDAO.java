/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import bookshop.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author cda611
 */
public class EmployeeDAO implements CrudOperation<Employee> {

    @PersistenceContext(unitName = "BookShopPU")
    private EntityManager em;

    @Override
    public Employee findObject(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createObject(Employee object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateObject(Employee object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteObject() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Employee> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Employee findEmployeById(Long id) throws DAOException {
        Employee emp = null;
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("BookShopPU");
        em = emf.createEntityManager();
      try {
        emp = em.find(Employee.class, id);
               
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return emp;
    }
    
    public Employee findEmployeByLogin(String name) throws DAOException {
        Employee emp = null;
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("BookShopPU");
       
        String query = em.createNameQuery("Employee.findByEmployeeLogin").getSingleResult();
      try {
        emp = em.find(Employee.class, name);
       
        
           
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return emp;
    }

    public static void main(String []args) throws DAOException{
        EmployeeDAO em = new EmployeeDAO(); 
        em.findEmployeByLogin(1l); 
        System.out.println(em.toString());
    }
}
