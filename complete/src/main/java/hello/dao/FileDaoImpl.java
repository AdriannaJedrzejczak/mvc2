package hello.dao;

import hello.dto.PhoneContact;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class FileDaoImpl implements FileDao {

    @Override
    public void ReadFromFile(File file) throws FileNotFoundException {
        Scanner inputStream = new Scanner(file);
        List<PhoneContact> phoneContacts = new ArrayList<>();

        while(inputStream.hasNext()) {
            String id = inputStream.next();
            String name = inputStream.next();
            String surname = inputStream.next();
            String number = inputStream.next();

            System.out.println("n: " + name + ", s: " + surname + ", number: " + number);
            PhoneContact phoneContact = new PhoneContact(){{Integer.parseInt(id); setName(name); setSurname(surname); setPhoneNumber(number);}};

        }
        inputStream.close();
    }
}
