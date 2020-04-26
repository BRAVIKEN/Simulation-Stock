package com.stock_sim.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Item
 */
public class Item {
    private int _id;
    private String name;
    private Double price;
    private int quantity;
    private int threshold;
    private Boolean weight;
    private Supplier supplier;
    private Order order;

    public Item() {
        this.name = "";
        this.price = 0.0;
        this.quantity = 0;
        this.threshold = 0;
        this.weight = false;
        this.supplier = null;
        this.order = null;
    }

    /**
     * 
     * @param name
     * @param price
     * @param quantity
     * @param threshold
     * @param weight
     * @param supplier
     * @param order
     */
    public Item(Integer id, String name, Double price, int quantity, int threshold, Boolean weight,
            Supplier supplier, Order order) {
        this._id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.threshold = threshold;
        this.weight = weight;
        this.supplier = supplier;
        this.order = order;
    }

    /**
     * @return the _id
     */
    public int getId() {
        return _id;
    }

    /**
     * @param _id the _id to set
     */
    public void setId(int _id) {
        this._id = _id;
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
     * @return the threshold
     */
    public int getThreshold() {
        return threshold;
    }

    /**
     * @param threshold the threshold to set
     */
    public void setThreshold(int threshold) {
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

    public void createOrder(int amount) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();

        // order = new Order(amount, this.price * amount, formatter.format(date));
    }

}