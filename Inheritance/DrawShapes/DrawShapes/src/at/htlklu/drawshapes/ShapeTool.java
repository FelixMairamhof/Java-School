package at.htlklu.drawshapes;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class ShapeTool {

    public static List<Shape> generateRandomShapes(int count){
        List<Shape> shapes = new ArrayList<>();
        Random rand = new Random();
        for(int i= 0; i < count; i++){
            int shape = rand.nextInt(3);
            if(shape == 0){
                shapes.add(new Circle(rand.nextDouble()*Shape.DEFAULT_SIZE));
            } else if (shape == 1) {
                shapes.add(new Square(rand.nextInt(1,Shape.DEFAULT_SIZE)));
            }else{
                shapes.add(new Rectangle(rand.nextInt(1,Shape.DEFAULT_SIZE),rand.nextInt(1,Shape.DEFAULT_SIZE)));
            }
        }

        return shapes;
    }


    public static void writeShapesToFile(List<Shape> shapes, String filename){

        Collections.sort(shapes, Comparator.comparing(Shape::getArea).thenComparing(Shape::getCircumference));
        try (PrintWriter out = new PrintWriter(filename)){
            for(Shape s:shapes){
                out.println(s);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        List <Shape> shapes = generateRandomShapes(20);
        shapes.forEach(System.out::println);
        writeShapesToFile(shapes,"sorted_shapes.txt");
    }
}
