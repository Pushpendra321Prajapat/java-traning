package models;

import java.util.ArrayList;

public class Cart {

    private ArrayList<Item> items;

    public Cart() {
        this.items = new ArrayList<Item>();
    }

    public Item getItem(int index) {
        return new Item(this.items.get(index));
    }

    public void setItem(int index, Item item) {
        this.items.set(index, new Item(item));
    }

    public boolean add(Item item) {
        if (this.items.contains(item)) {
            return false;
        } else {
            this.items.add(new Item(item));
            return true;
        }
    }

    /**
     * Name: add
     * 
     * @param item
     * @return boolean
     *
     *         Inside the function:
     *         1. Adds an item to the cart if it wasn't already added.
     */

    public void remove(String name) {
        if (items.isEmpty()) {
            throw new IllegalStateException("cannot remove from an empty cart");
        }
        for (int i = 0; i < items.size(); i++) {
            if (this.items.get(i).getName().equals(name)) {
                this.items.remove(i);
            }
        }
    }

    /**
     * Name: remove
     * 
     * @param name
     *
     *             Inside the function:
     *             1. Removes the item that matches the name passed in.
     */

    public String checkout() {
        if (items.isEmpty()) {
            throw new IllegalStateException("cannot checkout an empty cart");
        }
        double subtotal = 0;
        for (int i = 0; i < items.size(); i++) {
            subtotal += this.items.get(i).getPrice();
        }

        double tax = subtotal * 0.13;
        double total = subtotal + tax;
        String temp = "\tRECEIPT\n\n" +
                "\tSubtotal: $" + subtotal + "\n" +
                "\tTax: $" + tax + "\n" +
                "\tTotal: $" + total + "\n";
        return temp;
    }

    /**
     * Name: checkout
     * 
     * @return (String)
     *
     *         Inside the function:
     *         1. Calculates the subtotal (price before tax).
     *         2. Calculates the tax (assume tax is 13%).
     *         3. Calculates total: subtotal + tax
     *         4. Returns a String that resembles a receipt. See below.
     */

    public String toString() {
        String temp = "";
        for (int i = 0; i < this.items.size(); i++) {
            temp += this.items.get(i).toString();
            temp += "\n";
        }
        return temp;
    }

    public boolean isEmpty() {
        return this.items.isEmpty();
    }

}
