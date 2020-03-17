import java.util.List;

/**
 * Checkout
 */
public class Checkout {
    private Double balance;
    private List<Basket> items;

    public Checkout() {
        CheckoutView checkView = new CheckoutView();
        CheckoutModel checkModel = new CheckoutModel();
        CheckoutController checkController = new CheckoutController();

        checkController.setModel(checkModel);
        checkController.setView(checkView);
        checkView.setController(checkController);
        checkModel.setController(checkController);
    }

    /**
     * @return the balance
     */
    public Double getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(Double balance) {
        this.balance = balance;
    }

    /**
     * @return the items
     */
    public List<Basket> getItems() {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(List<Basket> items) {
        this.items = items;
    }

}