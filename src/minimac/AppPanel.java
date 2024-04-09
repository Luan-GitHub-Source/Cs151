package minimac;

import mvc.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppPanel  extends JPanel implements ActionListener {
    private MiniMac miniMac;
    private ControlPanel controls;
    private MinimacView view;

    public AppPanel() {
        //SET UP THE BASICS OF THE MAPP PANEL
        miniMac = new MiniMac();
        view = new MinimacView(miniMac);
        controls = new ControlPanel();
        this.setLayout((new GridLayout(1, 2)));
        this.add(controls);
        this.add(view);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container cp = frame.getContentPane();
        cp.add(this);
        frame.setJMenuBar(this.createMenuBar());
        frame.setTitle("Minimac");
        frame.setSize(500, 300);
        frame.setVisible(true);
    }


    protected JMenuBar createMenuBar() {
        //CREATE THE MENU BAR, INCLUDING FILE, EDIT, HELP
        JMenuBar result = new JMenuBar();
        JMenu fileMenu = Utilities.makeMenu("File", new String[]{"New", "Save", "Open", "Quit"}, this);
        result.add(fileMenu);
        JMenu editMenu = Utilities.makeMenu("Edit", new String[]{"Parse", "Run", "Clear"}, this);
        result.add(editMenu);
        JMenu helpMenu = Utilities.makeMenu("Help", new String[]{"About", "Help"}, this);
        result.add(helpMenu);
        return result;
    }


    public void actionPerformed(ActionEvent e) {
        String cmmd = e.getActionCommand();
        try {
            switch (cmmd) {
                case "Parse":
                    miniMac.parse();
                    break;

                case "Run":
                    miniMac.run();
                    break;

                case "Clear":
                    miniMac.clear();
                    break;

                default: {
                    throw new Exception("Unrecognized command: " + cmmd);
                }
            }

        } catch (Exception ex) {
            Utilities.error(ex);
        }
    }

    class ControlPanel extends JPanel {
        //CREATE A CONTROL PANELS WITH 3 BUTTONS: PARSE, RUN, CLEAR
        //ADD AN ACTION LISTENER TO EACH BUTTON
        public ControlPanel() {
            setBackground(Color.LIGHT_GRAY);
            JPanel p = new JPanel();

            p.setBackground(Color.LIGHT_GRAY);
            p.setLayout((new GridLayout(3,1,0,50)));

            JButton parse = new JButton("Parse");
            parse.addActionListener(AppPanel.this);

            JButton run = new JButton("Run");
            run.addActionListener(AppPanel.this);

            JButton clear = new JButton("Clear");
            clear.addActionListener(AppPanel.this);

            p.add(parse);
            p.add(run);
            p.add(clear);
            add(p);
        }
    }

    public static void main(String[] args) {

        AppPanel app = new AppPanel();
    }
}