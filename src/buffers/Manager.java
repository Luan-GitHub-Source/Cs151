package buffers;

import java.util.*;

public class Manager  {

    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        List<Thread> agents = new LinkedList<Thread>();
        int numAgents = 10;
        for(int i = 0; i < numAgents; i++) {
            if (i % 2 == 0) {
                agents.add(new Writer("writer_" + i, buffer));
            } else {
                agents.add(new Reader("reader_" + i, buffer));
            }
        }
        for(Thread agent: agents) {
            agent.start();
        }
        for(Thread agent: agents) {
            try {
                agent.join();
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            } finally {
                System.out.println(agent.getName() + " has died");
            }
        }
        System.out.println("all done");
        System.out.println("buffer = " + buffer);
    }
}
