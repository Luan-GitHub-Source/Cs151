package minimac;

public class Load implements Instruction{
    private int loc;
    private int value;
    public Load(int loc, int value){
        this.loc = loc;
        this.value = value;
    }
    public void execute(MiniMac mac){
        Integer[] memory = mac.getMemory();
        memory[loc] = value;
    }

    @Override
    public String getCommandView() {
        return "load " + loc + " " + value;
    }
}