package models;

import java.util.ArrayList;

public class ContactManager {
    private ArrayList<Contact> contacts;

    public ContactManager() {
        this.contacts = new ArrayList<Contact>();
    }

    public Contact getContact(int index) {
        return new Contact(this.contacts.get(index));
    }

    public void setContact(int index, Contact object) {
        this.contacts.set(index, new Contact(object));
    }

    public void addContact(Contact object) {
        this.contacts.add(new Contact(object));
    }

    public void removeContact(String contactName) {
        if (this.contacts.isEmpty()) {
            throw new IllegalArgumentException("can not remove from empty contact list");
        }
        for (int i = 0; i < this.contacts.size(); i++) {
            if (this.contacts.get(i).getName().equals(contactName)) {
                this.contacts.remove(i);
            }
        }
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < contacts.size(); i++) {
            temp += contacts.get(i).toString();
            temp += "\n \n";
        }
        return temp;
    }

}
