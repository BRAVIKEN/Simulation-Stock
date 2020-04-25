package com.stock_sim.checkout;

import java.util.ArrayList;
import com.stock_sim.system.*;
import com.stock_sim.checkout.*;
import com.stock_sim.utils.*;

/**
 * CheckoutModel
 */
public class CheckoutModel {
    private CheckoutMVC mvc;
    private Double balance;
    private ArrayList<Basket> baskets;
    private Boolean onBasket;

    public CheckoutModel() {
        onBasket = false;

        balance = 0.0;

        baskets = new ArrayList<Basket>();
    }

    public void init(CheckoutMVC comvc) {
        mvc = comvc;
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

    public Item addItemFromBarcode(int code) {
        if (!onBasket) {
            onBasket = true;
            baskets.add(new Basket());
        }

        Item i = mvc.system.model.getStock().getCodeToStock().get(code);
        if (i == null) return null;

        this.baskets.get(this.baskets.size() - 1).addItem(i);
        i.setQuantity(i.getQuantity() - 1);
        return i;
    }

    public Basket printActualBasketTicket() {
        if (onBasket) {
            return this.baskets.get(this.baskets.size() - 1);
        }
        return null;
    }

    public void endCurentBasket() {
        onBasket = false;
    }
}