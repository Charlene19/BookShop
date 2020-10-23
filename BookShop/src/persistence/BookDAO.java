/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import bookshop.Book;
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
 * @author Charlène
 */
public class BookDAO implements CrudOperation<Book> {

    @PersistenceContext(unitName = "BookShopPU")
    private EntityManager em;

    @Override
    public Book findObject(Object id) {
        
        Book book = null;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BookShopPU");
        em = emf.createEntityManager();
        try {
            book = em.find(Book.class, id);

        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {

        }
        return book;
    }

    @Override
    public void createObject(Book object) {
        
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
                Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            em.close();
        }
    }

    @Override
    public void updateObject(Book object) {

    }

    @Override
    public void deleteObject(Book object) {
        
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
                Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            em.close();
        }
    }

    @Override
    public List<Book> getAll() {
        List<Book> bookL = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BookShopPU");
        em = emf.createEntityManager();

        TypedQuery query = em.createNamedQuery("Book.findAll", Book.class);
        try {
            bookL = (List<Book>) query.getResultList();

        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {

        }
        return bookL;
    }

}
