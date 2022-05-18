package study.refactoring._11_primitive_obsession._30_repliace_primitive_with_object;

import java.util.List;

public class OrderProcessor2 {

    public long numberOfHighPriorityOrders(List<Order> orders) {
        return orders.stream()
                .filter(o -> o.getPriority().higherThen(new Priority("normal")))
                .count();
    }
}
