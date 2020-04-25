<<<<<<< HEAD:com/stock_sim/utils/Basket.java
package com.stock_sim.utils;

import java.util.ArrayList;

/**
 * Basket
 */
public class Basket {
    private ArrayList<Item> basket;
    private Double balance;
    private Boolean payed;

    public Basket() {
        this.basket = new ArrayList<Item>();
        this.balance = 0.0;
        this.payed = false;
    }

    /**
     * @return the basket
     */
    public ArrayList<Item> getBasket() {
        return basket;
    }

    /**
     * @param basket the basket to set
     */
    public void setBasket(ArrayList<Item> basket) {
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

    public void addItem(Item item) {
        this.basket.add(item);
        this.balance += item.getPrice();
    }

    public void removeItem(Item item) {
        this.basket.remove(item);
        this.balance -= item.getPrice();
    }

=======
import java.util.ArrayList;

/**
 * Basket
 */
public class Basket {
    private ArrayList<Item> basket;
    private Double balance;
    private Boolean payed;

    public Basket() {
        this.basket = new ArrayList<Item>();
        this.balance = 0.0;
        this.payed = false;
    }

    /**
     * @return the basket
     */
    public ArrayList<Item> getBasket() {
        return basket;
    }

    /**
     * @param basket the basket to set
     */
    public void setBasket(ArrayList<Item> basket) {
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

    public void addItem(Item item) {
        this.basket.add(item);
        this.balance += item.getPrice();
    }

    public void removeItem(Item item) {
        this.basket.remove(item);
        this.balance -= item.getPrice();
    }

>>>>>>> 9a5b25c4422d4de755cdd880d09b068e14c8a2fc:Basket.java
}