package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class used to access the database. Opens and closes the database 
 * connection. Returns a list based on a SQL query string.
 * ----------------------------------------------------------------
 * 1. Needs to add methods for Create, Update, and Delete records.
 * 2. Need to add a method for query by ID.
 * 
 * @author Dan Smith
 */
public class DBGeneric implements DBAccessor {
    private final String ERR_MSG = "Error: url is null or zero length!";
    private final String EMPTY_STRING = "";
    
    /*
     * Possible change later
     * ---------------------
    private final String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/menu";
    private final String USERNAME = "root";
    private final String PASSWORD = "admin";
    */
    
    private Connection conn;
    
    @Override
    public void openConnection(String driverClassName, String url, String username, String password) throws IllegalArgumentException, ClassNotFoundException, SQLException {
        
        if (url == null || url.length() == 0) {
            throw new IllegalArgumentException(ERR_MSG);
        }
        username = (username == null) ? EMPTY_STRING : username;
        password = (password == null) ? EMPTY_STRING : password;
        Class.forName(driverClassName);
        conn = DriverManager.getConnection(url, username, password);
    }

    @Override
    public void closeConnection() throws SQLException {
        conn.close();
    }

    @Override
    public List findRecords(String sqlString, boolean closeConnection) throws SQLException, Exception {
        Statement stmt = null;
        ResultSet rs = null;
        ResultSetMetaData metaData = null;
        final List list = new ArrayList();
        Map record = null;

        // do this in an excpetion handler so that we can depend on the
        // finally clause to close the connection
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sqlString);
            metaData = rs.getMetaData();
            final int fields = metaData.getColumnCount();

            while (rs.next()) {
                record = new HashMap();
                for (int i = 1; i <= fields; i++) {
                    try {
                        record.put(metaData.getColumnName(i), rs.getObject(i));
                    } catch (NullPointerException npe) {
                        // no need to do anything... if it fails, just ignore it and continue
                    }
                } // end for
                list.add(record);
            } // end while

        } catch (SQLException sqle) {
            throw sqle;
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                stmt.close();
                if (closeConnection) {
                    conn.close();
                }
            } catch (SQLException e) {
                throw e;
            } // end try
        } // end finally

        return list; // will  be null if none found
    }

    public Map getRecordByID(String table, String primaryKeyField, Object keyValue, boolean closeConnection)
	throws SQLException, Exception
	{
		Statement stmt = null;
		ResultSet rs = null;
		ResultSetMetaData metaData = null;
		final Map record=new HashMap();

		// do this in an excpetion handler so that we can depend on the
		// finally clause to close the connection
		try {
			stmt = conn.createStatement();
			String sql2;

			if(keyValue instanceof String){
				sql2 = "= '" + keyValue + "'";}
			else {
				sql2 = "=" + keyValue;}

			final String sql="SELECT * FROM " + table + " WHERE " + primaryKeyField + sql2;
			rs = stmt.executeQuery(sql);
			metaData = rs.getMetaData();
			metaData.getColumnCount();
			final int fields=metaData.getColumnCount();

			// Retrieve the raw data from the ResultSet and copy the values into a Map
			// with the keys being the column names of the table.
			if(rs.next() ) {
				for( int i=1; i <= fields; i++ ) {
					record.put( metaData.getColumnName(i), rs.getObject(i) );
				}
			}

		} catch (SQLException sqle) {
			throw sqle;
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				stmt.close();
				if(closeConnection) conn.close();
			} catch(SQLException e) {
				throw e;
			} // end try
		} // end finally

		return record;
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void main(String[] args) {
        DBGeneric db = new DBGeneric();
        List test = new ArrayList();
        try {
            db.openConnection("com.mysql.jdbc.Driver", 
                        "jdbc:mysql://localhost:3306/menu",
                        "root", "admin");
            test = db.findRecords("SELECT * FROM item", true);
            for (Object o : test) {
                System.out.println(o.toString());
            }
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(DBGeneric.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBGeneric.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBGeneric.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DBGeneric.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
