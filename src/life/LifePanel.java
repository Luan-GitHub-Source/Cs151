package life;

import CALab.*;

public class LifePanel extends GridPanel {
    public LifePanel(LifeFactory factory) {
        super(factory);
    }

    public static void main(String[] args) {
        LifeFactory factory = new LifeFactory();
        LifePanel panel = new LifePanel(factory);
        panel.display();
    }
}
