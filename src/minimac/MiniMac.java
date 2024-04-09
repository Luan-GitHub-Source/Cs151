package minimac;

import mvc.Publisher;

import javax.swing.*;
import java.io.*;
import java.util.Arrays;
import java.util.List;

public class MiniMac extends Publisher implements Serializable {
    private int size = 32;
    private Integer[] memory = new Integer[size];

    private List<Instruction> program;

    private int instructionPointer;

    public MiniMac(){
        //FILLS ALL THE MEMORY LOCATIONS WITH 0 UPON CREATION
        Arrays.fill(memory, 0);
    }

    public void parse(){//FILE SELECTOR

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result = fileChooser.showDialog(null, "Choose File");

        if (result == JFileChooser.APPROVE_OPTION) {
            readFile(fileChooser.getSelectedFile());
        }

        notifySubscribers();
    }

    public void readFile(File file){
        //COVNERT TXT FILE INTO A SINGLE STRING AND PASS IT THROUGH THE MINIMACPARSER
        BufferedReader reader = null;

        try {
            String path = file.getPath();
            reader = new BufferedReader(new FileReader(path + (path.substring(path.length() - 4, path.length()).equals(".txt") ? "" : ".txt")));

            StringBuilder stringBuilder = new StringBuilder();

            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(System.lineSeparator());//add new line
            }

            // Convert StringBuilder to a single string
            String fileContent = stringBuilder.toString();
            program = MiniMacParser.parse(fileContent);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void run(){
        //EXECUTE EVERY INSTRUCTION IN THE PROGRAM USING THE STRATEGY PATTERN
        for(instructionPointer = 0; instructionPointer < program.size(); instructionPointer++){
            program.get(instructionPointer).execute(this);
        }
        notifySubscribers();
    }

    public void clear(){
        //SET ALL MEMORY LOCATIONS BACK TO 0
        for(int i = 0; i < memory.length; i++){
            memory[i] = 0;
        }
        notifySubscribers();
    }
    public Integer[] getMemory(){
        //GET THE MEMORY ARRAY
        return memory;
    }
    public List<Instruction> getProgram(){
        //GET THE PROGRAM LIST
        return program;
    }
    public int getPointer(){
        return instructionPointer;
    }
    public void setPointer(int index){
        instructionPointer = index;
    }
}
