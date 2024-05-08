package at.htlklu.drawshapes;

import java.awt.*;

public abstract class PaintableThing implements Paintable{

    private Color color;
    protected Point position;


    public PaintableThing(){
        position = new Point(0,0);
        color = Color.black;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setPosition(Point position) {
        this.position = position;
    }
}
