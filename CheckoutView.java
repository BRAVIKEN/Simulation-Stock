import java.util.ArrayList;
import java.util.Scanner;

/**
 * CheckoutView
 */
public class CheckoutView extends MVC {
    // private CheckoutController controller;

    public CheckoutView() {
        super();
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
            if (word1 != null) {
                if (interpretCommand(word1, word2))
                    break;
            }
            tokenizer.close();

        }

    }

    public Boolean interpretCommand(String cmd, String param) {
        cmd = cmd.toLowerCase();
        if (param != null)
            param = param.toLowerCase();
        switch (cmd) {
            case "add":
                // print par défault
                try {
                    this.checkModel.addItemFromBarcode(Integer.parseInt(param));
                } catch (NumberFormatException e) {
                    System.out.println("Invalid bar code");
                }
                break;

            case "endbasket":
                this.checkModel.endCurentBasket();
                break;

            case "printticket":
                this.checkController.printActualBasketTicket();
                this.checkModel.endCurentBasket();

                break;

            case "printallticket":
                this.checkController.printAllTickets();
                break;

            case "return":
                try {
                    this.checkController.returnItem(Integer.parseInt(param));
                } catch (NumberFormatException e) {
                    System.out.println("Invalid bar code");
                }
                break;

            case "open":
                this.checkController.openCashDrawer();
                break;

            case "help":
                System.out.println("Available command: ");
                System.out.println("\tadd  <n> \t Add an item to basket");
                System.out.println("\tprintTicket \t Display basket's ticket");
                System.out.println("\tprintAllTicket \t Display all baskets");
                System.out.println("\treturn <n> \t Return an item");
                System.out.println("\topen\t\t Open Cash Drawer");
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

}