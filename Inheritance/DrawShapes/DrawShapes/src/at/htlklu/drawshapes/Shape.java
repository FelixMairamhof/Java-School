package at.htlklu.drawshapes;

public abstract class Shape extends PaintableThing{

    private int id;

    private static int shapecount = 0;

    public static final int DEFAULT_SIZE = 100;

    public Shape(){
        shapecount++;
        id = shapecount;
    }

    public abstract double getArea();
    public abstract double getCircumference();

    @Override
    public String toString() {
        return String.format("%s: id: [%d], Area: %.2f, Circumference: %.2f",
                this.getClass().getSimpleName(),
                id,
                getArea(),getCircumference()
        );
    }
}
