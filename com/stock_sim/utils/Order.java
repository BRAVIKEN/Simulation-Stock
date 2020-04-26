package com.stock_sim.utils;

/**
 * Order
 */
public class Order {
    private int _id;
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
    public Order(int id, int quantity, Double price, String date) {
        this._id = id;
        this.quantity = quantity;
        this.price = price;
        this.date = date;
    }

    /**
     * @return the _id
     */
    public int getId() {
        return _id;
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
}