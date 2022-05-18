package study.refactoring._09_feature_envy;

public class ElectricityUsage2 {

    private double amount;

    private double pricePerUnit;

    public ElectricityUsage2(double amount, double pricePerUnit) {
        this.amount = amount;
        this.pricePerUnit = pricePerUnit;
    }

    public double getAmount() {
        return amount;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public double getElecticityBill() {
        return this.getAmount() * this.getPricePerUnit();
    }
}
