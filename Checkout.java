/**
 * Checkout
 */
public class Checkout {

    private CheckoutView checkView;
    private CheckoutModel checkModel;
    private CheckoutController checkController;

    public Checkout(SystemModel setSysModel, SystemView setSysView, Stock theS) {

        this.checkView = new CheckoutView();
        this.checkModel = new CheckoutModel();
        this.checkController = new CheckoutController();

        checkModel.init(setSysModel, setSysView);

        checkModel.setMVC(checkModel, checkView, checkController);
        checkView.setMVC(checkModel, checkView, checkController);
        checkController.setMVC(checkModel, checkView, checkController);

        checkModel.setStock(theS);

    }

    public void start() {

        checkView.proccessCommand();

    }

}