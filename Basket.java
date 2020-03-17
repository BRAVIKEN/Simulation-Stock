import java.util.List;

/**
 * Basket
 */
public class Basket {
    private List<Item> basket;
    private Double balance;
    private Boolean payed;

    public Basket() {

    }

    /**
     * @return the basket
     */
    public List<Item> getBasket() {
        return basket;
    }

    /**
     * @param basket the basket to set
     */
    public void setBasket(List<Item> basket) {
        this.basket = basket;
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
     * @return the payed
     */
    public Boolean getPayed() {
        return payed;
    }

    /**
     * @param payed the payed to set
     */
    public void setPayed(Boolean payed) {
        this.payed = payed;
    }

}