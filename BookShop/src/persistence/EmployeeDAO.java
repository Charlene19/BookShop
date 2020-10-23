/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import bookshop.Employee;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author cda611
 */
public class EmployeeDAO implements CrudOperation<Employee> {

    @PersistenceContext(unitName = "BookShopPU")
    private EntityManager em;

    @Override
    public Employee findObject(Object id) {
        Employee emp = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BookShopPU");
        em = emf.createEntityManager();
        try {
            emp = em.find(Employee.class, id);

        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {

        }
        return emp;
    }

    @Override
    public void createObject(Employee object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BookShopPU");
        em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {

            transaction.begin();

            em.persist(object);

            em.flush();
            em.clear();

            transaction.commit();

        } catch (Exception e) {
            try {
                if (transaction != null) {
                    transaction.rollback();
                }
                throw new SQLException(e.getMessage());
            } catch (SQLException ex) {
                Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            em.close();
        }
    }

    @Override
    public void updateObject(Employee object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteObject(Employee object) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BookShopPU");
        em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {

            transaction.begin();

            em.remove(object);

            em.flush();
            em.clear();

            transaction.commit();

        } catch (Exception e) {
            try {
                if (transaction != null) {
                    transaction.rollback();
                }
                throw new SQLException(e.getMessage());
            } catch (SQLException ex) {
                Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            em.close();
        }

    }

    @Override
    public List<Employee> getAll() {
         List<Employee> empL = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BookShopPU");
        em = emf.createEntityManager();

        TypedQuery query = em.createNamedQuery("Employee.findAll", Employee.class);
        try {
            empL = (List<Employee>) query.getResultList();

        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
           
        }
        return empL;
    }

    public Employee findEmployeByLogin(String employeeLogin) throws DAOException {
        Employee emp = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BookShopPU");
        em = emf.createEntityManager();

        Query query = em.createNamedQuery("Employee.findByEmployeeLogin", Employee.class);
        try {
            emp = (Employee) query.setParameter("employeeLogin", employeeLogin).getSingleResult();

        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return emp;
    }

    public static void main(String[] args) throws DAOException, ParseException {
        EmployeeDAO ed = new EmployeeDAO();
        String string = "January 2, 2010";
        DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
        Date date = format.parse(string);

        Employee employe = new Employee("bmbla", "bla", date, date);
        ed.createObject(employe);
        System.out.println(ed.getAll());
    }
}
