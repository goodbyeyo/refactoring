package me.whiteship.refactoring._06_mutable_data._04_replace_derived_variable_with_query;

import java.util.ArrayList;
import java.util.List;

public class ProductionPlanRefactor {

    private double production;
    private List<Double> adjustments = new ArrayList<>();

    public void applyAdjustment(double adjustment) {
        this.adjustments.add(adjustment);
//        this.production += adjustment;
    }

    public double getProduction() {
//        assert this.production == calculatedProdution();
//        return this.production;
        return this.adjustments.stream().mapToDouble(Double::valueOf).sum();
    }

//    private double calculatedProdution() {
        // return this.adjustments.stream().reduce((double) 0, Double::sum);
//        return this.adjustments.stream().mapToDouble(Double::valueOf).sum();
//    }
}
