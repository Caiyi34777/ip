public class Deadline extends Task {
    Deadline(String message) {
        super(message);
    }

    Deadline(String message, boolean isDone) {
        super(message, isDone);
    }

    @Override
    public String getPureTypeLetter() {
        return "D";
    }

    @Override
    public String getTypeLetter() {
        // dummy value
        return "[D]";
    }

    @Override
    public String getPrintMessage() {
        return Convert.by(getMessage());
    }

    @Override
    public String getStoreMessage() {
        return Convert.byDigitalDate(getMessage());
    }
}