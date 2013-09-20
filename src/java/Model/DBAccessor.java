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
public interface DBAccessor {
    public abstract void openConnection(String driverClassName, String url, String username, String password) 
	throws IllegalArgumentException, ClassNotFoundException, SQLException;
    
    public abstract void closeConnection() throws SQLException;
    
    public abstract List findRecords(String sqlString, boolean closeConnection) throws SQLException,
			Exception;
}
