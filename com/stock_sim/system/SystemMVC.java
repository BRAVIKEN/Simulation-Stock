package com.stock_sim.system;

public class SystemMVC {
    public SystemModel model;
    public SystemView view;
    public SystemController controller;

    public SystemMVC() {
        model = new SystemModel();
        view = new SystemView();
        controller = new SystemController();
    }

    public void init() {
        model.init(this);
        view.init(this);
        controller.init(this);
    }
}