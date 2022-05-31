package study.refactoring._18_middle_man._40_replace_subclass_with_delegate;

import java.time.LocalDateTime;

public class PremiumBooking2 extends Booking2 {

    private PremiumExtra extra;

    public PremiumBooking2(Show show, LocalDateTime time, PremiumExtra extra) {
        super(show, time);
        this.extra = extra;
    }

    @Override
    public boolean hasTalkback() {
        return this.premiumDelegate.hasTalkback();
    }

    @Override
    public double basePrice() {
        return Math.round(super.basePrice() + this.extra.getPremiumFee());
    }

    public boolean hasDinner() {
        return this.extra.hasOwnProperty("dinner") && !this.isPeakDay();
    }
}
