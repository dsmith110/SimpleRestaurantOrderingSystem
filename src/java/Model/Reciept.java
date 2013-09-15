package Model;

import java.util.List;

/**
 *
 * @author Dan Smith
 */
public class Reciept {
    
    public double calcTotal(List<MenuItem> orderedItems) {
        double total = 0;
        for(MenuItem m : orderedItems) {
            total += m.getPrice();
        }
        return total;
    }
    
    public double calcTax(List<MenuItem> orderedItems) {
        return calcTotal(orderedItems) * .05;
    }
    
    public double calcGratuity(List<MenuItem> orderedItems) {
        return calcTotal(orderedItems) * .15;
    }
}
