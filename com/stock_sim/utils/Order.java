<<<<<<< HEAD:com/stock_sim/utils/Order.java
package com.stock_sim.utils;

/**
 * Order
 */
public class Order {
    private Item item;
    private Supplier supplier;
    private int quantity;
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
    public Order(Item item, Supplier supplier, int quantity, Double price, String date) {
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
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
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
        // System.out.println("BZBZBZBZBZBBZBZBZB, j'imprime la money $$$ !");
    }

=======
/**
 * Order
 */
public class Order {
    private Item item;
    private Supplier supplier;
    private int quantity;
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
    public Order(Item item, Supplier supplier, int quantity, Double price, String date) {
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
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
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
        // System.out.println("BZBZBZBZBZBBZBZBZB, j'imprime la money $$$ !");
    }

>>>>>>> 9a5b25c4422d4de755cdd880d09b068e14c8a2fc:Order.java
}