import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import models.Cart;
import models.Item;
import models.Store;

public class Main {
    static Cart cart = new Cart();
    static Store store = new Store();

    public static void main(String[] args) {
        // Item obj2 = new Item("Spinach", 0.99);
        // Item obj1 = new Item("Celery", 0.99);
        // Item obj3 = new Item("Coriander", 1.29);

        // System.out.print(obj1);
        // System.out.print(obj2);
        // System.out.print(obj3);

        // Cart cart = new Cart();
        // cart.add(new Item("Celery", 0.99));
        // cart.add(new Item("Celery", 0.99));
        // cart.add(new Item("Spinach", 0.99));
        // cart.add(new Item("Coriander", 1.29));

        // System.out.println(cart);

        // Item[][] inventory = new Item[][] {
        // { new Item("Pepsi", 1.99), new Item("Crush", 1.99), new Item("Cola", 1.99) },
        // { new Item("Honey Oats", 3.99), new Item("Fruit Loops", 1.99), new
        // Item("Cheerios", 2.99) },
        // { new Item("Milk", 4.99), new Item("Eggs", 0.99), new Item("Cheese", 1.89) },
        // { new Item("Pepperoni", 2.99), new Item("Salami", 4.49), new
        // Item("Mortadella", 4.99) },
        // { new Item("Celery", 0.99), new Item("Spinach", 0.99), new Item("Coriander",
        // 1.29) },
        // { new Item("Shirt", 12.99), new Item("Pants", 24.99), new Item("Sweater",
        // 18.99) },
        // { new Item("Phone", 549.99), new Item("Printer", 349.99), new
        // Item("Television", 1099) }
        // };

        // Store store = new Store();

        // for (int i = 0; i < inventory.length; i++) {
        // for (int j = 0; j < inventory[i].length; j++) {
        // store.setItem(i, j, inventory[i][j]);
        // }
        // }

        // System.out.println("\n\t******************************JAVA
        // GROCERS******************************\n");
        // System.out.println(store + "\n");

        try {
            loadItems("products.txt");
            manageItems();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void manageItems() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n\t******************************JAVA GROCERS******************************\n");
            System.out.println(store);
            System.out.println("Options: \n\ta) Add to cart\n\tb) Remove from cart \n\tc) Checkout");
            String ans = sc.nextLine();

            switch (ans) {
                case "a":
                    System.out.println("enter a aisle number between: 1 - 7: ");

                    int aisle;
                    if (sc.hasNextInt()) {
                        aisle = sc.nextInt();
                    } else {
                        continue;
                    }
                    sc.nextLine();
                    int row = aisle - 1;
                    System.out.print("Choose an item number between: 1 – 3: ");
                    int itemNumber;
                    if (sc.hasNextInt()) {
                        itemNumber = sc.nextInt();
                    } else {
                        continue;
                    }
                    sc.nextLine();
                    int column = itemNumber - 1;

                    if (row < 0 || row > 6 || column < 0 || column > 2) {
                        continue;
                    }

                    Item item = store.getItem(row, column);
                    if (cart.add(item)) {
                        System.out.println(item.getName() + " was added to your shopping cart.");
                    } else {
                        System.out.println(item.getName() + " is already in your shopping cart.");
                    }
                    break;

                case "b":
                    if (cart.isEmpty()) {
                        continue;
                    }
                    System.out.print("Enter the item you'd like to remove: ");
                    String name = sc.nextLine();
                    cart.remove(name);
                    break;

                case "c":
                    if (cart.isEmpty()) {
                        continue;
                    }
                    System.out.println(cart.checkout());
                    sc.close();
                    return;

                default:
                    break;
            }
            System.out.println("\n\nSHOPPING CART\n\n" + cart);
            System.out.print("Enter anything to continue: ");
            sc.nextLine();
        }
    }

    /**
     * Name: manageItems
     * Inside the function:
     * • 1. Starts a new instance of Scanner;
     * • 2. Creates an infinite loop:
     * • The user can choose to a) add or b) remove c) checkout.
     * • case a: asks for the aisle and item number. Then, adds item to cart.
     * • case b: asks for the name. Then, removes item from cart.
     * • case c: prints the receipt and closes Scanner.
     * • Prints the updated shopping cart.
     */

    public static void loadItems(String fileName) throws FileNotFoundException {
        FileInputStream fin = new FileInputStream(fileName);
        Scanner sc = new Scanner(fin);
        int row = 0;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] items = line.split(";");
            for (int i = 0; i < items.length; i++) {
                String[] subItems = items[i].split("=");
                String name = subItems[0];
                double price = Double.parseDouble(subItems[1]);
                store.setItem(row, i, new Item(name, price));
            }
            row++;
        }
        sc.close();
    }

    /**
     * Name: loadItems
     * 
     * @param fileName (String)
     * @throws FileNotFoundException
     *
     *                               Inside the function:
     *                               1. loads items from <fileName>.txt.
     *                               • while loop runs through every line in
     *                               <fileName>
     *                               • scan.nextLine() picks up the entire line.
     *                               • splits each String using the ";" separator.
     *                               • splits both fields in each String using the
     *                               "=" separator.
     *                               • Parse each price into a Double.
     *                               2. adds all items to the store object's items
     *                               field.
     */

}
