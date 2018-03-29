package simplecrash;

public class LetItCrash implements CrashyInterface {
    private Long longer = 0L;

    @Override
    public void makeItLongerAndCrash() {
        this.longer += 0;

        // this.longer = this.longer + 0
        // Fixes the crash
    }

// Implement some random other method fixes the crash
//    public void doSomeHardWork() {
//
//    }
}
