package com.stock_sim.system;

import com.stock_sim.utils.*;


/**
 * SystemController
 */
public class SystemController {
    private SystemMVC mvc;

    public SystemController(SystemMVC sysmvc) {
        mvc = sysmvc;
    }

    public void init() {
        displayStock();
    }

    public void displayStock() {
        mvc.view.displayStock(mvc.model.getAllItems());
    }

    public void displayItem(int i) {
        Item item = mvc.model.getItem(i);
        // mvc.view.displayItem(item);
    }
}