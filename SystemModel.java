import java.util.ArrayList;

/**
 * SystemModel
 */
public class SystemModel {
    private SystemMVC mvc;
    private Stock stock;
    private ArrayList<Supplier> suppliers;

    public SystemModel() {
        stock = new Stock();
        suppliers = new ArrayList<Supplier>();
    }

    public void init(SystemMVC sysmvc) {
        mvc = sysmvc;
    }

    public void addItem(Item... items) {
        this.stock.addItem(items);
    }

    public void addSupplier(Supplier... sup) {
        for (Supplier s: sup) {
            suppliers.add(s);
        }
    }

    public Supplier getSupplier(int i) {
        return this.suppliers.get(i);
    }

    public ArrayList<Supplier> getAllSuppliers() {
        return this.suppliers;
    }

    public Item getItem(int item) {
        Item i = null;
        try {
            i = this.stock.getAllItems().get(item);
        } catch (IndexOutOfBoundsException e) {
        }
        return i;
    }

    public void removeItem(Item item) {
        this.stock.removeItem(item);
    }

    public void editItem(Item item, int i, String value) {
        this.stock.editItem(item, i, value);
    }

    public void editSupplier(Supplier supplier, int i, String value) {
        supplier.edit(i, value);
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

    public void createOrder(int item, int amount) {
        Item i = null;
        try {
            i = this.stock.getAllItems().get(item);
            i.createOrder(amount);
        } catch (IndexOutOfBoundsException e) {
            // System.out.println("Invalid item");
        }
    }

}