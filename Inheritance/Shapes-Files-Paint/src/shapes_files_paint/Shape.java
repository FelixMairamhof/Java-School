package shapes_files_paint;

public abstract class Shape {

    private int id;
    private static int counter = 0;
    protected final int DEFAULT_SIZE = 100;

    public Shape() {
        counter++;
        this.id = counter;
    }

    public abstract double getArea();
    public abstract double getCircumstance();

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("%s: id: %d, Area: %.2f, Circumreference: %.2f",
                getClass().getSimpleName(), getId(), getArea(), getCircumstance());
    }
}
