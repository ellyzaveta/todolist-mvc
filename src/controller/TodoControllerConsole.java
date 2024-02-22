package controller;

import model.TodoService;
import model.data.Task;
import model.data.TaskStatus;
import view.TodoViewConsole;

public class TodoControllerConsole {
    private final TodoService model;
    private final TodoViewConsole view;

    public TodoControllerConsole() {
        this.model = new TodoService();
        this.view = new TodoViewConsole();

        start();
    }

    private void start() {
        boolean running = true;
        while (running) {

            view.displayTasks(model.getAll());

            int choice = view.getMainMenuChoice();

            switch (choice) {
                case 1 -> addTask();
                case 2 -> deleteTask();
                case 3 -> updateStatus();
                case 4 -> running = false;
                default -> view.showInvalidChoiceMessage();
            }
        }
    }

    private void addTask() {
        String description = view.getTaskDescription();
        if (!description.isEmpty()) {
            model.add(new Task(description, TaskStatus.NOT_DONE));
        } else {
            view.showInvalidTaskDescriptionMessage();
        }
    }

    private void deleteTask() {
        int index = view.getTaskIndex() - 1;
        if (isIndexValid(index)) {
            model.remove(index);
        } else {
            view.showInvalidTaskIndexMessage();
        }
    }

    private void updateStatus() {
        int index = view.getTaskIndex() - 1;
        if (isIndexValid(index)) {
            model.updateStatus(index);
        } else {
            view.showInvalidTaskIndexMessage();
        }
    }

    private boolean isIndexValid(int index) {
        return (index >= 0 && index < model.getAll().size());
    }
}
