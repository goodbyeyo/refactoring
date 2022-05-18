package study.refactoring._09_feature_envy;

public class Bill2 {

    private ElectricityUsage2 electricityUsage;

    private GasUsage2 gasUsage;

    public double calculateBill() {
        return electricityUsage.getElecticityBill() + gasUsage.getGasBill();
    }



}
