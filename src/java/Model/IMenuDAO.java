/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author bit
 */
public interface IMenuDAO <T>{
    public abstract List<T> getAllMenuItems() throws ClassNotFoundException, SQLException, Exception;
    
    public abstract void setDb(DBAccessor db);
    
    public abstract DBAccessor getDb();
}
