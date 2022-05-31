package study.refactoring._18_middle_man._40_replace_subclass_with_delegate;

public class PremiumDelegate2 {

    private Booking2 host;

    private PremiumExtra extra;

    public PremiumDelegate2(Booking2 host, PremiumExtra extra) {
        this.host = host;
        this.extra = extra;
    }

    public boolean hasTalkback() {
        return this.host.show.hasOwnProperty("talkback");
    }


}
