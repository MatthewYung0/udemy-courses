import java.util.ArrayList;

public class MobilePhone {

    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String number) {
        this.myNumber = number;
        this.myContacts = new ArrayList<Contact>();
    }

    public boolean addNewContact(Contact contact) {
        if (findContact(contact) == -1) {
            myContacts.add(contact);
            return true;
        }
        return false;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        if (findContact(oldContact) >= 0) {
            myContacts.set(findContact(oldContact), newContact);
            return true;
        }
        return false;
    }

    public boolean removeContact(Contact contact) {
        if (findContact(contact) >= 0) {
            myContacts.remove(findContact(contact));
            return true;
        }
        return false;
    }

    private int findContact(Contact contact) {
        for (int i = 0; i < myContacts.size(); i++) {
            if ((contact.getName().equals(myContacts.get(i).getName())) && (contact.getPhoneNumber().equals(myContacts.get(i).getPhoneNumber()))) {
                return i;
            }
        }
        return -1;
    }

    private int findContact(String contact) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (contact.equals(myContacts.get(i).getName())) {
                return i;
            }
        }
        return -1;
    }

    public Contact queryContact(String name) {
        if (findContact(name) >= 0) {
            return myContacts.get(findContact(name));
        }
        return null;
    }

    public void printContacts() {
        System.out.println("Contact List:");
        for (int i = 0; i < myContacts.size(); i++) {
            Contact contact = myContacts.get(i);
            System.out.println(i+1 + ". " + contact.getName() + " -> " + contact.getPhoneNumber());
        }
    }
}
