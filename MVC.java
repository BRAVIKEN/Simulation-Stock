
public class MVC {
    protected CheckoutModel checkModel;
    protected CheckoutView checkView;
    protected CheckoutController checkController;

    public MVC() {
        checkModel = null;
        checkView = null;
        checkController = null;

    }

    /**
     * 
     * @param model
     * @param view
     * @param controller
     */
    public void setMVC(CheckoutModel model, CheckoutView view, CheckoutController controller) {
        checkModel = model;
        checkView = view;
        checkController = controller;
    }

}
