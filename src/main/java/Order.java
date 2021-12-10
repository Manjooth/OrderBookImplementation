import java.math.BigDecimal;

public class Order {

    private OrderCore orderCore;
    private double price;
    private int initialQuantity;
    private int currentQuantity;
    // true means buy side, false means sell side
    private boolean isBuySide;

    public Order(OrderCore orderCore, double price, int quantity, boolean isBuySide) {
        this.orderCore = orderCore;
        this.price = price;
        this.initialQuantity = quantity;
        this.currentQuantity = quantity;
        this.isBuySide = isBuySide;
    }

    public OrderCore getOrderCore() {
        return orderCore;
    }

    private void setOrderCore(OrderCore orderCore) {
        this.orderCore = orderCore;
    }

    public double getPrice() {
        return price;
    }

    private void setPrice(double price) {
        this.price = price;
    }

    public int getInitialQuantity() {
        return initialQuantity;
    }

    private void setInitialQuantity(int initialQuantity) {
        this.initialQuantity = initialQuantity;
    }

    public int getCurrentQuantity() {
        return currentQuantity;
    }

    private void setCurrentQuantity(int currentQuantity) {
        this.currentQuantity = currentQuantity;
    }

    public boolean isBuySide() {
        return isBuySide;
    }

    private void setBuySide(boolean buySide) {
        isBuySide = buySide;
    }

    public void increaseCurrentQuantity(int quantity) {
        this.currentQuantity += quantity;
    }

    public void decreaseCurrentQuantity(int quantity) throws Exception {
        if(currentQuantity < quantity){
            throw new Exception("Trying to remove more orders than are available, from order " + this.orderCore.getOrderId());
        }
        this.currentQuantity -= quantity;
    }
}
