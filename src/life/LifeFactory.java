package life;

import CALab.Grid;
import CALab.GridFactory;
import CALab.GridView;
import mvc.*;

public class LifeFactory extends GridFactory {
    public Model makeModel() { return new Society(); }

    public View makeView(Model model) {
        return new GridView((Grid) model);
    }

    public String getTitle() { return "Life Lab"; }

    public String[] getHelp() {
        return super.getHelp();
    }

    public String about() {
        return "Conway's game of life";
    }
}
