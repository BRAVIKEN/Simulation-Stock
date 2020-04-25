
public class SystemMVC {
    protected SystemModel model;
    protected SystemView view;
    protected SystemController controller;

    public SystemMVC() {
        model = new SystemModel();
        view = new SystemView();
        controller = new SystemController();
    }

    public void init() {
        model.init(this);
        view.init(this);
        controller.init(this);
    }
}