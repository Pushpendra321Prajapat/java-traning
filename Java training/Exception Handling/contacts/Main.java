
import java.io.FileInputStream;
import java.util.Scanner;
import models.Contact;
import models.ContactManager;

public class Main {
    static ContactManager cm = new ContactManager();

    public static void main(String[] args) {

        try {
            loadContacts("contacts.txt");
            System.out.println("CONTACTS LOADED\n\n");
            System.out.println(cm);
            manageContacts();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("\nProcess Complete.");
        }

        // try {
        // Contact object1 = new Contact("Alan", "6789234526", "07/23/1912");
        // System.out.println(object1);
        // } catch (ParseException e) {
        // System.out.println(e.getMessage());
        // } finally {
        // System.out.println("Process Complete");
        // }

        // try {
        // ContactManager cm = new ContactManager();
        // Contact c1 = new Contact("Ryan", "6135012424", "11/11/1992");
        // Contact c2 = new Contact("Gio", "6477092344", "11/11/1993");
        // Contact c3 = new Contact("Thomas", "8192256979", "11/11/1994");

        // cm.addContact(c1);
        // cm.addContact(c2);
        // cm.addContact(c3);
        // cm.removeContact("Gio");
        // System.out.println(cm);
        // } catch (ParseException e) {
        // System.out.println(e.getMessage());
        // } finally {
        // System.out.println("Process Complete");
        // }

    }

    public static void manageContacts() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(" Would you like to \n\ta) add another contact\n\tb) remove a contact \n\tc) exit");
            String ans = sc.nextLine();
            if (ans.equals("a")) {
                System.out.print("\tName: ");
                String name = sc.nextLine();
                System.out.print("\tPhone Number: ");
                String phoneNumber = sc.nextLine();
                System.out.print("\tBirth Date: ");
                String birthDate = sc.nextLine();

                if (name.isBlank() || phoneNumber.isBlank() || phoneNumber.length() < 5) {
                    System.out.println("provided input is not valid. registration failed. ");
                } else {
                    try {
                        cm.addContact(new Contact(name, phoneNumber, birthDate));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    } finally {
                        System.out.println("\n\nUPDATED CONTACTS\n\n" + cm);
                    }
                }

            } else if (ans.equals("b")) {
                System.out.println("\nWho would you like to remove?");
                String name = sc.nextLine();
                cm.removeContact(name);
                System.out.println("\n\nUPDATED CONTACTS\n\n" + cm);
            } else {
                break;
            }
        }
        sc.close();
    }

    /**
     * Name: manageContacts
     *
     * Inside the function:
     * • 1. Starts a new instance of Scanner;
     * • 2. In an infinite loop, the user can choose to a) add b) remove a contact
     * c) exit.
     * • case a: ask for the name, phone number and birthDate.
     * • case b: ask who they'd like to remove.
     * • case c: break the loop.
     * • 3. close Scanner.
     */

    public static void loadContacts(String fileName) throws Exception {
        FileInputStream fin = new FileInputStream(fileName);
        Scanner sc = new Scanner(fin);
        while (sc.hasNextLine()) {
            try {
                Contact object = new Contact(sc.next(), sc.next(), sc.next());
                cm.addContact(object);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        sc.close();
    }

    /**
     * Name: loadContacts
     * 
     * @param fileName (String)
     * @throws FileNotFoundException
     *
     *                               Inside the function:
     *                               • 1. loads contacts from <fileName>;
     *                               • 2. From the manager object, it adds all
     *                               contacts to the contacts list.
     *                               Hint: use scan.next to grab the next String
     *                               separated by white space.
     */

}
