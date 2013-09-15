package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dan Smith
 */
public class FakeDatabase implements DatabaseStrategy<MenuItem>{
    private List<MenuItem> menuItems = new ArrayList();

    public FakeDatabase() {
        menuItems.add(new MenuItem("16 oz T-bone Steak", 15.99));
        menuItems.add(new MenuItem("Hand Battered Deep-Fried Chicken", 12.99));
        menuItems.add(new MenuItem("Pan seared Tilapia", 11.99));
        menuItems.add(new MenuItem("Baked Potato w/ Sour Creme and Chives", 4.99));
        menuItems.add(new MenuItem("Garden Salad w/ Choice of Dressing", 5.99));
        menuItems.add(new MenuItem("Ceasar Salad w/ Grilled Chicken", 12.99));
    }

    @Override
    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
    
    
}
