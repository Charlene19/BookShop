/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import bookshop.Employee;
import bookshop.Order1;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author cda611
 */
public class OrderDAO implements CrudOperation<Order1> {

    @PersistenceContext(unitName = "BookShopPU")
    private EntityManager em;

    @Override
    public Order1 findObject(Object id) {

        Order1 order = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BookShopPU");
        em = emf.createEntityManager();
        try {
            order = em.find(Order1.class, id);

        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {

        }
        return order;
    }

    @Override
    public void createObject(Order1 object) {

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
                Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            em.close();
        }
    }

    @Override
    public void updateObject(Order1 object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteObject(Order1 object) {

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
                Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            em.close();
        }
    }

    @Override
    public List<Order1> getAll() {

        List<Order1> orderL = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BookShopPU");
        em = emf.createEntityManager();

        TypedQuery query = em.createNamedQuery("Employee.findAll", Employee.class);
        try {
            orderL = (List<Order1>) query.getResultList();

        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {

        }
        return orderL;
    }

}
