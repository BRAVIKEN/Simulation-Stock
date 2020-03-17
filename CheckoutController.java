/**
 * CheckoutController
 */
public class CheckoutController extends MVC {
    public CheckoutController() {
        super();
    }

    public void scanBarCode(int barCode) {
        checkModel.getSysView().displayItem(checkModel.getSysModel().getStock().getCodeToStock().get(barCode));
        checkModel.addItemFromBarcode(barCode);
    }

    public void basketSold(Basket theBasket) {

        checkModel.getSysModel().getStock().decrementBasket(theBasket.getBasket());

    }

    public void returnItem(int codebar) {
        Item i = checkModel.getSysModel().getStock().getCodeToStock().get(codebar);
        i.setQuantity(i.getQuantity() + 1);
    }

    public void printActualBasketTicket() {

        this.checkModel.printActualBasketTicket();

    }

    public void printAllTickets() {
        checkModel.getItems().forEach(e -> {
            System.out.println("Basket:");
            e.printTicket();
            System.out.println("");
        });
    }

    public void openCashDrawer() {
        System.out.println("The cash drawer is opening");
    }

}