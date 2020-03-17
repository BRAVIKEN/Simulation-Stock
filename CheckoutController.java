/**
 * CheckoutController
 */
public class CheckoutController {
    private CheckoutModel model;
    private CheckoutView view;

    public CheckoutController() {
    }

    /**
     * @param model the model to set
     */
    public void setModel(CheckoutModel model) {
        this.model = model;
    }

    /**
     * @param view the view to set
     */
    public void setView(CheckoutView view) {
        this.view = view;
    }
}