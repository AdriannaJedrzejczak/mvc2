package hello.view;

import hello.dao.FileDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Menu {

    @Autowired
    FileDao fileDao;


    public int DisplayMenu() throws FileNotFoundException {

        Scanner reader = new Scanner(System.in);

        System.out.println("Choose what to do:");
        System.out.println("1. Display phone book");

        int action = reader.nextInt();
        performAction(action);
        return action;
    }

    public void performAction( int action) throws FileNotFoundException {
        String fileName = "test.csv";

        File file =  new File(fileName);
        switch (action) {
            case 1: {
                fileDao.ReadFromFile(file);
                break;
            }

        }
    }

}
