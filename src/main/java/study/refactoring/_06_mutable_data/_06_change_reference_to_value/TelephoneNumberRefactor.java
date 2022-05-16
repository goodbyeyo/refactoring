package study.refactoring._06_mutable_data._06_change_reference_to_value;

import java.util.Objects;

public class TelephoneNumberRefactor {

    private final String areaCode;

    private final String number;

    // 1. 생성자 추가
    // 2. setter() 삭제
    // 3. equals() 와 hashCode() 추가

    public TelephoneNumberRefactor(String areaCode, String number) {
        this.areaCode = areaCode;
        this.number = number;
    }

    public String areaCode() {
        return areaCode;
    }

    public String number() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TelephoneNumberRefactor that = (TelephoneNumberRefactor) o;
        return Objects.equals(areaCode, that.areaCode) &&
                Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(areaCode, number);
    }
}
