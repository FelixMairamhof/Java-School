package shapes_files_paint;

public class Rectangle extends Shape{

    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.setWidth(width);
        this.setHeight(height);
    }


    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getCircumstance() {
        return 2 * height + 2 * width;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    @Override
    public String toString() {
        return super.toString() + String.format(", size [%d/%d]",
                this.getHeight(), this.getWidth());
    }
}
