package study.refactoring._07_divergent_change._25_move_function;

public class AccountTypeRefactor {
    private boolean premium;

    public AccountTypeRefactor(boolean premium) {
        this.premium = premium;
    }

    public boolean isPremium() {
        return this.premium;
    }

    double overdraftCharge(int  daysOverdrawn) {
        if (this.isPremium()) {
            final int baseCharge = 10;
            if (daysOverdrawn <= 7) {
                return baseCharge;
            } else {
                return baseCharge + (daysOverdrawn - 7) * 0.85;
            }
        } else {
            return daysOverdrawn * 1.75;
        }
    }
}
