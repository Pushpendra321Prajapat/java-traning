import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("\n\n \t************************************************");
        System.out.println("\t             WELCOME TO JAVA DRINKS!            ");
        System.out.println("\t************************************************\n \n");

        Item[][] items = new Item[][] {
                { new Item("Pepsi", 1.99, 3), new Item("Fresca", 1.49, 3), new Item("Brisk", 2.49, 2) },
                { new Item("Fanta", 1.99, 2), new Item("Barq's", 1.49, 2), new Item("A & W", 2.49, 3) },
                { new Item("Crush", 1.99, 2), new Item("C-Cola", 1.49, 2), new Item("Berry", 2.49, 1) }
        };

        // for (int i = 0; i < items.length; i++) {
        // for (int j = 0; j < items[i].length; j++) {
        // System.out.print(items[i][j]);
        // }

        // }

        Machine machine = new Machine(items);

        // items[2][1].setPrice(2.99);

        // System.out.println(machine.getItems(2, 1));

        // Item getItem = machine.getItems(2, 1);
        // getItem.setPrice(2.99);
        // System.out.println(machine.getItems(2, 1));

        // machine.setItems(getItem, 2, 1);
        // System.out.println(machine.getItems(2, 1));

        // machine.dispense(0, 0);
        // machine.dispense(0, 0);
        // System.out.println(machine.getItems(0, 0));

        System.out.println(machine);
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("\nPick a row: ");
            int row = sc.nextInt();
            System.out.print("Pick a spot in the row: ");
            int spot = sc.nextInt();
            System.out.print("n");

            boolean availibity = machine.dispense(row, spot);
            System.out.println(machine);

            if (availibity == true) {
                System.out.println("\nEnjoy your drink! Press 1 to purchase another: ");
                char ch = sc.next().charAt(0);
                if (ch == '1') {
                    continue;
                } else {
                    break;
                }
            } else {
                System.out.println("\nSorry, we're out of this item. Press 1 to purchase another: ");
                char ch = sc.next().charAt(0);
                if (ch == '1') {
                    continue;
                } else {
                    break;
                }
            }
        }
        sc.close();
    }
}
