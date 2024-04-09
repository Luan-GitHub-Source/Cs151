package minimac;

public class Mov implements Instruction{
    private int src;
    private int dest;

    public Mov(int src, int dest) {
        this.src = src;
        this.dest = dest;
    }

    public void execute(MiniMac mac){
        Integer[] memory = mac.getMemory();
        memory[dest] = memory[src];
    }

    public String getCommandView(){
        return "mov " + src + " " + dest;
    }
}
