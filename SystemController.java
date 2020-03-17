/**
 * SystemController
 */
public class SystemController {
    private SystemModel model;
    private SystemView view;

    public SystemController() {
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
}