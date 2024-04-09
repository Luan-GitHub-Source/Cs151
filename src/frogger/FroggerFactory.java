package frogger;

import mvc.AppFactory;
import mvc.Command;
import mvc.Model;
import mvc.View;
import stopLight.ChangeCommand;
import stopLight.Stoplight;
import stopLight.StoplightView;

public class FroggerFactory implements AppFactory {
    public Model makeModel() { return new Frogger(); }

    public View makeView(Model m) {
        return new FroggerView((Frogger)m);
    }

    public String[] getEditCommands() { return new String[] {"Leap"}; }


    // source added 3/15 to support text fields
    public Command makeEditCommand(Model model, String type, Object source) {
        if (type == "Leap")
            return new LeapCommand(model);
        return null;
    }

    public String getTitle() { return "Frogger"; }

    public String[] getHelp() {
        return new String[] {"click leap to randomly position the drog(gren dot) in the pond"};
    }

    public String about() {
        return "Frogger Version 1.0.0";
    }
}
