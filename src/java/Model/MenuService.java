package Model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * High level service class that knows nothing about but how to return a data to
 * the controller. 
 * -----------------------
 * Needs to implement Create, Update(Done), and Delete records
 * @author Dan Smith
 */
public class MenuService {
    private IMenuDAO menu;

    public MenuService() {
        DBAccessor db = new DBGeneric();
        menu = new MenuDAO(db);
    }

    public MenuService(IMenuDAO menu) {
        this.menu = menu;
    }
    
    public IMenuDAO getMenu() {
        return menu;
    }

    public void setMenu(IMenuDAO menu) {
        this.menu = menu;
    }
    
    public List<MenuItem> getAllMenuItems() throws ClassNotFoundException, SQLException, Exception {
        return menu.getAllMenuItems();
    }
    
    public MenuItem getItemById(String id) throws SQLException, Exception {
        return menu.getItemByItemId(id);
    }
    
    public int deleteItem(String id) throws SQLException, Exception {
        return menu.deleteItem(id);
    }
    
    public static void main(String[] args) {
        MenuDAO dao = new MenuDAO(new DBGeneric());
        MenuService record = new MenuService();
        int r = 0;
        List<MenuItem> records = new ArrayList<MenuItem>();
        try {
            // My local server
            //dao.openLocalDbConnection();
            
            records = dao.getAllMenuItems();
//            r = record.deleteItem("6");
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(MenuDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MenuDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MenuDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(MenuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }


        System.out.println("Found records...\n");
        System.out.println(r);
        for (MenuItem i : records) {
            System.out.println(i);
        }
        
    }
}
