package model.data;

public enum TaskStatus {
    DONE("done"),
    IN_PROGRESS("in progress"),
    NOT_DONE("not done");

    private final String displayValue;

    TaskStatus(String displayValue) {
        this.displayValue = displayValue;
    }

    @Override
    public String toString() {
        return displayValue;
    }
}
