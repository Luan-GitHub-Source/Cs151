package frogger;

import mvc.Utilities;
import mvc.View;
import stopLight.StopLightShape;
import stopLight.Stoplight;

import java.awt.*;
import java.util.Random;

public class FroggerView extends View {

    public FroggerView(Frogger frogger) {
        super(frogger);
    }

//    public void paintComponent(Graphics gc) {
//        super.paintComponent(gc);
//        Color oldColor = gc.getColor();
//        Stoplight light = (Stoplight)model;
//        StopLightShape shape = new StopLightShape(light);
//        shape.draw((Graphics2D) gc);
//        gc.setColor(oldColor);
//    }

    protected void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        setBackground(Color.BLUE); // cuz water is blue

        Frogger frogger = (Frogger)model;
        gc.setColor(Color.green);
        gc.fillOval(frogger.getx(),frogger.gety(),25,25);

        // now use gc.fillOval to draw a green circle
    }
}
