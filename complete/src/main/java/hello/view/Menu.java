package hello.view;

import hello.dao.FileDao;
import hello.dao.FileDaoImpl;
import hello.dto.PhoneContact;
import hello.services.PhoneContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

@Component
public class Menu {

    @Autowired
    PhoneContactService phoneContactService;


    public int DisplayMenu() throws FileNotFoundException {

        Scanner reader = new Scanner(System.in);
        System.out.println("***************************************************");

        System.out.println("Choose what to do:");
        System.out.println("1. Display phone book");
        System.out.println("2. Add new phone contact");
        phoneContactService.loadAllContacts();


        int action = reader.nextInt();
        performAction(action);
        return action;
    }

    public void performAction( int action) throws FileNotFoundException {
        Scanner reader = new Scanner(System.in);

        switch (action) {
            case 1: {
                phoneContactService.viewAllContacts();
                System.out.println();
                break;
            }
            case 2: {
                String name, surname, number;
                System.out.println("Enter name: ");
                name = reader.nextLine();
                System.out.println("Enter surname: ");
                surname = reader.nextLine();
                System.out.println("Enter phone number: ");
                number = reader.nextLine();

                phoneContactService.addNewContact(name, surname, number);
                System.out.println( name + " " + surname + " added!");
                System.out.println();

                break;
            }
            default: {
                System.out.println("Wrong option, try again");
                DisplayMenu();
            }

        }
        DisplayMenu();

    }



}
