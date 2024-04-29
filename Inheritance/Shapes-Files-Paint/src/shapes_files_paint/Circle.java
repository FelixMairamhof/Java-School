package shapes_files_paint;

public class Circle extends Shape {

    private int radius;

    public Circle(int radius) {
        this.setRadius(radius);
    }

    @Override
    public double getArea() {
        return Math.pow(radius, 2) * Math.PI;
    }

    @Override
    public double getCircumstance() {
        return 2 * radius * Math.PI;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
    public static Circle getCircleFromArea(double area) {
        int r = (int) Math.sqrt(area / Math.PI);
        return new Circle(r);
    }
    public static Circle getCircleFromCircumstance(double circumstance) {
        int r = (int) (circumstance /( 2* Math.PI));
        return new Circle(r);
    }
    @Override
    public String toString() {
        return super.toString() + String.format(", size [%d]",
                this.getRadius());
    }
}
