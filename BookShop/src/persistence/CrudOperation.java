/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

/**
 *
 * @author Charlène
 */
public interface CrudOperation {
    
    public void findObject();
    
    public void createObject(); 
    
    public void updateObject();
    
    public void deleteObject(); 
    
    
}
