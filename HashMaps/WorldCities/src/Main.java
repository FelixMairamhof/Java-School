public class Main {
    public static void main(String[] args) {
        FileHandler fh = new WorldCitiesFileHandler("cities_2023.csv", "Cities_USA.txt", "USA");
        fh.run();
    }
}
