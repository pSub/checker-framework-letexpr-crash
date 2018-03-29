package advancedcrash;

public class LetItCrash implements SomeInterface {

    // This time we use Integer. However a crash cannot
    // be triggered if String is used.
    private Integer longer = 0;

    // This time implementing other methods does not
    // fix the crash. Even if those methods do not
    // belong to SomeInterface.
    @Override
    public void doSomethingFancy() {
        System.out.print("Yay");
    }

    @Override
    public void makeItLongerAndCrash() {
        this.longer += 0;
    }
}
