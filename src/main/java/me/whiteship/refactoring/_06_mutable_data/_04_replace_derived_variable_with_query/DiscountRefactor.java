package me.whiteship.refactoring._06_mutable_data._04_replace_derived_variable_with_query;

public class DiscountRefactor {

//    private double discountedTotal;
    private double discount;

    private double baseTotal;

    public DiscountRefactor(double baseTotal) {
        this.baseTotal = baseTotal;
    }

    public double getDiscountedTotal() {
//        assert this.discountedTotal == this.baseTotal - this.discountedTotal;
//        assert this.getDiscountedTotal() = calculatedDiscountedTotal();
        return this.baseTotal - this.discount;
//        return this.discountedTotal;
    }

//    private double calculatedDiscountedTotal() {
//        return this.baseTotal - this.discount;
//    }

    public void setDiscount(double number) {
        this.discount = number;
//        this.discountedTotal = this.baseTotal - this.discount;
    }
}
