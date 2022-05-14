package me.whiteship.refactoring._06_mutable_data._02_separate_query_from_modifier;

public class BillingRefactor {

    private Customer customer;

    private EmailGateway emailGateway;

    public BillingRefactor(Customer customer, EmailGateway emailGateway) {
        this.customer = customer;
        this.emailGateway = emailGateway;
    }

    public double totalOutStanding() {  // 조회
        return  customer.getInvoices().stream()
                .map(Invoice::getAmount)
                .reduce((double) 0, Double::sum);
    }

    public void sendBill() {    // 변경 분리
        emailGateway.send(formatBill(customer));
    }

    private String formatBill(Customer customer) {
        return "sending bill for " + customer.getName();
    }
}
