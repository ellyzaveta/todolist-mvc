package controller;

import model.TodoService;
import model.data.Task;
import model.data.TaskStatus;
import view.TodoViewGUI;

public class TodoControllerGUI {
    private final TodoService model;
    private final TodoViewGUI view;

    public TodoControllerGUI() {
        this.model = new TodoService();
        this.view = new TodoViewGUI();

        initView();
    }

    public void initView() {
        view.getTaskList().setModel(model.getAll());
        attachEventHandlers();

        view.setVisible(true);
    }

    private void attachEventHandlers() {
        view.getAddButton().addActionListener(e -> addTask());
        view.getDeleteButton().addActionListener(e -> deleteTask());
        view.getChangeStatusButton().addActionListener(e -> updateTaskStatus());
    }

    private void addTask() {
        String description = view.getTaskInput().getText();
        if (!description.isEmpty()) {
            model.add(new Task(description, TaskStatus.NOT_DONE));
            view.getTaskInput().setText("");
        }
    }

    private void deleteTask() {
        int selectedIndex = view.getTaskList().getSelectedIndex();
        model.remove(selectedIndex);
    }

    private void updateTaskStatus() {
        int selectedIndex = view.getTaskList().getSelectedIndex();
        model.updateStatus(selectedIndex);
    }
}

