import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentFileManager {
    public static void main(String[] args) {
        List<Student> students = readFile("students_grades.csv");

    }
    public static List<Student> readFile(String file) {
        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");

                // Debugging statement to check parts split
                System.out.println("Parts length: " + parts.length);
                System.out.println("Line: " + line);

                // Ensure the parts array has the expected length

                students.add(new Student(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]), Double.parseDouble(parts[4]), Double.parseDouble(parts[5])));

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NumberFormatException e) {
            // Handle NumberFormatException (e.g., log error, skip line, etc.)
            System.err.println("Error parsing number in line: " + e.getMessage());
        }

        return students;
    }

    public static void analyzeStudents(List<Student> students){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("result.txt"))){
            bw.write("Schüler der 3BHEL");
            bw.newLine();
            bw.write("-------------------------------------------");
            bw.newLine();
            int count = 0;
            for (Student student : students){
                if(student.getClassName().equals("3BHEL")){
                    count ++;
                }
            }
            bw.write("Anzahl: " + count);
            bw.newLine();
            for (Student student : students){
                if(student.getClassName().equals("3BHEL")){
                    bw.write(student.toString());
                    bw.newLine();
                }
            }
            students.sort(Comparator.comparingDouble(Student :: getGradeAverage));
            bw.write("Best Grades: "+students.getFirst().toString());
            bw.newLine();

            students.sort(Comparator.comparingDouble(Student :: getHeight));
            bw.write("Greatest Height: "+students.getFirst().toString());
            bw.newLine();

            students.sort(Comparator.comparingDouble(Student :: getGradeAverage).reversed());
            for (int i = 0; i < 3; i++) {
                bw.write("Smallest: " + students.get(i).toString());
                bw.newLine();
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
