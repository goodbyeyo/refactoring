package study.refactoring._06_mutable_data._02_separate_query_from_modifier;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CriminalRefactorTest {

    @Test
    void alertForMiscreant() {
        CriminalRefactor criminal = new CriminalRefactor();
        String found = criminal.findMiscreant(List.of(new Person("Keesun"), new Person("Don")));
        assertEquals("Don", found);

        found = criminal.findMiscreant(List.of(new Person("John"), new Person("Don")));
        assertEquals("John", found);

        found = criminal.findMiscreant(List.of(new Person("Keesun"), new Person("Whiteship")));
        assertEquals("", found);
    }

}