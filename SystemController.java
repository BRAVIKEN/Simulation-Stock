
import java.util.ArrayList;

/**
 * SystemController
 */
public class SystemController {
    private SystemMVC mvc;

    public SystemController() {
    }

    public void init(SystemMVC sysmvc) {
        mvc = sysmvc;
        displayStock();
    }

    public void displayStock() {
        mvc.view.displayStock(mvc.model.getAllItems());
    }

    public void displayItem(int i) {
        Item item = mvc.model.getItem(i);
        // mvc.view.displayItem(item);
    }
}