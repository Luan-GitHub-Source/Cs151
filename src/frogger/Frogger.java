package frogger;

import jdk.jshell.execution.Util;
import mvc.Model;
import mvc.Utilities;

import java.awt.*;
import java.util.Random;

public class Frogger extends Model {
    Random rng = Utilities.rng;
    private int x = rng.nextInt(200);
    private int y = rng.nextInt(200);

    public int getx() {
        return x;
    }

    public int gety() {
        return y;
    }


    public void leap() {
        x = rng.nextInt(200);
        y = rng.nextInt(200);
        System.out.println(x + " " + y);
        changed();
    }
}
