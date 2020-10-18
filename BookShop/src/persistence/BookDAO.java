/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import bookshop.Book;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Charlène
 */
public class BookDAO implements CrudOperation<Book> {

    @Override
    public Book findObject(Object id) {
        
        
        EntityManagerFactory emf = Persistence
        .createEntityManagerFactory("MaBaseDeTestPU");
    EntityManager em = emf.createEntityManager();

    Book book = em.find(Book.class, 4);
    if (book != null) {
      
    }
    em.close();
    emf.close();
        return book;
    }

    @Override
    public void createObject(Book object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MaBaseDeTestPU");    
    EntityManager em = emf.createEntityManager();    
    EntityTransaction transac = em.getTransaction();
    transac.begin();
    Book book = new Book();
   
    em.persist(book);
    transac.commit();
    
    em.close();    
    emf.close();  
    }

    @Override
    public void updateObject(Book object) {
         EntityManagerFactory emf = Persistence
        .createEntityManagerFactory("MaBaseDeTestPU");
    EntityManager em = emf.createEntityManager();

    EntityTransaction transac = em.getTransaction();
    transac.begin();

    Query query = em.createQuery("select * from Book  where book.isbn='?'");
    Book book = (Book) query.getSingleResult();
    if (book == null) {
     
    } else {
     

     
      em.flush();
      
      book = (Book) query.getSingleResult();
 
    }
    
    transac.commit();
    
    em.close();
    emf.close();
    }

    @Override
    public void deleteObject() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Book> getAll() {
        EntityManagerFactory emf = Persistence
        .createEntityManagerFactory("MaBaseDeTestPU");
    EntityManager em = emf.createEntityManager();

    Query query = em.createQuery("select * from Book where book.isbn = ?");
    List book = query.getResultList();
    for (Object obj : book) {
      
    }
    
    em.close();
    emf.close();
        return book;
    }


  
}
