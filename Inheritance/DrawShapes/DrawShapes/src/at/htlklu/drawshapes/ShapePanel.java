package at.htlklu.drawshapes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShapePanel extends JPanel {

    //toDo: HÜ: Random Shapes per Mausclick auf dem Panel zeichnen
    // 1. JFrame
    // 2. Panel auf den JFrame
    // 3. Listener am Panel
    // 4. paintComponent() -> alle Shapes zeichnen


    private List<Shape> shapes= new ArrayList<>();

    public ShapePanel(){
     this.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
             doMouseClicked(e);
         }
     });
 }

 public void doMouseClicked(MouseEvent e){
     System.out.println("Mouse clicked");


     Random rnd = new Random();
     int rndNum = rnd.nextInt(3);

     switch (rndNum){
         case 0:
             Circle c = new Circle(rnd.nextInt(Shape.DEFAULT_SIZE));
             c.setPosition(e.getPoint());
             c.setColor(Color.red);
             shapes.add(c);
             break;

         case 1:
             Rectangle r = new Rectangle(rnd.nextDouble(Shape.DEFAULT_SIZE), rnd.nextDouble(Shape.DEFAULT_SIZE));
             r.setPosition(e.getPoint());
             r.setColor(Color.green);
             shapes.add(r);
             break;

         case 2:
             Square s = new Square(rnd.nextDouble(Shape.DEFAULT_SIZE));
             s.setPosition(e.getPoint());
             s.setColor(Color.blue);
             shapes.add(s);
             break;
     }


     repaint();
 }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //zeichnet leere Fläche

        for (Shape s:
             shapes) {
            s.paint(g);

        }
    }
}
