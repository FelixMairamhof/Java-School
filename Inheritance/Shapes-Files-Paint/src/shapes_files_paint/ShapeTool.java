package shapes_files_paint;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShapeTool {
    public static void main(String[] args) {
        List<Shape> shapes = generateRandomShapes(5);

        for (Shape shape : shapes) {
            System.out.println(shape);
        }

    }
    static List<Shape> generateRandomShapes(int count){
        List<Shape> shapes = new ArrayList<>();

        Random rnd = new Random();
        int randomNumber = rnd.nextInt(0,3);


        for (int i = 0; i < count; i++) {
            switch (randomNumber){
                case 0:
                    shapes.add(new Circle(rnd.nextInt(100)));
                    break;
                case 1:
                    shapes.add(new Rectangle(rnd.nextInt(100), rnd.nextInt(100)));
                    break;
                case 2:
                    shapes.add(new Square(rnd.nextInt(100)));
                    break;

            }
        }
        return shapes;

    }
}
