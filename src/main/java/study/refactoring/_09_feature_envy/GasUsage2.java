package study.refactoring._09_feature_envy;

public class GasUsage2 {

    private double amount;

    private double pricePerUnit;

    public GasUsage2(double amount, double pricePerUnit) {
        this.amount = amount;
        this.pricePerUnit = pricePerUnit;
    }

    public double getAmount() {
        return amount;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public double getGasBill() {
        return this.getAmount() * this.getPricePerUnit();
    }
}
