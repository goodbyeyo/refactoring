package study.refactoring._08_shotgun_surgery._27_move_field;

import java.time.LocalDate;

public class CustomerContract2 {

    private LocalDate startDate;

    private double discountRate;

    public CustomerContract2(LocalDate startDate, double discountRate) {
        this.startDate = startDate;
        this.discountRate = discountRate;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }
}
