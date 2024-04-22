package Vehicles;

import java.util.Random;

public class Motorbike extends Vehicle{
    public Motorbike(String driver) {
        super(driver, 8.3);
    }

    @Override
    public void drive() {
        Random rnd = new Random();
        setKm(rnd.nextInt(60,201));
    }

}
