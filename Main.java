import java.lang.ModuleLayer.Controller;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        SystemView sysView = new SystemView();
        SystemModel sysModel = new SystemModel();
        SystemController sysController = new SystemController();

        sysController.setModel(sysModel);
        sysController.setView(sysView);
        sysView.setController(sysController);
        sysModel.setController(sysController);
    }
    
}