package buffers;

import java.util.Random;

public class Utils {

    public static Random rng = new Random(System.currentTimeMillis());

    public static String nextString(int size) {
        String result = "";
        for(int i = 0; i < size; i++) {
            result += (char)('a' + rng.nextInt(26));
        }
        return result;
    }

    public static void sleep(int msecs) {
        try {
            Thread.sleep(msecs);
        } catch(InterruptedException e) {
            System.out.println(e);
        }
    }

}