package Model;

import java.sql.SQLException;
import java.util.List;

/**
 * Interface that the DAO implements that has methods to interact with the DB
 * to manipulate data..
 * --------------------------------------------------------------------------
 * Need to add methods for Create, Update, and Delete methods.
 * 
 * @author Dan Smith
 */
public interface IMenuDAO <T>{
    public abstract List<T> getAllMenuItems() throws ClassNotFoundException, SQLException, Exception;
    
    public abstract void setDb(DBAccessor db);
    
    public abstract DBAccessor getDb();
}
