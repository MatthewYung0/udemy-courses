public class Main {

    public static void main(String[] args) {

        MobilePhone newPhone = new MobilePhone("111");

        Contact newContact1 = Contact.createContact("Matthew", "0708921425");
        newPhone.addNewContact(newContact1);
        newPhone.printContacts();
        Contact newContact2 = Contact.createContact("Matthew", "0708921425");
        newPhone.addNewContact(newContact2);
        newPhone.printContacts();

    }

}
