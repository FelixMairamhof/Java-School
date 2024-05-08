package at.htlklu.drawshapes;

import java.awt.*;

public class Rectangle  extends Shape{

    private double width, height;

    public Rectangle(){
        this(DEFAULT_SIZE,DEFAULT_SIZE);
    }
    public Rectangle(double width, double height) {
        super();  // explicit constructor call
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getArea() {
        return width*height;
    }

    @Override
    public double getCircumference() {
        return 2*(width+height);
    }

    @Override
    public String toString() {
        return super.toString()+ ", size [" + width+"/"+height +']';
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(getColor());
        g.drawRect(position.x, position.y, (int) width,(int) height);
    }
}
