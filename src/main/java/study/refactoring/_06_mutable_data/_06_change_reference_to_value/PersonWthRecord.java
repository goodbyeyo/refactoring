package study.refactoring._06_mutable_data._06_change_reference_to_value;

public class PersonWthRecord {

    private TelephoneNumberRecord officeTelephoneNumber;

    public String officeAreaCode() {
        return this.officeTelephoneNumber.areaCode();
    }

    public void officeAreaCode(String areaCode) {
        this.officeTelephoneNumber = new TelephoneNumberRecord(areaCode, this.officeNumber());
    }

    public String officeNumber() {
        return this.officeTelephoneNumber.number();
    }

    public void officeNumber(String number) {
        this.officeTelephoneNumber = new TelephoneNumberRecord(number, this.officeAreaCode());
    }

}
