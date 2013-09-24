package Model;

import java.util.List;

/**
 * Needs validation
 * ----------------
 * @author Dan Smith
 */
public class Reciept {
    private final int ZERO = 0;
    private final double TAX = 0.05;
    private final double GRATUITY = 0.15;
    
    public double calcTotal(List<MenuItem> orderedItems) {
        double total = ZERO;
        for(MenuItem m : orderedItems) {
            total += m.getPrice();
        }
        return total;
    }
    
    public double calcTax(List<MenuItem> orderedItems) {
        return calcTotal(orderedItems) * TAX;
    }
    
    public double calcGratuity(List<MenuItem> orderedItems) {
        return calcTotal(orderedItems) * GRATUITY;
    }
}
