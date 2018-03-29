package simplecrash;

public class SomeRandomClass {

    private LetItCrash letItCrash;

    public void randomStuff() {
        // If we are inside a Package we need a call to
        // makeItLongerAndCrash to make it crash. Without
        // a package it will crash even without such a call.
        letItCrash.makeItLongerAndCrash();
    }
}
