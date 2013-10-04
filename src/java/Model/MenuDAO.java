package Model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class has access to low level database class.
 * --------------------------------------------
 * 1. Possible generic DAO, moving all the connection information to low level
 *    DB object.
 * 
 * @author Dan Smith
 */
public class MenuDAO implements IMenuDAO<MenuItem> {
    private static final String FIND_ALL_ITEMS =
            "SELECT * from item";
    private static final String ITEM_BY_ITEM_ID =
            "SELECT * "
            + "FROM item "
            + "WHERE item.item_id = ";
    
    
//    private final String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
//    private final String URL = "jdbc:mysql://localhost:3306/menu";
//    private final String USERNAME = "root";
//    private final String PASSWORD = "admin";
    
    private String driverClassName;
    private String url;
    private String username;
    private String password;
    
    private final String ITEM_ID = "item_id";
    private final String ITEM = "item";
    private final String NAME = "name";
    private final String PRICE = "price";
    
    private DBAccessor db;

    public MenuDAO(DBAccessor db, String driverClassName, String url, String username, String password) {
        this.db = db;
        this.driverClassName = driverClassName;
        this.url = url;
        this.username = username;
        this.password = password;
    }
    
    @Override
    public List<MenuItem> getAllMenuItems() throws ClassNotFoundException, SQLException, Exception {
        this.openLocalDbConnection();

        List<Map> rawData = new ArrayList<Map>();
        List<MenuItem> menu = new ArrayList<MenuItem>();
        try {
            rawData = db.findRecords(FIND_ALL_ITEMS, true);
        } catch (SQLException e1) {
            throw new SQLException(e1.getMessage(), e1);

        } catch (Exception e2) {
            throw new Exception(e2.getMessage(), e2);
        }

        MenuItem item = null;

        // Translate List<Map> into List<Employee>
        for (Map m : rawData) {
            item = new MenuItem();

            String id = m.get(ITEM_ID).toString();
            item.setId(new Long(id));
            String name = m.get(NAME).toString();
            item.setName(name);
            String price = m.get(PRICE).toString();
            item.setPrice(new Double(price));

            menu.add(item);
        }
        
        return menu;
    }
    
    private void openLocalDbConnection() throws IllegalArgumentException, ClassNotFoundException, SQLException {
        try {
            // Each time you perform a new query you must re-open the connection
            db.openConnection(driverClassName, 
                        url,
                        username, password);
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException(ex.getMessage(), ex);
        } catch (ClassNotFoundException ex) {
            throw new ClassNotFoundException(ex.getMessage(), ex);
        } catch (SQLException ex) {
            throw new SQLException(ex.getMessage(), ex);
        }
    }
    
    @Override
    public void setDb(DBAccessor db) {
        
    }

    @Override
    public DBAccessor getDb() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    @Override
    public MenuItem getItemByItemId(String id) throws SQLException, Exception {
        this.openLocalDbConnection();
        
        List<Map> rawData = new ArrayList<Map>();
        //MenuItem record = new MenuItem();
        List<MenuItem> records = new ArrayList<MenuItem>();
        try {
            rawData = db.findRecords(ITEM_BY_ITEM_ID + id, true);
        } catch (SQLException e1) {
            throw new SQLException(e1.getMessage(), e1);

        } catch (Exception e2) {
            throw new Exception(e2.getMessage(), e2);
        }

        MenuItem dto = null;

        // Translate List<Map> into List<MenuItem>
        for (Map m : rawData) {
            dto = new MenuItem();
            String itemId = m.get(ITEM_ID).toString();
            dto.setId(new Long(id));
            String itemName = m.get(NAME).toString();
            dto.setName(itemName);
            String itemPrice = m.get(PRICE).toString();
            dto.setPrice(Double.parseDouble(itemPrice));
            records.add(dto);
        }
        
        return dto;
        //return record;
    }
    
    @Override
    public int deleteItem(String id) throws SQLException, Exception{
        this.openLocalDbConnection();
        int r = 0;
        try {
            r = db.deleteRecords(ITEM, ITEM_ID, id, true);
        } catch (SQLException e1) {
            throw new SQLException(e1.getMessage(), e1);

        } catch (Exception e2) {
            throw new Exception(e2.getMessage(), e2);
        }
        return r;
    }
    
    @Override
    public void save(MenuItem item) throws SQLException, Exception {
        this.openLocalDbConnection();
        
        String tableName = ITEM;
        List<String> fieldNames =
                new ArrayList<String>();
        fieldNames.add(NAME);
        fieldNames.add(PRICE);
        

        List fieldValues =
                new ArrayList();
        fieldValues.add(item.getName());
        fieldValues.add(item.getPrice());
        

        try {
            // if the id is null, it's a new record, else it's an update
            if (item.getId() == 0L) {
                db.insertRecord(
                        tableName, fieldNames,
                        fieldValues, true);
            } else {
                db.updateRecords(
                        tableName, fieldNames,
                        fieldValues, ITEM_ID, item.getId(), true);
            }
        } catch (SQLException e1) {
            throw new SQLException(e1.getMessage(), e1);

        } catch (Exception e2) {
            throw new Exception(e2.getMessage(), e2);
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//    public static void main(String[] args) {
//        MenuDAO dao = new MenuDAO(new DBGeneric());
//        List<MenuItem> records = new ArrayList<MenuItem>();
//        List<MenuItem> r = new ArrayList<MenuItem>();
//        MenuItem record = new MenuItem("Sirloinssssssss Steak", 14.99);
//        try {
//            // My local server
//            dao.openLocalDbConnection();
//            dao.save(record);
//            records = dao.getAllMenuItems();
////            record = dao.getItemByItemId("3");
//            record = dao.getItemByItemId("7");
//            r = dao.getAllMenuItems();
//        } catch (IllegalArgumentException ex) {
//            Logger.getLogger(MenuDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(MenuDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(MenuDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (Exception ex) {
//            Logger.getLogger(MenuDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }

//        System.out.println(record);
//        System.out.println("Found records...\n");
//        for (MenuItem i : records) {
//            System.out.println(i);
//        }
//        System.out.println("");
//        System.out.println("");
//        for (MenuItem i : r) {
//            System.out.println(i);
//        }
//        System.out.println(record);
//    }

    

}
