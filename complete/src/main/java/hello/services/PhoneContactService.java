package hello.services;

import java.io.FileNotFoundException;

public interface PhoneContactService {
    void loadAllContacts() throws FileNotFoundException;
    void viewAllContacts() throws FileNotFoundException;
    void addNewContact(String name, String surname, String number);

}
