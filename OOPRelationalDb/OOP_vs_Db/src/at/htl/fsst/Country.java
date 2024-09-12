package at.htl.fsst;

public class Country {
    private String name;
    private String capital;
    private int inhabitance;
    private double area;
    private String iso;

    public static Country of (String line){
        String[] tokens = line.split(";");
        return new Country(tokens[0], tokens[1], Integer.parseInt(tokens[2]), Double.parseDouble(tokens[3]), tokens[4]);
    }

    public Country(String name, String capital, int inhabitance, double area, String iso) {
        this.name = name;
        this.capital = capital;
        this.inhabitance = inhabitance;
        this.area = area;
        this.iso = iso;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", inhabitance=" + inhabitance +
                ", area=" + area +
                ", iso='" + iso + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public int getInhabitance() {
        return inhabitance;
    }

    public void setInhabitance(int inhabitance) {
        this.inhabitance = inhabitance;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }
}
