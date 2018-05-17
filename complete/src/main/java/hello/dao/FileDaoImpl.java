package hello.dao;

import hello.dto.PhoneContact;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Repository
public class FileDaoImpl implements FileDao {

    @Override
    public List<PhoneContact> ReadFromFile(File file) throws FileNotFoundException {
        List<PhoneContact> phoneContacts = new ArrayList<>();

        try (Scanner inputStream = new Scanner(file) ) {
            while (inputStream.hasNext()) {
                int id = inputStream.nextInt();
                String name = inputStream.next();
                String surname = inputStream.next();
                String number = inputStream.next();

                // System.out.println("id: " + id+"n: " + name + ", s: " + surname + ", number: " + number);
                PhoneContact phoneContact = new PhoneContact() {{
                    setId(id);
                    setName(name);
                    setSurname(surname);
                    setPhoneNumber(number);
                }};
                phoneContacts.add(phoneContact);
            }
        }

        return phoneContacts;
    }

    @Override
    public void SaveToFile(List<PhoneContact> contacts, File file) {
        try (PrintWriter out = new PrintWriter(file)) {
            for(int i = 0; i< contacts.size(); i++) {
                PhoneContact actual = contacts.get(i);
                out.println(actual.getId() + " " + actual.getName() + " " + actual.getSurname() + " " + actual.getPhoneNumber());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


}
