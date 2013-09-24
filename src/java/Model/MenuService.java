package Model;

import java.sql.SQLException;
import java.util.List;

/**
 * High level service class that knows nothing about but how to return a data to
 * the controller. 
 * -----------------------
 * Needs to implement Create, Update, and Delete records
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
}
