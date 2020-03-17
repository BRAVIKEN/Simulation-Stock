import java.util.ArrayList;

/**
 * SystemModel
 */
public class SystemModel {
    private SystemController controller;
    private SystemView view;
    private ArrayList<Checkout> checkouts;
    // private ArrayList<Item> stock;
    private Stock stock;

    public SystemModel() {
        stock = new Stock();

        checkouts = new ArrayList<Checkout>();
    }

    public void init(SystemView v, SystemController c) {
        view = v;
        controller = c;
    }

    public Item getItem(Integer item) {
        Item i = null;
        try {
            i = this.stock.getAllItems().get(item);
        } catch (IndexOutOfBoundsException e) {
        }
        return i;
    }

    /**
     * @return the stock
     */
    public Stock getStock() {
        return this.stock;
    }

    /**
     * @return the all items
     */
    public ArrayList<Item> getAllItems() {
        return this.stock.getAllItems();
    }

    public void createOrder(Integer item, Integer amount) {
        Item i = null;
        try {
            i = this.stock.getAllItems().get(item);
            i.createOrder(amount);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid item");
        }
    }

}