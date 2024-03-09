import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List <Country> countries = readOlympicFile("Olympia2016.csv");
        writeOlympicSummary(countries);
    }
    public static List<Country> readOlympicFile(String filename){
        List<Country> countries = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(filename))){
            String line;
            br.readLine();
            br.readLine();
            while((line = br.readLine()) != null){
                String[] parts = line.split(";");
                Country country = new Country(Integer.parseInt(parts[0]),parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4]));
                countries.add(country);
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }

        return countries;
    }
    public static void writeOlympicSummary (List<Country> countries){

        try(BufferedWriter bw = new BufferedWriter(new FileWriter("OlympicSummary.text"))){
            writeNewLine(bw, "Medaillenspiegel Olympische Spiele Rio 2016 ");

        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    private static void writeNewLine(BufferedWriter bw, String text) {
        try{
            bw.write(text);
            bw.newLine();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
