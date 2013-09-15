package Model;

import java.util.List;

/**
 *
 * @author Dan Smith
 */
public class MenuService {
    private DatabaseStrategy menu;

    public MenuService(DatabaseStrategy menu) {
        this.menu = menu;
    }
    
    public List<MenuItem> getMenuItems() {
        return menu.getMenuItems();
    }
}
