package at.htlklu.drawshapes;

import java.awt.*;

public interface Paintable {

    void paint(Graphics g);

    void setColor(Color color);

    Color getColor();

    void setPosition(Point point);
}
