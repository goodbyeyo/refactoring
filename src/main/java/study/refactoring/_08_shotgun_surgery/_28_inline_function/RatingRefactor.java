package study.refactoring._08_shotgun_surgery._28_inline_function;

public class RatingRefactor {

    public int rating(Driver driver) {
        // Ctrl + Alt + N : Inline function
        return driver.getNumberOfLateDeliveries() > 5 ? 2 : 1;
    }

}
