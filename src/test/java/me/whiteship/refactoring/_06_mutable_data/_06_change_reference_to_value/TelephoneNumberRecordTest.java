package me.whiteship.refactoring._06_mutable_data._06_change_reference_to_value;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TelephoneNumberRecordTest {

    @Test
    void testEquals() {
        TelephoneNumberRecord number1 = new TelephoneNumberRecord("123", "1234");
        TelephoneNumberRecord number2 = new TelephoneNumberRecord("123", "1234");
        assertEquals(number1, number2);
    }


}