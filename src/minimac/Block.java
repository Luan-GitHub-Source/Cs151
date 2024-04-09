package minimac;

import java.util.List;

public class Block implements Instruction{
    private List<Instruction> instructions;

    public Block(List<Instruction> instructions) {
        this.instructions = instructions;
    }

    @Override
    public void execute(MiniMac mac) {
        for(int i = 0; i < instructions.size(); i++){
            instructions.get(i).execute(mac);
        }
    }

    @Override
    public String getCommandView() {
        StringBuilder str = new StringBuilder();

        str.append("{ ");
        str.append(instructions.get(0).getCommandView());
        for(int i = 1; i < instructions.size(); i++){
            str.append(" ; ");
            str.append(instructions.get(i).getCommandView());
        }
        str.append(" }");

        return str.toString();
    }
}
