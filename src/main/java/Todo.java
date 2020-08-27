class Todo extends Task {
    Todo(String message) {
        super(message);
    }

    Todo(String message, boolean isDone) {
        super(message, isDone);
    }

    @Override
    public String getPureTypeLetter() {
        return "T";
    }

    @Override
    public String getTypeLetter() {
        // dummy value
        return "[T]";
    }
}
