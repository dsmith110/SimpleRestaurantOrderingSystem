package Model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Just a fake database I made for testing
 * @author Dan Smith
 */
public class FakeDatabase implements DBAccessor {
    private List<MenuItem> menuItems = new ArrayList();

    public FakeDatabase() {
        menuItems.add(new MenuItem(1, "16 oz T-bone Steak", 15.99));
        menuItems.add(new MenuItem(2, "Hand Battered Deep-Fried Chicken & Waffles", 12.99));
        menuItems.add(new MenuItem(3, "Pan seared Tilapia", 11.99));
        menuItems.add(new MenuItem(4, "Baked Potato w/ Sour Creme and Chives", 4.99));
        menuItems.add(new MenuItem(5, "Garden Salad w/ Choice of Dressing", 5.99));
        menuItems.add(new MenuItem(6, "Ceasar Salad w/ Grilled Chicken", 12.99));
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public void openConnection(String driverClassName, String url, String username, String password) throws IllegalArgumentException, ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void closeConnection() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List findRecords(String sqlString, boolean closeConnection) throws SQLException, Exception {
        return menuItems;
    }
    
    
}
