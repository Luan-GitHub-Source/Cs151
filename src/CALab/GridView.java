package CALab;

import mvc.*;

import java.awt.*;

public class GridView extends View {

    public CellView[][] cellViews;

    public GridView(Grid model) {
        super(model);
        /*
        Cell cell = new CellView(((Grid)model).getCell(row, col)
        cellViews[row][col] = cell
        set cell.row and cell.col here
        */
        int dim = model.getDim();
        cellViews = new CellView[dim][dim]; // create a dim x dim array

        model.subscribe(this);

        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                CellView cellView = new CellView((model).getCell(row, col));
                cellViews[row][col] = cellView;
                this.add(cellView);
                cellView.update();
            }
        }
        this.setLayout(new GridLayout(dim, dim, 0, 0));
    }

    public void update() {
        // call update method of each CellView
        for (CellView[] row : cellViews) {
            for (CellView cv : row) {
                cv.update();
            }
        }
    }

    public void setModel(Model newModel){
        super.setModel(newModel);
        Grid grid = (Grid)model;

        for(int row = 0; row < grid.dim; row++){
            for(int col = 0; col < grid.dim; col++){
                cellViews[row][col].setCell(grid.getCell(row,col));
            }
        }
    }

}