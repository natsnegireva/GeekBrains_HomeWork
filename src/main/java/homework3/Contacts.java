package homework3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Contacts {



    public static void get(String name) {
        HashMap<String, String> contacts = new HashMap<>();
        Set<Map.Entry<String, String>> set = contacts.entrySet();
        Iterator inter = set.iterator();

        while (!inter.hasNext()) {
            if (!contacts.containsKey( name )) {
                Map.Entry cont = (Map.Entry) inter.next();
                System.out.print( "Есть контакт: " + cont.getKey() + " - " + cont.getValue() );
                System.out.println();
            } else {
                System.out.print( "Такого контакта нет");
            }
        }
    }

    public static HashMap<String, String> add(String name, String phone) {
        HashMap<String, String> contacts = new HashMap<>();
        contacts.put( name, phone );
        System.out.println( "добавлен контакт :" + name + " - " + phone );
        return contacts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o == null || getClass() != o.getClass()) {
            return false;
        } else {
            Contacts contacts = (Contacts) o;
            return name.equals( contacts.name ) && phone.equals( contacts.phone );
        }
    }

    @Override
    public int hashCode() {
        if (this.phone == phone) {
            return 1;
        }
        return 0;
    }
}



