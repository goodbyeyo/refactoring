package me.whiteship.refactoring._06_mutable_data._06_change_reference_to_value;

public class TelephoneNumberBuilder {

    private String areaCode;

    private String number;

    public String getAreaCode() {
        return areaCode;
    }

    public TelephoneNumberBuilder setAreaCode(String areaCode) {
        this.areaCode = areaCode;
        return this;
    }

    public String getNumber() {
        return number;
    }

    public TelephoneNumberBuilder setNumber(String number) {
        this.number = number;
        return this;
    }
}
