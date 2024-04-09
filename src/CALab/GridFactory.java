package CALab;

import mvc.*;

public class GridFactory implements AppFactory {
    public Model makeModel() { return null; }

    public View makeView(Model model) {
        return new GridView((Grid) model);
    }

    public String getTitle() { return "CALab"; }

    public String[] getHelp() {
        return new String[]{"""
RUN1: calls grid.updateLoop(1)
RUN50: calls grid.updateLoop(50)
POPULATE: calls grid.repopulate() which sets the state of each cell to a random value
CLEAR: calls grid.clear() which sets the state of each cell to an initial value."""};
    }

    public String about() {
        return null;
    }

    public String[] getEditCommands() {
        return new String[] {"Run1", "Run50", "Populate", "Clear"};
    }

    public Command makeEditCommand(Model model, String type, Object source) {
        return switch (type) {
            case "Run1" -> new RunCommand(model, 1);
            case "Run50" -> new RunCommand(model, 50);
            case "Populate" -> new PopulateCommand(model);
            case "Clear" -> new ClearCommand(model);
            default -> null;
        };
    }
}
