package me.whiteship.refactoring._06_mutable_data._06_change_reference_to_value;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TelephoneNumberRefactorTest {

    @Test
    void testEquals() {
        TelephoneNumberRefactor number1 = new TelephoneNumberRefactor("123", "1234");
        TelephoneNumberRefactor number2 = new TelephoneNumberRefactor("123", "1234");
        assertEquals(number1, number2);
    }

}