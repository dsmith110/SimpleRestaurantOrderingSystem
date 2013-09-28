package Model;

/**
 *
 * @author Dan Smith
 */
public class MenuItem {
    private long id;
    private String name;
    private double price;

    public MenuItem() {}

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }
    
    public MenuItem(long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "MenuItem{" + "id=" + id + ", name=" + name + ", price=" + price + '}';
    }
    
    
    
    public static void main(String[] args) {
        MenuItem test = new MenuItem();
        System.out.println(test);
    }
}
