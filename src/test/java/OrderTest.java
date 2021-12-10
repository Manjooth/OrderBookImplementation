import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    private static Order order;

    @BeforeAll
    static void setUp() {
        OrderCore orderCore = new OrderCore(123456, "jane doe");
        order = new Order(orderCore, 12.58, 10, true);
    }

    @Test
    void checkOrderCanBeCreatedAndOrderIdReceived(){
        assertEquals(123456, order.getOrderCore().getOrderId());
    }

    @Test
    void checkOrderCanBeCreatedAndUsernameReceived(){
        assertEquals("jane doe", order.getOrderCore().getUsername());
    }

    @Test
    void checkOrderCanBeCreatedAndPriceReceived(){
        assertEquals(12.58, order.getPrice());
    }

    @Test
    void checkOrderCanBeCreatedAndQuantityReceived(){
        assertEquals(10, order.getInitialQuantity());
    }

    @Test
    void checkOrderCanBeCreatedAndIsBuySideReceived(){
        assertTrue(order.isBuySide());
    }

    @Test
    void checkOrderCanBeCreatedAndIsSellSideReceived(){
        assertTrue(order.isBuySide());
    }

    @Test
    void checkOrderQuantityCanBeIncreased(){
        order.increaseCurrentQuantity(2);
        assertEquals(12, order.getCurrentQuantity());
    }

    @Test
    void checkOrderQuantityCanBeDecreased() throws Exception {
        order.decreaseCurrentQuantity(6);
        assertEquals(6, order.getCurrentQuantity());
    }

    @Test
    void throwExceptionWhenQuantitySellAmountIsGreaterThenOrderQuantity() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            order.decreaseCurrentQuantity(20);
        });

        String expectedMessage = "Trying to remove more orders than are available, from order 123456";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}