import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Country> countries = readOlympicFile("Olympia2016.csv");
        writeOlympicSummary(countries);
        System.out.println("Rank: " + getCountryRanking(countries, "Österreich")); // 78
    }

    public static List<Country> readOlympicFile(String filename) {
        List<Country> countries = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            br.readLine();
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                Country country = new Country(Integer.parseInt(parts[0]), parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4]));
                countries.add(country);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return countries;
    }

    public static void writeOlympicSummary(List<Country> countries) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("OlympicSummary.txt"))) {
            writeNewLine(bw, "Medaillenspiegel Olympische Spiele Rio 2016 ");
            Collections.sort(countries, Comparator.comparingInt(Country::getMedaillenGesamt));

            // Write each country and its total medals count
            for (Country country : countries) {
                bw.write(country.getName() + ", Anzahl der Medaillen: " + country.getMedaillenGesamt() + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeNewLine(BufferedWriter bw, String text) {
        try {
            bw.write(text);
            bw.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int getCountryRanking(List<Country> countries, String countryName) {
        for (int i = 0; i < countries.size(); i++) {
            if (countries.get(i).getName().equalsIgnoreCase(countryName)) {
                return i + 1;
            }
        }
        return -1;
    }
}
