package minimac;

public class Bgt implements Instruction{
    private int loc;
    private int offset;

    public Bgt(int loc, int offset) {
        this.loc = loc;
        this.offset = offset;
    }

    public void execute(MiniMac mac){
        Integer[] memory = mac.getMemory();
        if(memory[loc] > 0){
            mac.setPointer(mac.getPointer() + offset);
        }
    }
    public String getCommandView(){
        return "bgt " + loc + " " + offset;
    }
}