package Model;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Dan Smith
 */
public class MenuService {
    private IMenuDAO menu;

    public MenuService() {
        DBAccessor db = new DBGeneric();
        menu = new MenuDAO(db);
    }
    
    public List<MenuItem> getAllMenuItems() throws ClassNotFoundException, SQLException, Exception {
        return menu.getAllMenuItems();
    }
}
