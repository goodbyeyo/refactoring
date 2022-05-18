package study.refactoring._07_divergent_change._26_extract_class;

public class PersonBefore {

    private String name;

    private String officeAreaCode;

    private String officeNumber;

    public String telephoneNumber() {
        return this.officeAreaCode + " " + this.officeNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOfficeAreaCode() {
        return officeAreaCode;
    }

    public void setOfficeAreaCode(String officeAreaCode) {
        this.officeAreaCode = officeAreaCode;
    }

    public String getOfficeNumber() {
        return officeNumber;
    }

    public void setOfficeNumber(String officeNumber) {
        this.officeNumber = officeNumber;
    }
}
