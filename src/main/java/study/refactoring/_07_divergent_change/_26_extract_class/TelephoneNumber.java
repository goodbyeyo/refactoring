package study.refactoring._07_divergent_change._26_extract_class;

public class TelephoneNumber {
    private String areaCode;
    private String officeNumber;

    public TelephoneNumber() {
    }

    public String officeAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String officeNumber() {
        return officeNumber;
    }

    public void setOfficeNumber(String officeNumber) {
        this.officeNumber = officeNumber;
    }
}