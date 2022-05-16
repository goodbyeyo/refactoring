package study.refactoring._06_mutable_data._04_replace_derived_variable_with_query;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductionPlanRefactorTest {

    @Test
    void production() {
        ProductionPlanRefactor productionPlan = new ProductionPlanRefactor();
        productionPlan.applyAdjustment(10);
        productionPlan.applyAdjustment(20);
        assertEquals(30, productionPlan.getProduction());
    }

}