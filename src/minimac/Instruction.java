package minimac;

import java.io.Serializable;

public interface Instruction extends Serializable {
    abstract void execute(MiniMac mac);
    abstract String getCommandView();
}
