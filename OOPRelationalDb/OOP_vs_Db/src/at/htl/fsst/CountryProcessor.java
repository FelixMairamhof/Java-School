package at.htl.fsst;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CountryProcessor {
    private String inputFile;
    private String outputFile;
    private List<Country> countries = new ArrayList<Country>();
    private StringBuffer outputBuffer = new StringBuffer();


    public CountryProcessor(String input, String output) {
        this.inputFile = input;
        this.outputFile = output;
    }

    public static void main(String[] args) {

        CountryProcessor cp = new CountryProcessor("io/countries.csv", "io/output.txt");

        cp.readFile();
        cp.printCountries();
        cp.writeAllCountries();
        cp.writeCountriesHavingMoreInhabitantsThan(50_000_000);
        cp.writeAllCountriesNamesStartingWithJa();
        cp.writeNumberOfCountries();
        cp.writeAllCapitals();
        cp.writeCountryWithMostInhabitants();
        cp.writeAreaOfSmallestCountry();
        cp.writeAverageArea();
        cp.writeSumInhabitants();
          cp.writeFile();
    }

    private void writeSumInhabitants() {
        int sumInhabitants = this.countries.stream()
                .mapToInt(Country::getInhabitance)  // Convert the stream of Country to a stream of inhabitants (int)
                .sum();                             // Sum up the inhabitants

        append("Sum of Inhabitants: " + sumInhabitants);
    }


    private void writeAverageArea() {
        append("Avg Area: ");

        double averageArea = this.countries.stream()
                .mapToDouble(Country::getArea)   // Convert stream of Country to a stream of areas (double)
                .average()                       // Calculate the average
                .orElse(0.0);                    // Provide a default value if the stream is empty

        append(String.valueOf(averageArea)); // Append the calculated average
    }


    private void writeAreaOfSmallestCountry() {
        append("Country with smallest Area");
        this.countries.stream().min(Comparator.comparing(Country::getArea)).ifPresent(c -> append(c.toString()));
    }

    private void writeCountryWithMostInhabitants() {
        append("Country with most inhabitance");
        this.countries.stream().max(Comparator.comparing(Country::getInhabitance)).ifPresent(c -> append(c.toString()));
    }

    private void writeAllCapitals() {
        append("All Capitals");
        this.countries.stream().forEach(c -> append(c.getCapital()));
    }


    private void writeNumberOfCountries() {
        append("Number of Countries: " + countries.size());
    }

    private void writeAllCountriesNamesStartingWithJa() {
        append("All countries starting with Ja");
        this.countries.stream().filter(c -> c.getName().startsWith("Ja")).forEach(c -> append(c.toString()));
    }

    private void writeCountriesHavingMoreInhabitantsThan(int limit) {
        append("All countries have more than 50 000 000");
        this.countries.stream().filter(c -> c.getInhabitance() > limit)
                .forEach(c -> append(c.toString()));
    }

    private void writeFile() {
        try(PrintWriter out = new PrintWriter(new FileWriter(this.outputFile))) {
            out.println(this.outputBuffer.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void printCountries() {
        this.countries.forEach(c -> System.out.println(c.toString()));
    }

    private void append (String text){
        outputBuffer.append(String.format("%n"));
        outputBuffer.append(text);
    }

    private void writeAllCountries() {
        append("All Countries");

        for(Country c : this.countries) {
            append(c.toString());
        }
    }

    private void readFile() {
        try(BufferedReader in = new BufferedReader(new FileReader(this.inputFile))) {
            String line = null;
            line = in.readLine();
            System.out.println(line);
            while((line = in.readLine()) != null){
                this.countries.add(Country.of(line));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
