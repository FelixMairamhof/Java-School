package Vehicles;

import java.util.Random;

public class RaceCar extends Vehicle{
    public RaceCar(String driver) {
        super(driver, 5.2);
    }

    @Override
    public void drive() {
        Random rnd = new Random();
        setKm(rnd.nextInt(60,201));
    }
}
