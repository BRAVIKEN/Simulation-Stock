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

    /**
     * 
     * @param toAdd
     */
    public void addItem(Item toAdd) {
        codeToStock.put(toAdd.getBarCode(), toAdd);
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

}