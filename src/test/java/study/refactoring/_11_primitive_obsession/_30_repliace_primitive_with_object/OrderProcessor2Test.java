package study.refactoring._11_primitive_obsession._30_repliace_primitive_with_object;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderProcessor2Test {

    @Test
    void numberOfHighPriorityOrders() {
        OrderProcessor2 orderProcessor = new OrderProcessor2();
        long highPriorityOrders = orderProcessor.numberOfHighPriorityOrders(
                List.of(new Order("low"),
                        new Order("normal"),
                        new Order("high"),
                        new Order("rush")));
        assertEquals(2, highPriorityOrders);
    }

}