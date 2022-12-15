package uk.ac.rgu.cm2115;

public class StatusButtons {
    CommandPattern commandPattern;

    public StatusButtons(CommandPattern newCommandPattern) {
        commandPattern = newCommandPattern;
    }

    public void press() {
        commandPattern.execute();
    }
}
