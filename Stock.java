import java.util.List;

/**
 * Stock
 */
public class Stock {
    private List<Item> items;

    public Stock() {
        
    }

    /**
     * @return the items
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(List<Item> items) {
        this.items = items;
    }

}