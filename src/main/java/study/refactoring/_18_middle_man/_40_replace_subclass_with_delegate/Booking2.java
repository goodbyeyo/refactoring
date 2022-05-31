package study.refactoring._18_middle_man._40_replace_subclass_with_delegate;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class Booking2 {

    protected Show show;

    protected LocalDateTime time;

    protected PremiumDelegate2 premiumDelegate;

    public Booking2(Show show, LocalDateTime time) {
        this.show = show;
        this.time = time;
    }

    // static factory method pattern
    // 1. 생성자와 달리 메서드 이름을 유연하게 변경 할 수 있다.
    public static Booking2 createBooking(Show show, LocalDateTime time) {
        return new Booking2(show, time);
    }

    public static Booking2 createPremiumBooking(Show show, LocalDateTime time, PremiumExtra extra) {
        PremiumBooking2 booking = new PremiumBooking2(show, time, extra);
        booking.premiumDelegate = new PremiumDelegate2(booking, extra); // ★★★★★
        return booking;
    }

    public boolean hasTalkback() {
        return (this.premiumDelegate != null) ? this.premiumDelegate.hasTalkback() :
                this.show.hasOwnProperty("talkback") && !this.isPeakDay();
    }

    protected boolean isPeakDay() {
        DayOfWeek dayOfWeek = this.time.getDayOfWeek();
        return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
    }

    public double basePrice() {
        double result = this.show.getPrice();
        if (this.isPeakDay()) result += Math.round(result * 0.15);
        return result;
    }

}
