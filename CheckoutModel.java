import java.util.ArrayList;

/**
 * CheckoutModel
 */
public class CheckoutModel extends MVC {
    // private CheckoutController controller;
    private SystemModel sysModel;
    private SystemView sysView;
    private Double balance;
    private ArrayList<Basket> baskets;

    private Stock stock;

    private Boolean onBasket;

    public CheckoutModel() {
        super();

        onBasket = false;

        balance = 0.0;

        baskets = new ArrayList<Basket>();

    }

    public void setStock(Stock theS) {
        stock = theS;
    }

    public void init(SystemModel setSysModel, SystemView setSysView) {

        sysModel = setSysModel;

        sysView = setSysView;

    }

    /**
     * @return the balance
     */
    public Double getBalance() {
        return this.balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(Double balance) {
        this.balance = balance;
    }

    /**
     * @return the baskets
     */
    public ArrayList<Basket> getItems() {
        return this.baskets;
    }

    /**
     * @param baskets the baskets to set
     */
    public void setItems(ArrayList<Basket> newBaskets) {
        this.baskets = newBaskets;
    }

    public void addItemFromBarcode(Integer code) {

        if (!onBasket) {
            onBasket = true;

            baskets.add(new Basket());

        }

        Item i = this.stock.getCodeToStock().get(code);
        this.baskets.get(this.baskets.size() - 1).addItem(i);
        i.setQuantity(i.getQuantity() - 1);

    }

    public void printActualBasketTicket() {

        if (onBasket) {

            this.baskets.get(this.baskets.size() - 1).printTicket();

        }

    }

    public void endCurentBasket() {
        onBasket = false;
    }

    public SystemModel getSysModel() {
        return sysModel;
    }

    public SystemView getSysView() {
        return sysView;
    }
}