package buffers;

import java.util.*;

public class Buffer {

    private List<Message<String>> buffer = new LinkedList<Message<String>>();
    public int CAPACITY = 3;

    public synchronized boolean write(Message<String> msg) {
        //Utils.sleep(100);
        while (buffer.size() == CAPACITY) {
            try {
                wait(); // wait for funds
            } catch (InterruptedException ie) {
                System.err.println(ie.getMessage());
            }
        }
//        boolean success = false;
//        if (buffer.size() < CAPACITY) {
//            buffer.add(msg);
//            success = true;
//        }
        buffer.add(msg);
        //Utils.sleep(50);

        notify();
        return true;
    }

    public synchronized Message<String> read() {
        //Utils.sleep(50);
        while (buffer.isEmpty()) {
            try {
                wait(); // wait for funds
            } catch (InterruptedException ie) {
                System.err.println(ie.getMessage());
            }
        }
        Message<String> res = buffer.remove(0);//(buffer.isEmpty())? null: buffer.remove(0);
        //Utils.sleep(100);
        notify();
        return res;
    }

    public String toString() { return buffer.toString(); }

}