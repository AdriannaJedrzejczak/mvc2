package hello.services;

import hello.dao.FileDao;
import hello.dto.PhoneContact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PhoneContactServiceImpl implements PhoneContactService{

    @Autowired
    FileDao fileDao;

    String fileName = "test.csv";
    List<PhoneContact> myContacts;

    @Override
    public void loadAllContacts() throws FileNotFoundException {
        File file =  new File(fileName);

        myContacts =fileDao.ReadFromFile(file);
    }

    @Override
    public void viewAllContacts() {
        display(myContacts);
    }

    @Override
    public void addNewContact(String name, String surname, String number) {
        File file =  new File(fileName);

        PhoneContact newContact = new PhoneContact()
        {{setId(getNextId()); setName(name); setSurname(surname); setPhoneNumber(number);}};
        this.myContacts.add(newContact);
        fileDao.SaveToFile(myContacts, file);
    }

    @Override
    public void searchForContact(String chainToLookFor) {
        List<PhoneContact> results = new ArrayList<>();
        String actualChain;
        for(int i = 0; i< myContacts.size(); i++ ) {
            PhoneContact actualContact = myContacts.get(i);
            actualChain = actualContact.getName() + actualContact.getSurname() + actualContact.getPhoneNumber();
            if(actualChain.contains(chainToLookFor)) {
                results.add(actualContact);
            }
        }
        display(results);

    }




    private void display(List<PhoneContact> phoneList) {
        for( int i = 0; i < phoneList.size(); i++) {
            PhoneContact actual = phoneList.get(i);
            System.out.println(actual.getId() + ". " + actual.getName() + " " + actual.getSurname() + " " + actual.getPhoneNumber() );
        }
    }

    private int getNextId() {
        int lastId = 0;
        for( int i = 0; i< myContacts.size(); i++ ) {
            if(lastId < myContacts.get(i).getId()) {
                lastId = myContacts.get(i).getId();
            }
        }
        return ++lastId;
    }
}
