package hello.dao;

import hello.dto.PhoneContact;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public interface FileDao {
    List<PhoneContact> ReadFromFile(File file) throws FileNotFoundException;
    void SaveToFile(List<PhoneContact> contacts, File file);
}
