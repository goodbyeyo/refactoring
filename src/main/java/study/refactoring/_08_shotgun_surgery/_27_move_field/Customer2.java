package study.refactoring._08_shotgun_surgery._27_move_field;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Customer2 {

    private String name;

    private double discountRate;

    private CustomerContract2 contract;

    public Customer2(String name, double discountRate) {
        this.name = name;
        this.discountRate = discountRate;
        this.contract = new CustomerContract2(dateToday(), discountRate);
    }

    public double getDiscountRate() {
        return this.contract.getDiscountRate();
    }

    public void setDiscountRate(double discountRate) {
        this.contract.setDiscountRate(discountRate);
    }

    public void becomePreferred() {
        this.setDiscountRate(this.discountRate + 0.03);
        // 다른 작업들
    }

    public double applyDiscount(double amount) {
        BigDecimal value = BigDecimal.valueOf(amount);
        return value.subtract(value.multiply(BigDecimal.valueOf(this.getDiscountRate()))).doubleValue();
    }

    private LocalDate dateToday() {
        return LocalDate.now();
    }
}
