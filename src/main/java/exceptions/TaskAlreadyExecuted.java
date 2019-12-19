package exceptions;

import network.Task;

/**
 * When want to edit a Task bu it has already been executed
 * */
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
