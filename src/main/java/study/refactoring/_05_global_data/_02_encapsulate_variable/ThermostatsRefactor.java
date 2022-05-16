package study.refactoring._05_global_data._02_encapsulate_variable;

public class ThermostatsRefactor {

    private static Integer targetTemperature = 70;

    private static Boolean heating = true;

    private static Boolean cooling = false;

    private static Boolean fahrenheit = true;

    public static Integer getTargetTemperature() {
        return targetTemperature;
    }

    public static void setTargetTemperature(Integer targetTemperature) {
        ThermostatsRefactor.targetTemperature = targetTemperature;
    }

    public static Boolean getHeating() {
        return heating;
    }

    public static void setHeating(Boolean heating) {
        // TODO validation :
        ThermostatsRefactor.heating = heating;
        // TODO notify : ex : google, nest, noti, alim
    }

    public static Boolean getCooling() {
        return cooling;
    }

    public static void setCooling(Boolean cooling) {
        ThermostatsRefactor.cooling = cooling;
    }

    public static Boolean getFahrenheit() {
        return fahrenheit;
    }

    public static void setFahrenheit(Boolean fahrenheit) {
        ThermostatsRefactor.fahrenheit = fahrenheit;
    }

    public static void setReadInFahrenheit(Boolean fahrenheit) {
        ThermostatsRefactor.fahrenheit = fahrenheit;
    }
}
