package Vehicles;

public abstract class Vehicle {
    private String driver;
    private int km;
    private double fuelPer100Km;

    public abstract void drive();

    @Override
    public String toString() {
        return String.format("%s: Driver: %s, km: %d, Fuel: %.3f l", this.getClass().getSimpleName(), driver,km, getConsumption());
    }

    public double getConsumption(){
        // errechnet Gesamtverbrauch aus km und Verbrauch auf 100 km
        return km/100.0 * fuelPer100Km;
    }

    public Vehicle(String driver,  double fuelPer100Km) {
        this.driver = driver;
        this.km = 0;
        this.fuelPer100Km = fuelPer100Km;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public double getFuelPer100Km() {
        return fuelPer100Km;
    }

    public void setFuelPer100Km(double fuelPer100Km) {
        this.fuelPer100Km = fuelPer100Km;
    }
}
