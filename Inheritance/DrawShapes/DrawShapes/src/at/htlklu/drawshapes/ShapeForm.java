package at.htlklu.drawshapes;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ShapeForm {
    private JPanel panel1;
    private ShapePanel shapePanel1;


    public ShapeForm(){


    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ShapeForm");
        frame.setContentPane(new ShapeForm().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
