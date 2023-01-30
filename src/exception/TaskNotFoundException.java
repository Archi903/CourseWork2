package exception;

import datebook.Task;

public class TaskNotFoundException extends Exception {
private final Task id;

    public TaskNotFoundException(String message, Task id) {
        super(message);
        this.id = id;
    }

    public Task getId() {
        return id;
    }
}
