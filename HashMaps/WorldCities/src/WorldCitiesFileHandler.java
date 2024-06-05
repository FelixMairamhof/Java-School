import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorldCitiesFileHandler extends FileHandler {
    private String inputFilename;
    private String outputFilename;
    private String selectedCountryIso;
    private Map<String, List<City>> citiesByCountry = new HashMap<>();

    // Konstruktor
    public WorldCitiesFileHandler(String inputFilename, String outputFilename, String selectedCountryIso) {
        this.inputFilename = inputFilename;
        this.outputFilename = outputFilename;
        this.selectedCountryIso = selectedCountryIso;
    }

    // Methode zur Behandlung einer Zeile aus der Datei
    @Override
    void handleLine(String line) {
        String[] fields = line.split(";");
        String cityName = fields[0];
        String country = fields[4];
        double population = Double.parseDouble(fields[3]);
        String iso3 = fields[5];

        City city = new City(cityName, (int)population, country, iso3);
        citiesByCountry.computeIfAbsent(iso3, k -> new ArrayList<>()).add(city);
    }

    // Methode zum Schreiben der Ausgabedatei
    @Override
    void writeFile(String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            if (citiesByCountry.containsKey(selectedCountryIso)) {
                List<City> cities = citiesByCountry.get(selectedCountryIso);
                // Sortieren der Städte nach Namen und dann nach Einwohnerzahl
                cities.sort(Comparator.comparing(City::getName).thenComparing(City::getPopulation));

                // Schreiben der Städte in die Datei
                for (City city : cities) {
                    writer.write(city.toString() + "\n");
                }

                // Stadt mit den meisten und den wenigsten Einwohnern finden
                City cityWithHighestPopulation = Collections.max(cities, Comparator.comparing(City::getPopulation));
                City cityWithLowestPopulation = Collections.min(cities, Comparator.comparing(City::getPopulation));

                writer.write("City with highest population: " + cityWithHighestPopulation.getName() + "\n");
                writer.write("City with lowest population: " + cityWithLowestPopulation.getName() + "\n");
            } else {
                writer.write("No cities found for the given country ISO code.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Methode zum Ausführen der Lese- und Schreiboperationen
    @Override
    public void run() {
        readFile(inputFilename, true);
        writeFile(outputFilename);
    }
}
