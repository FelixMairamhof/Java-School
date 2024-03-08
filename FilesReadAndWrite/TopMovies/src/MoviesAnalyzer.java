import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class MoviesAnalyzer {

    public static void main(String[] args) {
        String filename = "TopMoviesUS.csv";
        List<Movie> movies = readMoviesFile(filename);
        generateMoviesResultFile(movies);
    }

    public static void generateMoviesResultFile(List<Movie> movies) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("result.txt"))) {
            bw.write("Movies Analyzer V1.0\n");
            bw.write("Analysierte Datei: TopMoviesUS.csv\n");
            bw.write("Anzahl der Filme in der Datei: " + movies.size() + "\n");
            bw.write("---------------------------------------------------------------\n");

            Movie erfolgreichsterFilm = movies.stream()
                    .max(Comparator.comparingInt(Movie::getMoneyGenerated))
                    .orElseThrow(() -> new RuntimeException("Keine Filme vorhanden"));

            Movie topBesucherFilm = movies.stream()
                    .max(Comparator.comparingInt(Movie::getViewersUS))
                    .orElseThrow(() -> new RuntimeException("Keine Filme vorhanden"));

            Movie kleinstesBudgetFilm = movies.stream()
                    .min(Comparator.comparingInt(Movie::getBudget))
                    .orElseThrow(() -> new RuntimeException("Keine Filme vorhanden"));

            Movie neuesterFilm = movies.stream()
                    .max(Comparator.comparing(Movie::getStartTime))
                    .orElseThrow(() -> new RuntimeException("Keine Filme vorhanden"));



            bw.write("Erfolgreichster Film: " + erfolgreichsterFilm + "\n");
            bw.write("Top Besucherzahlen: " + topBesucherFilm + "\n");
            bw.write("Kleinstes Budget: " + kleinstesBudgetFilm + "\n");
            bw.write("Neuester Film: " + neuesterFilm + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static List<Movie> readMoviesFile (String filename){
        List <Movie> movies = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))){
            String line;
            br.readLine();
            while ((line = br.readLine()) != null){
                String[] parts = line.split(";");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                LocalDate localdate = LocalDate.parse(parts[2],formatter);
                Movie m = new Movie(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), localdate,Integer.parseInt(parts[3]),parts[4],parts[5]);
                movies.add(m);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return movies;
    }
}
