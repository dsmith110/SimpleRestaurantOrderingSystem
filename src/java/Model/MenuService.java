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
    
    public void saveItem(MenuItem item) throws SQLException, Exception {
        menu.save(item);
    }
    
    public static void main(String[] args) {
        MenuDAO dao = new MenuDAO(new DBGeneric());
        MenuService records = new MenuService();
        List<MenuItem> rec = new ArrayList<MenuItem>();
        List<MenuItem> record = new ArrayList<MenuItem>();
        MenuItem r = new MenuItem(3, "Some food", 14.99);
        int anFnItem = 0;
        try {
            // My local server
            //dao.openLocalDbConnection();
            records.saveItem(r);
            record = dao.getAllMenuItems();
//            anFnItem = records.deleteItem("0");
            rec = dao.getAllMenuItems();
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
//        System.out.println(r);
        for (MenuItem i : record) {
            System.out.println(i);
        }
        System.out.println("");
        System.out.println("");
        for (MenuItem i : rec) {
            System.out.println(i);
        }
//        System.out.println(anFnItem);
    }
}
