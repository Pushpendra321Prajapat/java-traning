package src.main.models;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Cart {
    ArrayList<Item> items;

    public Cart() {
        this.items = new ArrayList<Item>();
    }

    public Item getItem(int index) {
        return new Item(this.items.get(index));
    }

    public void setItem(int index, Item item) {
        this.items.set(index, new Item(item));
    }

    // public void add(Item item) {
    // this.items.add(new Item(item));

    // }

    public boolean add(Item item) {
        if (this.items.contains(item)) {
            return false;
        } else {
            this.items.add(new Item(item));
            return true;
        }
    }

    public boolean contains(Item item) {
        return this.items.contains(item);
    }

    public void remove(String name) {
        if (this.items.isEmpty()) {
            throw new IllegalStateException("Invalid State");
        }
        this.items.removeIf(element -> element.getName().equals(name));
    }

    public double getSubtotal() {
        return this.items.stream()
                .mapToDouble(ele -> ele.getPrice()).sum();
    }

    public double getTax(double subtotal) {
        double tax = subtotal * 0.13;
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.parseDouble(df.format(tax));
    }

    public double getTotal(double subtotal, double tax) {
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.parseDouble(df.format(subtotal + tax));
    }

    public String checkout() {
        if (this.items.isEmpty()) {
            throw new IllegalStateException("Invalid State");
        }
        return "\tRECEIPT\n\n" +
                "\tSubtotal: $" + this.getSubtotal() + "\n" +
                "\tTax: $" + this.getTax(this.getSubtotal()) + "\n" +
                "\tTotal: $" + this.getTotal(this.getSubtotal(), this.getTax(getSubtotal())) + "\n";
    }

    public void clear() {
        this.items.clear();
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < this.items.size(); i++) {
            temp += this.items.get(i).toString();
            temp += "\n";
        }
        return temp;
    }

}
