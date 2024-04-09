package minimac;

public class Halt implements Instruction{

    public Halt() {
    }

    public void execute(MiniMac mac){
        mac.setPointer(mac.getProgram().size());
    }

    public String getCommandView(){
        return "halt";
    }
}
