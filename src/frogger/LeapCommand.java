package frogger;

import mvc.Command;
import mvc.Model;
import stopLight.Stoplight;

public class LeapCommand extends Command {
    public LeapCommand(Model model) {
        super(model);
    }

    public void execute() {
        Frogger light = (Frogger)model;
        light.leap();
    }
}
