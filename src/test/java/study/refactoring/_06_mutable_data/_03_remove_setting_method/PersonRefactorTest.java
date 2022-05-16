package study.refactoring._06_mutable_data._03_remove_setting_method;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonRefactorTest {

    @Test
    void person() {
        PersonRefactor person = new PersonRefactor(10);
        person.setName("keesun");
        assertEquals(10, person.getId());
        assertEquals("keesun", person.getName());
        person.setName("whiteship");
        assertEquals("whiteship", person.getName());
    }

}