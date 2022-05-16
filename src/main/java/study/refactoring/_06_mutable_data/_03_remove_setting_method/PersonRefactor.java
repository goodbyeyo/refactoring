package study.refactoring._06_mutable_data._03_remove_setting_method;

public class PersonRefactor {

    private String name;

    private int id;

    public PersonRefactor(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }
}
