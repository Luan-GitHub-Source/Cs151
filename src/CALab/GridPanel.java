package CALab;

import mvc.AppPanel;

import javax.swing.*;

public class GridPanel extends AppPanel {
    public GridPanel(GridFactory factory) {
        super(factory);

        JButton run1 = new JButton("Run1");
        run1.addActionListener(this);
        JButton run50 = new JButton("Run50");
        run50.addActionListener(this);
        JButton populate = new JButton("Populate");
        populate.addActionListener(this);
        JButton clear = new JButton("Clear");
        clear.addActionListener(this);

        controlPanel.add(run1);
        controlPanel.add(run50);
        controlPanel.add(populate);
        controlPanel.add(clear);
    }
}
