package Vehicles;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class VehicleTest {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<Vehicle>();

        vehicles.add(new Motorbike("Gerals"));
        vehicles.add(new Motorbike("Mikosch"));
        vehicles.add(new Motorbike("Conni"));

        vehicles.add(new RaceCar("Helena"));
        vehicles.add(new RaceCar("Tobi"));
        vehicles.add(new RaceCar("Phil"));

        for (int i = 0; i <10; i++) {
            for (Vehicle v : vehicles) {
                v.drive();
            }
        }
        Collections.sort(vehicles,Comparator.comparing(Vehicle :: getConsumption).reversed());
        int count = 1;
        for (Vehicle v : vehicles) {
            System.out.println(count + ". " +v);
            count++;
        }
        write("ausgabe.txt",vehicles);

    }
    public static void write(String filename ,List<Vehicle> vehicles){
        try(BufferedWriter out = new BufferedWriter(new FileWriter(filename))){
            for(Vehicle v: vehicles){
                out.write(v.toString());
                out.newLine();
            }
        }catch (InvalidObjectException e){
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
