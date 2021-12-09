import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderCoreTest {

    private static OrderCore orderCore;

    @BeforeAll
    static void setUp() {
        orderCore = new OrderCore(123456, "jane doe");
    }

    @Test
    void checkObjectCanBeCreatedAndOrderIdReceived(){
        assertEquals(123456, orderCore.getOrderId());
    }

    @Test
    void checkObjectCanBeCreatedAndUsernameReceived(){
        assertEquals("jane doe", orderCore.getUsername());
    }

}