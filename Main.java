import java.lang.ModuleLayer.Controller;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        SystemView view = new SystemView();
        SystemModel model = new SystemModel();
        SystemController controller = new SystemController();

        controller.setModel(model);
        controller.setView(view);
        view.setController(controller);
        model.setController(controller);
    }
    
}