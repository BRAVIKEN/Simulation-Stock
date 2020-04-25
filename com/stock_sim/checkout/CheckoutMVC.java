package com.stock_sim.checkout;
import com.stock_sim.system.*;

public class CheckoutMVC {
    public CheckoutModel model;
    public CheckoutView view;
    public CheckoutController controller;
    public SystemMVC system;

    public CheckoutMVC(SystemMVC sys) {
        model = new CheckoutModel();
        view = new CheckoutView();
        controller = new CheckoutController();
        system = sys;

        model.init(this);
        view.init(this);
        controller.init(this);
    }
}