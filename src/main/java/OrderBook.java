import java.util.ArrayList;
import java.util.List;

public class OrderBook {

    private List<Order> buySide;
    private List<Order> sellSide;

    public OrderBook(List<Order> buySide, List<Order> sellSide) {
        this.buySide = buySide;
        this.sellSide = sellSide;
    }

    public List<Order> getBuySide() {
        return buySide;
    }

    public List<Order> getSellSide() {
        return sellSide;
    }

    public void addOrder(Order newOrder){
        if (newOrder.isBuySide()) {
            buySide.add(newOrder);
        } else {
            sellSide.add(newOrder);
        }
    }

    public void removeOrder(long orderId, boolean isBuySide){
        if (isBuySide) {
            for (int i = 0; i < buySide.size(); i++) {
                if(buySide.get(i).getOrderCore().getOrderId() == orderId){
                    buySide.remove(i);
                }
            }
        } else {
            for (int i = 0; i < sellSide.size(); i++) {
                if(sellSide.get(i).getOrderCore().getOrderId() == orderId){
                    sellSide.remove(i);
                }
            }
        }
    }

    public void checkIfTradesAvailable(){
        ArrayList<Order> successfulTrades = new ArrayList();
        for (int i = 0; i < buySide.size(); i++) {
            for (int j = 0; j < sellSide.size(); j++) {
                if(buySide.get(i).getPrice() == sellSide.get(j).getPrice() &&
                        buySide.get(i).getCurrentQuantity() < sellSide.get(j).getCurrentQuantity()) {

                }
            }
        }
    }

    public void clearEmptyTrades() {}
}
