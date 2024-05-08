package at.htlklu.drawshapes;

import java.awt.*;

public class Circle extends Shape{

    private double radius = DEFAULT_SIZE;

    public Circle(){
        this(DEFAULT_SIZE);
    }

    public Circle(double radius){
        this.radius = radius;
    }


    @Override
    public double getArea() {
        return radius*radius*Math.PI;
    }

    @Override
    public double getCircumference() {
        return 2*radius*Math.PI;
    }

   public static Circle getCircleFromArea(double area){
        double radius = Math.sqrt(area/Math.PI);
        return new Circle(radius);
   }

   public static Circle getCircleFromCircumference(double circumference){
        double radius = circumference/(2*Math.PI);
        return new Circle(radius);
   }

    @Override
    public String toString() {
        return super.toString()+ ", radius [" + String.format("%.2f",radius) +']';
    }

    @Override
    public void paint(Graphics g) {
         g.setColor(getColor());
        g.drawOval (position.x-(int)radius, position.y-(int)radius, (int) radius*2,(int)radius*2);
    }
}
