package exceptions;

import network.Task;

public class TaskAlreadyExecuted extends Exception {
    private Task task;

    public TaskAlreadyExecuted(String message, Task task){
        super(message);
        this.task = task;
    }

    public Task getTask() {
        return task;
    }
}
