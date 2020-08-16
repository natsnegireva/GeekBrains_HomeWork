package homework3;

import java.util.LinkedList;
import java.util.List;

public class PhoneBook {

    private final List<Contacts> contactList;

    public PhoneBook() {
        this.contactList = new LinkedList<>();
    }

    public void addContact(String name, String phone) {
        this.contactList.add( new Contacts( name, phone ) );
    }

    public void getContactByName(String name) {
        String info = name + " : ";
        for (Contacts contacts : this.contactList) {
            if (contacts.getName().equalsIgnoreCase( name ))
                info = info + "\n" + contacts.getPhone();
        }

    }
}

