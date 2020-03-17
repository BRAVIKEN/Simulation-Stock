import java.util.ArrayList;

/**
 * SystemController
 */
public class SystemController {
    private SystemModel model;
    private SystemView view;

    public SystemController() {

    }

    public void init(SystemModel m, SystemView v) {
        model = m;
        view = v;
    }

    /**
     * @param model the model to set
     */
    public void setModel(SystemModel model) {
        this.model = model;
    }

    /**
     * @param view the view to set
     */
    public void setView(SystemView view) {
        this.view = view;
    }

    public void displayStock() {
        ArrayList<Item> stock = this.model.getAllItems();
        this.view.displayStock(stock);
    }

    /**
     * 
     * @param i
     */
    public void displayItem(Integer i) {
        Item item = this.model.getItem(i);
        this.view.displayItem(item);
    }
}