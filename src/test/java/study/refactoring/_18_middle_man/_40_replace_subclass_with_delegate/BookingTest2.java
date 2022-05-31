package study.refactoring._18_middle_man._40_replace_subclass_with_delegate;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookingTest2 {

    @Test
    void talkback() {
        Show noTalkbackShow = new Show(List.of(), 120);
        Show talkbackShow = new Show(List.of("talkback"), 120);
        LocalDateTime nonPeekday = LocalDateTime.of(2022, 1, 20, 19, 0);
        LocalDateTime peekday = LocalDateTime.of(2022, 1, 15, 19, 0);

        assertFalse(Booking2.createBooking(noTalkbackShow, nonPeekday).hasTalkback());
        assertTrue(Booking2.createBooking(talkbackShow, nonPeekday).hasTalkback());
        assertFalse(Booking2.createBooking(talkbackShow, peekday).hasTalkback());

        PremiumExtra premiumExtra = new PremiumExtra(List.of(), 50);
        assertTrue(Booking2.createPremiumBooking(talkbackShow, peekday, premiumExtra).hasTalkback());
        assertFalse(Booking2.createPremiumBooking(noTalkbackShow, peekday, premiumExtra).hasTalkback());
    }

    @Test
    void basePrice() {
        Show lionKing = new Show(List.of(), 120);
        LocalDateTime weekday = LocalDateTime.of(2022, 1, 20, 19, 0);

        Booking2 booking = Booking2.createBooking(lionKing, weekday);
        assertEquals(120, booking.basePrice());

        Booking2 premium = Booking2.createPremiumBooking(lionKing, weekday, new PremiumExtra(List.of(), 50));
        assertEquals(170, premium.basePrice());
    }

    @Test
    void basePrice_on_peakDay() {
        Show lionKing = new Show(List.of(), 120);
        LocalDateTime weekend = LocalDateTime.of(2022, 1, 15, 19, 0);

        Booking booking = new Booking(lionKing, weekend);
        assertEquals(138, booking.basePrice());

        Booking premium = new PremiumBooking(lionKing, weekend, new PremiumExtra(List.of(), 50));
        assertEquals(188, premium.basePrice());
    }


    @Test
    void hasDinner() {
        Show lionKing = new Show(List.of(), 120);
        LocalDateTime weekday = LocalDateTime.of(2022, 1, 20, 19, 0);
        LocalDateTime weekend = LocalDateTime.of(2022, 1, 15, 19, 0);
        PremiumExtra premiumExtra = new PremiumExtra(List.of("dinner"), 50);

        assertTrue(new PremiumBooking(lionKing, weekday, premiumExtra).hasDinner());
        assertFalse(new PremiumBooking(lionKing, weekend, premiumExtra).hasDinner());
    }

}