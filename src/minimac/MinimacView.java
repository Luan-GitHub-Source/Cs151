package minimac;

import mvc.Subscriber;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.List;

public class MinimacView extends JPanel implements Subscriber {
    private MiniMac miniMac;
    private JList<String> memoryView;
    private DefaultListModel<String> memoryModel;
    private JList<String> programView;
    private DefaultListModel<String> programModel;

    public MinimacView(MiniMac miniMac) {
        this.miniMac = miniMac;

        miniMac.subscribe(this);
        setSize(500, 500);
        Border blackLine = BorderFactory.createLineBorder(Color.black);
        setBorder(blackLine);
        setBackground(Color.WHITE);

        //MEMORY VIEW
        memoryModel = new DefaultListModel<>();
        updateMemoryView();
        memoryView = createList(memoryModel);


        //PROGRAM VIEW
        programModel = new DefaultListModel<>();
        programView = createList(programModel);

        setLayout(new GridLayout(2,1));

        add(new JScrollPane(memoryView));
        add(new JScrollPane(programView));
    }


    public JList<String> createList(DefaultListModel<String> model){
        //UTLITY CLASS USED TO MAKE A JLIST
        JList<String> list = new JList<>(model);
        list.setBorder(BorderFactory.createLineBorder(Color.black));
        return list;
    }
    public void update() {
        //UPDATE BOTH
        updateMemoryView();
        updateProgramView();
    }

    public void updateMemoryView(){
        //UPDATE THE MEEMORY VIEW
        memoryModel.clear();
        Integer[] memory = miniMac.getMemory();
        for(int i = 0; i < memory.length; i++){
            memoryModel.addElement("memory[" + i + "] = " + memory[i]);
        }
    }

    public void updateProgramView(){
        //UPDATE THE PROGRAM VIEW
        programModel.clear();
        List<Instruction> program = miniMac.getProgram();
        for(int i = 0; i < program.size(); i++){
            programModel.addElement(program.get(i).getCommandView());
        }
    }
}