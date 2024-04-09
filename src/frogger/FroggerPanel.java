package frogger;

import mvc.AppFactory;
import mvc.AppPanel;
import stopLight.StoplightFactory;
import stopLight.StoplightPanel;

import javax.swing.*;

public class FroggerPanel extends AppPanel {
    private JButton leap;
    public FroggerPanel(AppFactory factory) {
        super(factory);
        leap = new JButton("Leap");
        leap.addActionListener(this);
        controlPanel.add(leap);
    }

    public static void main(String[] args) {
        AppFactory factory = new FroggerFactory();
        AppPanel panel = new FroggerPanel(factory);
        panel.display();
    }
}
