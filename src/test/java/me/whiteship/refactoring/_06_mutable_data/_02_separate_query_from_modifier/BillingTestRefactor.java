package me.whiteship.refactoring._06_mutable_data._02_separate_query_from_modifier;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BillingTestRefactor {

    @Test
    void totalOutstanding() {
        BillingRefactor billing = new BillingRefactor(new Customer("keesun", List.of(new Invoice(20), new Invoice(30))),
                new EmailGateway());
        assertEquals(50d, billing.totalOutStanding());

        billing.sendBill();
    }

}