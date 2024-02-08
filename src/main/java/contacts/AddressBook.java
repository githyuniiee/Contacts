package contacts;

import java.util.*;

public class AddressBook {

    private List<Contact> contacts = new ArrayList<Contact>();

    public void saveContact(Contact contact){
        contacts.add(contact);
    }


    public List<Contact> displayContacts(){
        return contacts;
    }


    Contact searchContact(String name){

        for(Contact contact : contacts){
            if(name.equals(contact.getName())){
                return contact;
            }
        }
        return null;
    }


}
