package model.data;

public class Task {
    private final String description;
    private TaskStatus status;

    public Task(String description, TaskStatus status) {
        this.description = description;
        this.status = status;
    }

    public void setNextStatus() {
        switch (this.status) {
            case NOT_DONE -> this.status = TaskStatus.IN_PROGRESS;
            case IN_PROGRESS -> this.status = TaskStatus.DONE;
            case DONE -> this.status = TaskStatus.NOT_DONE;
        }
    }

    public TaskStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return description + "  (" + status + ")";
    }
}

