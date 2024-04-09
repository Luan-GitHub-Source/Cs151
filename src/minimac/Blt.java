package minimac;

public class Blt implements Instruction{
    private int loc;
    private int offset;

    public Blt(int loc, int offset) {
        this.loc = loc;
        this.offset = offset;
    }

    public void execute(MiniMac mac){
        Integer[] memory = mac.getMemory();
        if(memory[loc] < 0){
            mac.setPointer(mac.getPointer() + offset);
        }
    }

    public String getCommandView(){
        return "blt " + loc + " " + offset;
    }
}
