package Model;

import java.sql.SQLException;
import java.util.List;


/**
 * Interface used to access the database.
 * Opens and closes connection and finds records
 * ---------------------------------------------
 * 1. Needs to add Create, Update, and Delete records.
 * 2. Needs a method to query by ID.
 * 
 * @author Dan Smith
 */
public interface DBAccessor {
    public abstract void openConnection(String driverClassName, String url, String username, String password) 
	throws IllegalArgumentException, ClassNotFoundException, SQLException;
    
    public abstract void closeConnection() throws SQLException;
    
    public abstract List findRecords(String sqlString, boolean closeConnection) throws SQLException,
			Exception;
}
