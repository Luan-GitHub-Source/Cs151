package buffers;


public class Writer extends Thread {

    private Buffer buffer;
    // random prefix prepended to all this thread's messages:
    private String prefix;

    public Writer(String name, Buffer buffer) {
        super(name);
        this.buffer = buffer;
        this.prefix = Utils.nextString(5) + "-";
    }

    public void run() {
        for(int i = 0; i < 10; i++) {
            Message<String> msg = new Message<String>(prefix + i, this);
            boolean success = buffer.write(msg);
            if (!success) System.out.println(this.getName() + ": write failed");
            Utils.sleep(100); // be cooperative
        }
    }

}