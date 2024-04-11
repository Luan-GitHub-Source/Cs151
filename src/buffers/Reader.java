package buffers;


public class Reader extends Thread {

    private Buffer buffer;

    public Reader(String name, Buffer buffer) {
        super(name);
        this.buffer = buffer;
    }

    public void run() {
        for(int i = 0; i < 10; i++) {
            Message<String> msg = buffer.read();
            if (msg != null) {
                System.out.println(msg + " received by " + this.getName());
            } else {
                System.out.println("No messages received by " + this.getName());
            }
            Utils.sleep(20); // be cooperative
        }
    }

}
