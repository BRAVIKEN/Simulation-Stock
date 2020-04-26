package com.stock_sim.system;

public class SystemMVC {
    public Sys sys;
    public SystemModel model;
    public SystemView view;
    public SystemController controller;

    public SystemMVC(Sys sys) {
        this.sys = sys;
        model = new SystemModel(this);
        view = new SystemView(this);
        controller = new SystemController(this);
    }

    public void init() {
        view.init();
        controller.init();
    }
}