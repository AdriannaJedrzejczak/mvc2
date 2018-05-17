package hello.dao;

import java.io.File;
import java.io.FileNotFoundException;

public interface FileDao {
    void ReadFromFile(File file) throws FileNotFoundException;
}
