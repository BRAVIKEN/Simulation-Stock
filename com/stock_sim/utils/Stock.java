package com.stock_sim.utils;

import java.util.HashMap;
import java.util.ArrayList;

/**
 * Stock
 */
public class Stock {
    // private ArrayList<Item> items;
    private HashMap<Integer, Item> codeToStock;

    public Stock() {
        codeToStock = new HashMap<Integer, Item>();
    }

    public void addItem(Item... items) {
        for (Item item : items) {
            codeToStock.put(item.getId(), item);
        }
    }

    public void editItem(Item item, int i, String value) {
        Item it = codeToStock.get(item.getId());

        switch (i) {
            case 0:
                it.setName(value);
                break;
            
            case 2:
                it.setPrice(Double.parseDouble(value));
                break;
            
            case 3:
                it.setQuantity(Integer.parseInt(value));
                break;
            
            case 4:
                it.setThreshold(Integer.parseInt(value));
                break;
            
            case 5:
                it.setWeight(Boolean.parseBoolean(value));
                break;
        
            default:
                throw new IllegalArgumentException();
            // break;
        }
    }

    /**
     * 
     * @param items
     */
    public void decrementBasket(ArrayList<Item> items) {
        items.forEach((item) -> {
            item.setQuantity(item.getQuantity() - 1);
        });

    }

    public HashMap<Integer, Item> getCodeToStock() {
        return codeToStock;
    }

    public ArrayList<Item> getAllItems() {
        ArrayList<Item> toRet = new ArrayList<Item>();

        for (Item item : codeToStock.values()) {
            toRet.add(item);
        }

        return toRet;
    }

    public void removeItem(Item item) {
        System.out.println(item.getId());
        Item i = codeToStock.remove(item.getId());
        System.out.println(codeToStock.get(i.getId()));
    }


}