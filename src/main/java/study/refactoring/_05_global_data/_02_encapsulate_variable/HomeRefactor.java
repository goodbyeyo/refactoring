package study.refactoring._05_global_data._02_encapsulate_variable;

public class HomeRefactor {

    public static void main(String[] args) {
        System.out.println(ThermostatsRefactor.getTargetTemperature());
        ThermostatsRefactor.setTargetTemperature(68);
        ThermostatsRefactor.setFahrenheit(false);
    }
}
