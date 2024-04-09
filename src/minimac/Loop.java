package minimac;

public class Loop implements Instruction{
    private int count;
    private Instruction instruction;
    public Loop(int count, Instruction instruction){
        this.count = count;
        this.instruction = instruction;
    }
    public void execute(MiniMac mac){
        for(int i = 0; i < count; i++){
            instruction.execute(mac);
            System.out.println(i + 1);
        }
    }

    @Override
    public String getCommandView() {
        return "loop " + count + " " + instruction.getCommandView();
    }
}