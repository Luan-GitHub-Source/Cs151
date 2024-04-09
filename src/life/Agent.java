package life;

import CALab.Cell;

import java.awt.*;
import java.util.Random;

public class Agent extends Cell {
    private int status = 0;
    private int ambience = 0;
    public Agent(Society society){
        myGrid = society;
    }

    public void observe() {
        // update ambience
        ambience = 0;
        for (Cell neighbor : neighbors) {
            ambience += ((Agent)neighbor).status;
        }

        notifySubscribers();
    }

    public void interact() {
        // empty according to assignment
    }

    public void update() {
        //  A living cell dies if it has too few or too many living neighbors (ambience = 0, 1, 4, 5, 6, 7, 8),
        //  and a dead cell comes back to life it has 3 living neighbors
        if (Society.rebirth.contains(ambience)) {
            status = 1; // bring back to life when it has 3 living neighbors
        }
        if (Society.death.contains(ambience)) {
            status = 0; // cell dies when ambience is not 2 or 3
        }

        notifySubscribers();
    }

    public void nextState() { // swap the status
        if (status == 0) {
            status = 1;
        } else {
            status = 0;
        }

        notifySubscribers();
//        System.out.printf("%s %s %s\n", status, ambience, getColor());
    }

    public void reset(boolean random) {
        if (random) {
            Random r = new Random();
            int alive = r.nextInt(100);
            if (alive < Society.percentAlive) {
                status = 1;
            } else {
                status = 0;
            }
        } else {
            status = 0;
            ambience = 0;
        }

        notifySubscribers();
    }

    public Color getColor() {
        return (status != 0) ? Color.green : Color.red;
    }

    public int getStatus() {
        return ambience;
    }
}