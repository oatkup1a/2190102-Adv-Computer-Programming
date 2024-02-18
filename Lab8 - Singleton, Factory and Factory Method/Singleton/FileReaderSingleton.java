import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderSingleton {
    private static FileReaderSingleton instance;
    private BufferedReader reader;
    private void openFile() {
    try {
        reader = new BufferedReader(new FileReader("C:\\Coding Project\\Adv Com Prog\\Final\\Singleton\\src\\data.txt"));
    } catch (FileNotFoundException e) {
        e.printStackTrace();
        }
    }

    private FileReaderSingleton() {
        openFile();
    }

    public static FileReaderSingleton getInstance(){
        if(instance==null){
            instance = new FileReaderSingleton();
        }
        return instance;
    }

    public String readLineFromFile() {
        try {
            String line = reader.readLine();
            return line;
        } catch (IOException e) {
            e.printStackTrace();
        } 
        return null;
    }

    public void closeFile(){
        try {
            reader.close();
            openFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
