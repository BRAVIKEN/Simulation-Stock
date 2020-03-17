/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        SystemModel sysModel = new SystemModel();
        SystemView sysView = new SystemView();
        SystemController sysController = new SystemController();

        sysModel.init(sysView, sysController);
        sysView.init(sysModel, sysController);
        sysController.init(sysModel, sysView);

        Supplier supplier1 = new Supplier("Pierre Lefebvre", "0102030405", "2 de la Rue Liberté", "93200");
        Item item1 = new Item("Pomme", 0, 0.50, 100, 20, true, supplier1, null);

        sysModel.getStock().addItem(item1);

        Checkout myCheckout = new Checkout(sysModel, sysView, sysModel.getStock());

        if (args.length == 0) {
            System.out.println("'exec' [0 for System or 1 for Checkout]");
            return;
        } else if (args[0].equals("0")) {
            System.out.println("System view:\n");
            sysView.proccessCommand();
        } else if (args[0].equals("1")) {
            System.out.println("Cashier view:\n");
            myCheckout.start();
        } else {
            System.out.println("'exec' [0 for System or 1 for Checkout]");
        }
    }

}