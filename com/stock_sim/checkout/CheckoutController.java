package com.stock_sim.checkout;

import java.util.ArrayList;
import com.stock_sim.system.*;
import com.stock_sim.checkout.*;
import com.stock_sim.utils.*;


/**
 * CheckoutController
 */
public class CheckoutController {
    private CheckoutMVC mvc;
    
    public CheckoutController() {
    }

    public void init(CheckoutMVC comvc) {
        mvc = comvc;
    }

    public Item scanBarCode(int barCode) {
        // mvc.system.view.displayItem(mvc.system.model.getStock().getCodeToStock().get(barCode));
        return mvc.model.addItemFromBarcode(barCode);
    }

    public void basketSold(Basket theBasket) {
        mvc.system.model.getStock().decrementBasket(theBasket.getBasket());
    }

    public int returnItem(int codebar) {
        Item i = mvc.system.model.getStock().getCodeToStock().get(codebar);
        if (i == null) return 0;
        i.setQuantity(i.getQuantity() + 1);
        return 1;
    }

    public Basket printActualBasketTicket() {
        return this.mvc.model.printActualBasketTicket();
    }

    public ArrayList<Basket> printAllTickets() {
        return mvc.model.getItems();
    }

    public void openCashDrawer() {
        // System.out.println("The cash drawer is opening");
    }

}