/**
 * Item
 */
public class Item {
    private String name;
    private Integer barCode;
    private Double price;
    private Integer quantity;
    private Integer threshold;
    private Boolean weight;
    private Supplier supplier;
    private Order order;

    public Item() {

    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the barCode
     */
    public Integer getBarCode() {
        return barCode;
    }

    /**
     * @param barCode the barCode to set
     */
    public void setBarCode(Integer barCode) {
        this.barCode = barCode;
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
     * @return the threshold
     */
    public Integer getThreshold() {
        return threshold;
    }

    /**
     * @param threshold the threshold to set
     */
    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }

    /**
     * @return the weight
     */
    public Boolean getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(Boolean weight) {
        this.weight = weight;
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
     * @return the order
     */
    public Order getOrder() {
        return order;
    }

    /**
     * @param order the order to set
     */
    public void setOrder(Order order) {
        this.order = order;
    }

}