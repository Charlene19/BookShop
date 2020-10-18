/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.List;

/**
 *
 * @author Charlène
 */
public interface CrudOperation<T> {
    
    public T findObject(Object id);
    
    public void createObject(T object); 
    
    public void updateObject(T object);
    
    public void deleteObject();
    
    public List<T> getAll(); 
    
    
}
