import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public abstract class FileHandler {

    abstract void handleLine(String line);

    void readFile(String fileName, boolean hasHeader) {

        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                if(hasHeader && isFirstLine) {
                    isFirstLine = false;
                    continue;
                 }
                handleLine(line);
            }

        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    abstract void writeFile(String fileName);

    public void run(){
        readFile("input.txt", true);
        writeFile("output.txt");
    }
}
