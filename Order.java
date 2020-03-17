/**
 * Order
 */
public class Order {
    private Item item;
    private Supplier supplier;
    private Integer quantity;
    private Double price;
    private String date;

    /**
     * 
     * @param item
     * @param supplier
     * @param quantity
     * @param price
     * @param date
     */
    public Order(Item item, Supplier supplier, Integer quantity, Double price, String date) {
        this.item = item;
        this.supplier = supplier;
        this.quantity = quantity;
        this.price = price;
        this.date = date;
    }

    /**
     * @return the item
     */
    public Item getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(Item item) {
        this.item = item;
    }

    /**
     * @return the supplier
     */
    public Supplier getSupplier() {
        return supplier;
    }

    /**
     * @param supplier the supplier to set
     */
    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    /**
     * @return the quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    public void print() {
        System.out.println("BZBZBZBZBZBBZBZBZB, j'imprime la money $$$ !");
    }

}