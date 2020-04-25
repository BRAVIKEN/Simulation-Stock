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
            item.setBarCode(codeToStock.size());
            codeToStock.put(item.getBarCode(), item);
        }
    }

    public void editItem(Item item, int i, String value) {
        Item it = codeToStock.get(item.getBarCode());

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
        Item i = codeToStock.remove(item.getBarCode());
    }


}