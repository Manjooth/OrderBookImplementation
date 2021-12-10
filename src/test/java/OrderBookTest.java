import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderBookTest {

    private static List<Order> buys;
    private static List<Order> sells;
    private static OrderBook orderBook;

    @BeforeAll
    static void setUp() {
        buys = new ArrayList<>();
        sells = new ArrayList<>();

        Order buyOrder = new Order(new OrderCore(12345, "jane doe"), 1.00, 10, true);
        Order sellOrder = new Order(new OrderCore(123877, "jane doe"), 0.80, 2, false);

        buys.add(buyOrder);
        sells.add(sellOrder);

        orderBook = new OrderBook(buys, sells);
    }

    @Test
    void checkListsArePopulated(){
        assertEquals(1, orderBook.getBuySide().size());
        assertEquals(1, orderBook.getSellSide().size());
    }

    @Test
    void testThatWeCanAddNewBuyOrder(){
        Order newOrder = new Order(
                new OrderCore(000012, "joe bloggs"), 50.00, 80, true);
        orderBook.addOrder(newOrder);

        assertEquals(2, orderBook.getBuySide().size());
    }

    @Test
    void testThatWeCanAddNewSellOrder(){
        Order newOrder = new Order(
                new OrderCore(0000112, "abc def"), 5.00, 3, false);
        orderBook.addOrder(newOrder);

        assertEquals(2, orderBook.getSellSide().size());
    }

    @Test
    void testThatWeCanRemoveABuyOrder(){
        orderBook.removeOrder(000012, true);

        assertEquals(1, orderBook.getBuySide().size());
    }

    @Test
    void testThatWeCanRemoveASellOrder(){
        orderBook.removeOrder(123877, false);

        assertEquals(1, orderBook.getBuySide().size());
    }
}