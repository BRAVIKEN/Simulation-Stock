public class CheckoutMVC {
    protected CheckoutModel model;
    protected CheckoutView view;
    protected CheckoutController controller;
    protected SystemMVC system;

    public CheckoutMVC(SystemMVC sys) {
        model = new CheckoutModel();
        view = new CheckoutView();
        controller = new CheckoutController();
        system = sys;

        model.init(this);
        view.init(this);
        controller.init(this);
    }
}