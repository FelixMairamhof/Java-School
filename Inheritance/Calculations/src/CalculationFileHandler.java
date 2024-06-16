import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CalculationFileHandler {
    public static void main(String[] args) {
        List<Calculations> calculations = readCalculationsFromFile("calculations.txt");
        writeCalculationsResultFile(calculations,"calculation_results.txt");

        for (Calculations calculation : calculations) {
            Number result = calculation.getResult();
            System.out.println(calculation);
        }
    }
    public static List<Calculations> readCalculationsFromFile(String file){
        List<Calculations> calcs = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = br.readLine()) != null){
                calcs.add(Calculations.getCalculationFromString(line.trim()));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return calcs;
    }
    public static void writeCalculationsResultFile(List<Calculations> calcs, String file){
        Collections.sort(calcs, Comparator.comparing(calculations -> calculations.getResult().getDoubleValue()));

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
            for (Calculations c : calcs){
                bw.write(calcs.toString());
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
