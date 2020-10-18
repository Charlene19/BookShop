/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Request;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Charlène
 */
public class Sql {
    
    
    //AUTEUR
     
    
  
    //BOOK 
    

      
    
    //CATEGORY
    
     
     
    //PUBLISHER
    
  
     
     
    //ORDER


    
    //EVENT
    
    //ADRESS
     
    //EMPLOYEES
     
 

    public void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BookShopPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

 
    
    
    
}
