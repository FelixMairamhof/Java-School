import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MoviesAnalyzer {
    public static void main(String[] args) {
        String filename = "TopMoviesUS.csv";
        List <Movie> movies = readMoviesFile(filename);
    }
    public static List<Movie> readMoviesFile (String filename){
        List <Movie> movies = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))){
            String line;
            br.readLine();
            while ((line = br.readLine()) != null){
                String[] parts = line.split(";");
                Movie m = new Movie(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), LocalDate.parse(parts[2]),Integer.parseInt(parts[3]),parts[4],parts[5]);
                movies.add(m);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return movies;
    }
}
