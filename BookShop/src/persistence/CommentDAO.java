/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import bookshop.Comment;
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
public class CommentDAO implements CrudOperation<Comment> {

    @PersistenceContext(unitName = "BookShopPU")
    private EntityManager em;

    @Override
    public Comment findObject(Object id) {
        Comment comment = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BookShopPU");
        em = emf.createEntityManager();
        try {
            comment = em.find(Comment.class, id);

        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {

        }
        return comment;
    }

    @Override
    public void createObject(Comment object) {

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
                Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            em.close();
        }
    }

    @Override
    public void updateObject(Comment object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteObject(Comment object) {

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
                Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            em.close();
        }
    }

    @Override
    public List<Comment> getAll() {
        
        List<Comment> commentL = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BookShopPU");
        em = emf.createEntityManager();

        TypedQuery query = em.createNamedQuery("Comment.findAll", Comment.class);
        try {
            commentL = (List<Comment>) query.getResultList();

        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {

        }
        return commentL;
    }

}
