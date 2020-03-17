import java.util.List;

/**
 * Checkout
 */
public class Checkout {
    private Double balance;
    private List<Basket> items;

    public Checkout() {

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