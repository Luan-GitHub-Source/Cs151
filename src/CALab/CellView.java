package CALab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import mvc.*;


public class CellView extends JButton implements ActionListener, Subscriber {
    public Cell myCell;

    public CellView(Cell c) {
        myCell = c;
        if (c != null) {
            c.subscribe(this);
        }
        this.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        myCell.nextState();
    }

    // called by notifySubscribers and GridView.update
    public void update() {
        setBackground(myCell.getColor());
        setBorder(BorderFactory.createLineBorder(Color.black)); // needed?
        setText("" + myCell.getStatus());
    }

    public void setCell(Cell cell){
        myCell.unsubscribe(this);
        myCell = cell;
        myCell.subscribe(this);
        update();
    }
}