package com.stock_sim.system;

import com.stock_sim.persistence.*;
import com.stock_sim.checkout.*;
import com.stock_sim.utils.*;

public class Sys {
    private SystemMVC system;
    private Persistence pers;

    public Sys() {
        init();
    }

    public void init() {
        system = new SystemMVC(this);
        pers = new Persistence();

        pers.connect();
        
        pers.selectOrders();

        system.model.addSupplier(pers.selectSuppliers());
        system.model.addItem(pers.selectItems());

        system.init();

        createCheckout();
    }

    public CheckoutMVC createCheckout() {
        return new CheckoutMVC(system);
    }

    public Persistence getPersistence() {
        return pers;
    }
}