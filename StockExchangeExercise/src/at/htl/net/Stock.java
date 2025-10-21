package at.htl.net;

public class Stock {

    private String symbol;
    private double change;
    private String name;
    private int volume;

    public Stock(String symbol, double change, String name, int volume) {
        this.symbol = symbol;
        this.change = change;
        this.name = name;
        this.volume = volume;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
