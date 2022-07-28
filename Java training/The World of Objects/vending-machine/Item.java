//import org.junit.validator.PublicClassValidator;

public class Item {
    private String name;
    private double price;
    private int quantity;

    public Item(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Item(Item source) {
        this.name = source.name;
        this.price = source.price;
        this.quantity = source.quantity;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public void setPrice(double Price) {
        this.price = Price;
    }

    public void setQuantity(int Quantity) {
        this.quantity = Quantity;
    }

    public String toString() {
        return this.name + ": " + " " + this.price + "  " + "(" + this.quantity + ") ";
    }
}
