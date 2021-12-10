public class OrderCore implements OrderCoreInterface {

    private long orderId;
    private String username;

    public OrderCore(long orderId, String username) {
        this.orderId = orderId;
        this.username = username;
    }


    @Override
    public long getOrderId() {
        return orderId;
    }

    private void setOrderId(long id) {
        this.orderId = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    private void setUsername(String usr) {
        this.username = usr;
    }
}
