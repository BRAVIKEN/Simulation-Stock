import java.util.ArrayList;
import java.util.Scanner;

/**
 * SystemView
 */
public class SystemView {
    private SystemController controller;
    private SystemModel model;

    public SystemView() {
    }

    public void init(SystemModel m, SystemController c) {
        model = m;
        controller = c;
    }

    public void proccessCommand() {
        Scanner reader = new Scanner(System.in);
        String inputLine;

        while (true) {

            inputLine = reader.nextLine();

            String word1 = null;
            String word2 = null;

            Scanner tokenizer = new Scanner(inputLine);
            if (tokenizer.hasNext()) {
                word1 = tokenizer.next();
                if (tokenizer.hasNext()) {
                    word2 = tokenizer.next();
                }
            }

            tokenizer.close();
            if (word1 != null) {

                if (interpretCommand(word1, word2))
                    break;

            }

        }

    }

    public Boolean interpretCommand(String cmd, String param) {
        cmd = cmd.toLowerCase();
        if (param != null)
            param = param.toLowerCase();

        switch (cmd) {
            case "display":
                if (param.equals("stock")) {
                    this.controller.displayStock();
                } else {
                    try {
                        Integer i = Integer.parseInt(param, 10);
                        this.controller.displayItem(i);
                    } catch (NumberFormatException e) {
                        System.out.println("Unknown item");
                    }
                }
                break;

            case "order":
                System.out.println("Amount: ");
                Scanner reader = new Scanner(System.in);
                String inputLine = reader.nextLine();
                Scanner tokenizer = new Scanner(inputLine);
                try {
                    Integer i = Integer.parseInt(param, 10);

                    if (tokenizer.hasNext()) {
                        Integer a = Integer.parseInt(tokenizer.next(), 10);
                        this.model.createOrder(i, a);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid item or amout");
                }

                break;

            case "help":
                System.out.println("Available command: ");
                System.out.println("\tdisplay stock \t Display all items");
                System.out.println("\tdisplay <n> \t Display items");
                System.out.println("\torder <n> \t Create an order for an item");
                System.out.println("\texit \t\t Leave program");
                break;

            case "exit":
                return true;

            default:
                System.out.println("Unknown command");
                break;
        }

        return false;

    }

    /**
     * @param controller the controller to set
     */
    public void setController(SystemController controller) {
        this.controller = controller;
    }

    public void displayStock(ArrayList<Item> stock) {
        int i = 0;

        for (Item item : stock) {
            System.out.print(Integer.toString(i) + " ");
            System.out.println(item.getName());
            i++;
        }
    }

    public void displayItem(Item item) {
        if (item == null) {
            System.out.println("Invalid item");
            return;
        }

        System.out.println("Name: " + item.getName());
        System.out.println("Price: " + item.getPrice());
        System.out.println("Quantity: " + item.getQuantity());
        System.out.println("Threshold: " + item.getThreshold());
        System.out.println("Weight: " + item.getWeight());
        System.out.println("Supplier: " + item.getSupplier().getName());
        if (item.getOrder() != null) {
            System.out.println("Order date: " + item.getOrder().getDate());
            System.out.println("Order quantity: " + item.getOrder().getQuantity());
            System.out.println("Order price: " + item.getOrder().getPrice());
        }
    }

}