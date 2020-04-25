
public class Sys {
    private SystemMVC system;

    public Sys() {
        init();
    }

    public void init() {


        system = new SystemMVC();

        Supplier supplier1 = new Supplier("Pierre Lefebvre", "0102030405", "2 de la Rue Liberté", "93200");
        system.model.addSupplier(supplier1);
        
        Item item1 = new Item("Pomme", 0.50, 100, 20, true, supplier1, null);
        Item item2 = new Item("Desperados", 2.0, 15, 10, false, supplier1, null);
        Item item3 = new Item("Saucisson", 5.3, 5, 20, false, supplier1, null);

        system.model.addItem(item1, item2, item3);

        system.init();

        // createCheckout();
    }

    public CheckoutMVC createCheckout() {
        return new CheckoutMVC(system);
    }
}